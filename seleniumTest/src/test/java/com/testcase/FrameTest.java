package com.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FrameTest extends Basetest{
    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");

        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());

        //跳出原来的frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }
}
