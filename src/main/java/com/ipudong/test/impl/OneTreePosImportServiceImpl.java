package com.ipudong.test.impl;




import com.ipudong.test.dao.OneTreePosInfoDao;
import com.ipudong.test.entity.OneTreePosDO;
import com.ipudong.test.service.OneTreeInsertService;
import com.ipudong.test.service.OneTreePosImportService;
import com.ipudong.test.util.MsgException;
import com.ipudong.test.util.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@Service
public class OneTreePosImportServiceImpl implements OneTreePosImportService {

    protected static transient Logger logger = LoggerFactory.getLogger(OneTreePosImportServiceImpl.class);
    @Autowired
    private OneTreeInsertService oneTreeInsertService;
    @Autowired
    private OneTreePosInfoDaoImpl oneTreePosInfoDaoImpl;

    @Override
    public Result<Boolean> fetchPosFromOperations(Long startTime, Long endTime) {

        if (startTime == null || endTime == null) {
            logger.info("时间参数未填写");
            return new Result<>(new MsgException("必填参数未填"));
        }
        if (startTime >= endTime) {
            logger.info("开始时间大于结束时间：startTime为{},endTime为{}",startTime,endTime);
            return new Result<>(new MsgException("开始时间不能大于结束时间"));
        }

        String startTimeString = toDate(startTime);
        String endTimeString = toDate(endTime);
        logger.info("查询数据的开始时间：{}，结束时间{}", startTimeString, endTimeString);

        //查询一树时间段内的POS机销售数据
        OneTreePosInfoDao oneTreePosInfoDao = new OneTreePosInfoDaoImpl();
        //1、连接数据库
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Date date1 = new Date();
        logger.info("VPN连接开始,时间为{}",date1.getTime());
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            String url = "jdbc:postgresql://10.10.11.70:5432/parent";
            conn = DriverManager.getConnection(url, "pudong",
                    "pudong");
        } catch (Exception e) {
            logger.info("VPN连接失败，连接时长{}",(new Date().getTime() - date1.getTime()));
        }
        /**
         * sql语句
         */
        String sql = "select d.receiptno as serial_num,d.store_cd,s.\"name\" as store_name,t.clerkname,t.memberno,d.sku_cd,i.\"name\" as sku_name,d.salesqty,d.company_cd,c.\"name\" as company_name,d.pos_cd,p.\"name\" as pos_name,t.casher_cd,t.cashername,\n" +
                "\t\t\t d.receiptdate,d.rsvchar1,d.rsvchar2,d.rsvchar3,d.rsvchar4,d.saleskngk,(case when d.saleskngk=0 then 0 else d.salesgross/d.saleskngk end) rate,d.salesitgnk * salesqty as salesitgnk,d.salesgross,\n" +
                "\t\t\t d.receipttype,d.class1_cd,c1.\"name\" as dlname,d.class2_cd,c2.\"name\" as zlname,\n" +
                "\t\t\t d.class3_cd,c3.\"name\" as xlname,(t.regularpricekngk-saleskngksum) less\n" +
                "from utr_salesreceiptdetail d\n" +
                "LEFT JOIN umf_store s on d.store_cd = s.store_cd \n" +
                "LEFT JOIN utr_salesreceiptheader t on d.receiptno = t.receiptno\n" +
                "LEFT JOIN umf_item i on d.sku_cd = i.sku_cd\n" +
                "LEFT JOIN umf_company c on d.company_cd = c.company_cd\n" +
                "LEFT JOIN umf_pos p on d.pos_cd = p.pos_cd\n" +
                "LEFT JOIN umf_class c1 on d.class1_cd = c1.class_cd\n" +
                "LEFT JOIN umf_class c2 on d.class2_cd = c2.class_cd\n" +
                "LEFT JOIN umf_class c3 on d.class3_cd = c3.class_cd\n" +
                "where d.adddatetime >=  ? and d.adddatetime <  ?\n" +
                "limit 500 offset ?";
        int j = 0;
        int offset = 0;//设置查询位置
        while (offset >= 0) {
            offset = j*500;
            List oneTreePosInfosList = oneTreePosInfoDao.query(conn, pstmt, rs, startTimeString, endTimeString, offset, sql);
            if (offset == 0 && (oneTreePosInfosList == null || oneTreePosInfosList.size()==0)){
                logger.info("查询一树POS无数据返回");
                return new Result<>(new MsgException("无数据返回"));
            }
            if (offset > 0 && (oneTreePosInfosList == null || oneTreePosInfosList.size() < 500)) {
                logger.info("POS数据查询结束");
                logger.info("查询数据一共有{}条", offset+oneTreePosInfosList.size());
                offset = -1;//结束循环
            }
            /**
             * 将查询出来的数据转换成OneTreePosDO
             */
            List<OneTreePosDO> list = new ArrayList<>();
            for (int i=0;i<oneTreePosInfosList.size();i++)
            {
                OneTreePosDO oneTreePosDO = new OneTreePosDO();
                Map myMap = (Map)oneTreePosInfosList.get(i);

                //将得到的数据封装
                oneTreePosDO.setSerialNum((String) myMap.get("serial_num")); //根据列名获取数据
                oneTreePosDO.setShopCode((String) myMap.get("store_cd"));
                oneTreePosDO.setShopName((String) myMap.get("store_name"));
                //oneTreePosDO.setClerkCode((String) myMap.get(""));
                //oneTreePosDO.setClerkName((String) myMap.get(""));
                oneTreePosDO.setCardNum((String) myMap.get("memberno"));
                oneTreePosDO.setGoodsCode((String) myMap.get("sku_cd"));
                oneTreePosDO.setGoodsName((String) myMap.get("sku_name"));
                oneTreePosDO.setGoodsNum(getInteger((String) myMap.get("salesqty")));
                oneTreePosDO.setCompanyCode((String) myMap.get("company_cd"));
                oneTreePosDO.setCompanyName((String) myMap.get("company_name"));
                oneTreePosDO.setPosCode((String) myMap.get("pos_cd"));
                oneTreePosDO.setPosName((String) myMap.get("pos_name"));
                oneTreePosDO.setCashierCode((String) myMap.get("casher_cd"));
                oneTreePosDO.setCashierName((String) myMap.get("cashername"));
                String dateString = (String) myMap.get("receiptdate");
                oneTreePosDO.setOcrtime(toDate(dateString));
                //oneTreePosDO.setOcrtime((Date) myMap.get("receiptdate"));
                //oneTreePosDO.setFx4((String) myMap.get(""));
                //oneTreePosDO.setFx6((String) myMap.get(""));
                // oneTreePosDO.setFx7((String) myMap.get(""));
                // oneTreePosDO.setFx8((String) myMap.get(""));
                oneTreePosDO.setRealamt(new BigDecimal((String) myMap.get("saleskngk")));
                oneTreePosDO.setGrossRate(new BigDecimal((String) myMap.get("rate")));
                oneTreePosDO.setCostPrice(new BigDecimal((String) myMap.get("salesitgnk")));
                oneTreePosDO.setGrossPrice(new BigDecimal((String) myMap.get("salesgross")));
                //oneTreePosDO.setBusinessType((String) myMap.get(""));
                oneTreePosDO.setDlcode((String) myMap.get("class1_cd"));
                oneTreePosDO.setDlname((String) myMap.get("dlname"));
                oneTreePosDO.setZlcode((String) myMap.get("class2_cd"));
                oneTreePosDO.setZlname((String) myMap.get("zlname"));
                oneTreePosDO.setXlcode((String) myMap.get("class3_cd"));
                oneTreePosDO.setXlname((String) myMap.get("xlname"));
                // oneTreePosDO.setFavamt((BigDecimal) myMap.get(""));
                //oneTreePosDO.setCouponCode((String) myMap.get(""));
                //oneTreePosDO.setCouponRealamt((String) myMap.get(""));
                // oneTreePosDO.setCouponUseNum((String) myMap.get(""));
                Date date = new Date();
                oneTreePosDO.setCreatedTime(date);
                oneTreePosDO.setUpdatedTime(date);

                list.add(oneTreePosDO);
            }
            /**
             * 批量插入pos_tree
             */
            Date date = new Date();
            logger.info("将查询到的POS数据插入扑咚数据库，插入时间{}",date.getTime());
            oneTreeInsertService.insert(list);
            logger.info("POS数据插入结束，时长{}", (new Date().getTime() - date.getTime()));
            j++;
        }
        return new Result<>(Boolean.TRUE);
    }

    /**
     * 将毫秒数转换成日期格式
     * @param time
     * @return
     */
    public String toDate(Long time) {
        Date dat = new Date(time);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dat);
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stringTime=format.format(gc.getTime());
        return stringTime;
    }

    /**
     * String转换成integer
     * @param param
     * @return
     */
    public Integer getInteger(String param) {
        Integer integer = null;
        int index = param.indexOf(".");
        param = param.substring(0,index);
        if (param != null) {
            integer = Integer.valueOf(param);
        }
        return integer;
    }

    public Date toDate(String param){
        int index = param.indexOf(".");
        param = param.substring(0,index);
        SimpleDateFormat dtf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dtf.parse(param);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        return date;
    }
}
