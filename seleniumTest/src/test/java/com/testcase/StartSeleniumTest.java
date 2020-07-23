package com.testcase;
/*
 **** @Author: janelyhuang
 **** @Title:
 **** @Package:
 **** @Description:
 **** @Time: 2020/7/15 23:48
 */

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class StartSeleniumTest extends Basetest{
    @Test
    public void startSelenium(){
        //System.setProperty("webdriver.chrome.driver", "/Users/wecash/Library/chromedriver");
        driver.get("https://home.testing-studio.com/");
        driver.findElement(By.xpath("//span[contains(text(), '登录')]")).click();
    }
}
