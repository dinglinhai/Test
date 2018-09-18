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
        System.out.println("测试提交");

        /**
         * 从dev分支拉下change分支，在change分支上编辑。dev分支也会变化？
         */
        System.out.println("测试拉取分支变化");
        return s;
    }
}
