package com.ipudong.test.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface OneTreePosInfoDao {

    /**
     * 查询一树数据库的POS数据
     * @param startTime
     * @param endTime
     * @return
     */
    List query(Connection conn, PreparedStatement pstmt, ResultSet rs, String startTime, String endTime, int offset, String sql);
}
