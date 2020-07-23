package com.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JsTest extends Basetest{

    @Test
    public void jsTest(){
        try {
            driver.get("https:www.12306.cn/index/");

            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            Thread.sleep(4000);

            jsDriver.executeScript("document.getElementById('train_date').value='2020-12-30'");
            Thread.sleep(4000);

            System.out.println(jsDriver.executeScript("return document.getElementById('train_date').value"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
