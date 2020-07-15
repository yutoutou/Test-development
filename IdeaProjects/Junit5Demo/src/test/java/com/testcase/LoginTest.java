package com.testcase;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoginTest {
    private static HashMap<String, Object>dataMap = new HashMap<String, Object>();

    @Test
    void loginTest(){
        dataMap.put("login", "登录成功");
    }

    @Nested
    class PayTest{
        @Test
        void payTest(){
            if (null!=dataMap.get("buy")){
                System.out.println("正在支付，请等待");
                System.out.println(dataMap.get("buy"));
            }else{
                System.out.println("你还没购买课程，赶紧去买吧");
                System.out.println(dataMap.get("buy"));
            }
        }
    }

    @Nested
    class BuyTest{
        @Test
        void buyTest(){
            if(dataMap.get("login").equals("登录成功")){
                System.out.println("登录成功啦，可以购买东西啦");
                dataMap.put("buy", "购买了霍格沃兹测试学院的名企定向课程");
            }else{
                System.out.println("登录失败啦，需要重新登录");
            }
        }
    }
}
