package com.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
    }

    @Test
    public void browserTest(){
        driver.get("https://www.baidu.com");
    }
}
