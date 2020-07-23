package com.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Basetest {

    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
