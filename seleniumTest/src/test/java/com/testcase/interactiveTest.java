package com.testcase;

import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class interactiveTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void clickTest(){
        try{
            driver.get("http://sahitest.com/demo/clicks.htm");
//            Actions actions = new Actions(driver);
            actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
            actions.doubleClick(driver.findElement(By.xpath("//input[@value='dbl click me']")));
            actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));

            actions.perform();
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void moveTest(){
        try{
            driver.get("https://www.baidu.com");
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void dragTest() {
        try {
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            //把drag me 拖拽到item4中
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//*[@class='item'][last()]"))).perform();
//            actions.dragAndDrop(driver.findElement(By.xpath("")));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keyBoardTest(){
        try {
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("ashin");

            actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
            actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
            actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1), Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void scrollTest(){
        try{
            driver.get("https://www.baidu.com");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
            TouchActions action = new TouchActions(driver);
            action.click(driver.findElement(By.id("su")));

            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
            jsDriver.executeScript("window.scrollBy(0, document.body.scrollHeight)");
            Thread.sleep(4000);

            driver.findElement(By.xpath("//a[@class='n']")).click();
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
