package com.ipudong.test.impl;

import com.ipudong.test.service.Test;

/**
 * @Author dinglinfang
 * @Date: 2018/9/14 17:44
 */
public class TestImpl implements Test {
    @Override
    public String sayHello() {
        String s = "Hello World!";
        System.out.println(s);
        System.out.println("测试推送");
        return s;
    }
}
