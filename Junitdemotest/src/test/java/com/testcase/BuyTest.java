package com.testcase;

import org.junit.Test;

public class BuyTest extends BaseTest{
    @Test
    public void buy(){
        if (dataMap.get("login").equals("登录成功")){
            System.out.println("登录成功，可以购买");
        }
        else{
            System.out.println("没登录，需要登录才能购买");
        }
    }
}
