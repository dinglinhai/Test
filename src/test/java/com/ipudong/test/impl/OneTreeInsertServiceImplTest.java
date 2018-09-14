package com.ipudong.test.impl;

import com.ipudong.test.dao.OneTreePosDao;
import com.ipudong.test.entity.OneTreePosDO;
import com.ipudong.test.service.OneTreeInsertService;
import com.ipudong.test.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneTreeInsertServiceImplTest {

    @Autowired
    private OneTreePosDao oneTreePosDao;
    @Autowired
    OneTreePosImportServiceImpl oneTreePosImportService;
    @Autowired
    OneTreeInsertService oneTreeInsertService;

    @Test
    public void insert() throws Exception {
        List<OneTreePosDO> list = new ArrayList<>();
        OneTreePosDO oneTreePosDO1 = new OneTreePosDO();
        oneTreePosDO1.setSerialNum("1");
        oneTreePosDO1.setShopName("aaa");
        oneTreePosDO1.setCreatedTime(new Date());

        OneTreePosDO oneTreePosDO2 = new OneTreePosDO();
        oneTreePosDO2.setSerialNum("2");
        oneTreePosDO2.setShopName("bbb");
        oneTreePosDO2.setCreatedTime(new Date());

        list.add(oneTreePosDO1);
        list.add(oneTreePosDO2);

        oneTreePosDao.insertBatch(list);

    }
    @Test
    public void OneTreePosImportServiceImpl() throws Exception {
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = "2018-05-07 15:45:00";
        String end = "2018-05-07 15:46:00";
        Long endTime = null;
        Long startTime = null;
        Date dateStart = format.parse(start);
        System.out.println(dateStart);
        Date dateEnd = format.parse(end);
        System.out.println(dateEnd);
        startTime = dateStart.getTime();
        endTime = dateEnd.getTime();
        System.out.println(startTime);
        System.out.println(end);
        System.out.println("开始执行");

        Result<Boolean> result = oneTreePosImportService.fetchPosFromOperations(startTime,endTime);
        if (result != null && result.isSuccess() && result.getModel() != null) {
            System.out.println("执行结果"+result.getModel());
        }else {
            System.out.println("执行失败");
        }
    }

    @Test
    public void getPos() {
        String num = oneTreePosDao.getPos(3162542L);
        if (num != null && ! "".equals(num)) {
            System.out.println(num);
        } else {
            System.out.println("查询失败");
        }
    }

}