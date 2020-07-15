package com.testcase;

import org.junit.Test;

import java.util.HashMap;

public class LoginTest extends BaseTest{
    @Test
    public void login(){
        dataMap.put("login", "登录成功");
        System.out.println(dataMap.get("login"));
    }
}
