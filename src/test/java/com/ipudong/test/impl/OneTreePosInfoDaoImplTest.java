package com.ipudong.test.impl;

import com.ipudong.test.dao.OneTreePosInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest


public class OneTreePosInfoDaoImplTest {
    OneTreePosInfoDao oneTreePosInfoDao = new OneTreePosInfoDaoImpl();

   /* @Test
    public void query() throws Exception {
        List list = oneTreePosInfoDao.query("2018-05-07 15:45:00", "2018-05-07 15:46:00");
        System.out.println(list.size());
    }*/

}