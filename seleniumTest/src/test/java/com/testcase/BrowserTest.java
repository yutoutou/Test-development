package com.testcase;


import org.junit.jupiter.api.Test;

public class BrowserTest extends Basetest{
    @Test
    public void browserTest(){
        driver.get("https://www.baidu.com");
    }
}
