package com.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UploadTest extends Basetest{

    @Test
    public void uploadTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("/Users/wecash/Desktop/tiger.jpeg");

            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
