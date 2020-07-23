package com.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class WindowTest extends Basetest{

    @Test
    public void switchWindowTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='u1']/a[2]")).click();

        String baiduWin = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();
        System.out.println(baiduWin);
        System.out.println(driver.getWindowHandles());

        for (String win:driver.getWindowHandles()){
            if (!win.equals(baiduWin)){
                driver.switchTo().window(win);
                driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("ashin");
                driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("15313006136");

                driver.switchTo().window(baiduWin);
                driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();

                driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("范范—四叶草");
                driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("vic725%@)hy");

                Thread.sleep(3000);
                driver.findElement(By.id("TANGRAM__PSP_11__submit")).click();
            }
        }
    }
}
