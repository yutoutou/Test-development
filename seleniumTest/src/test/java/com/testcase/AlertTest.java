package com.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AlertTest extends Basetest{

    @Test
    public void alertTest(){
        try {
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            driver.switchTo().frame("iframeResult");

            Actions actions = new Actions(driver);
            actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();

            Thread.sleep(5000);
            driver.switchTo().alert().accept();
            driver.switchTo().parentFrame();

            System.out.println(driver.findElement(By.id("submitBTN")).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
