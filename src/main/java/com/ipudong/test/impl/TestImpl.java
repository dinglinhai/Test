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

        /**
         * 在本地dev拉取新的分支change（也是本地分支），在change上进行改动时，没有提交的时候，dev分支也会有相应改动（猜测是因为在本地改动，大家同用一个暂存区），当change分支上的改动提交推送到远端之后，本地dev分支就没有改动的代码了（猜测是提交推送之后，暂存区的代码就清空了）
         */
        System.out.println("测试拉取分支变化");

        return s;
    }
}
