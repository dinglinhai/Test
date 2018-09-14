package com.ipudong.test.impl;



import com.ipudong.test.dao.OneTreePosInfoDao;
import com.ipudong.test.time.fetchOneTreePosYesterdayJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OneTreePosInfoDaoImpl implements OneTreePosInfoDao {
    protected static transient Logger logger = LoggerFactory.getLogger(OneTreePosInfoDaoImpl.class);
    @Override
    public List query(Connection conn, PreparedStatement pstmt, ResultSet rs, String startTime, String endTime, int offset, String sql) {
        List list = new ArrayList<>();
        Timestamp start = Timestamp.valueOf(startTime);
        Timestamp end = Timestamp.valueOf(endTime);

        Date date1 = new Date();
        logger.info("查询第{}页数据,时间为{}", (offset/500)+1, date1.getTime());
        try {
            pstmt = conn.prepareStatement(sql);
            //传入参数
            pstmt.setTimestamp(1, start);
            pstmt.setTimestamp(2, end);
            pstmt.setInt(3, offset);
            rs = pstmt.executeQuery();

            int count = 0;

            //获取ResultSet的元数据
            ResultSetMetaData md = rs.getMetaData();
            String cols_name = "";
            while (rs.next()) {
                Map data = new HashMap();
                count++;
                for (int i = 0; i < md.getColumnCount(); i++)//遍历此行的所有列
                {
                    cols_name = md.getColumnName(i + 1);//取出列名
                    Object val= rs.getObject(cols_name);//根据列名取出数据
                    val = (val == null) ? "":val;//格式化空值
                    data.put(cols_name, ""+val);

                }
                list.add(data);
            }
        } catch (Exception e) {
            logger.info("查询第{}页数据失败，查询时长{}",(offset/500)+1, new Date().getTime() - date1.getTime());
            System.out.print("exception:" + e.getMessage());
        }
        logger.info("查询第{}页数据结束，查询时长{}，查询条数{}",(offset/500)+1, new Date().getTime() - date1.getTime(), list.size());

        //数据查询结束
        if (list.size() < 500) {
            try {
                logger.info("数据查询结束，关闭数据库连接");
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                logger.info("关闭数据库连接失败");
            }
        }
        return list;
    }
}
