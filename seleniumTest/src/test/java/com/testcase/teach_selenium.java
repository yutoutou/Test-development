package com.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class teach_selenium{
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void login(){
        driver.get("https://home.testing-studio.com/");

        driver.findElement(By.xpath("//span[contains(text(), '登录')]")).click();

        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("janet278@163.com");

        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("0520530233hy");

//        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void timeSleepTest(){
        driver.get("https://home.testing-studio.com/");
        try{
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[contains(text(), '登录')]")).click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Test
    public void waitTest(){
        driver.get("https://home.testing-studio.com/");

        //driver.findElement(By.xpath("//span[contains(text(), '登录')]")).click();

        WebElement loginEle = wait.until(new ExpectedCondition<WebElement>(){
            public WebElement apply(WebDriver driver){
                return driver.findElement(By.xpath("//span[contains(text(), '登录')]"));
            }
        });
        loginEle.click();

//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '登录')]")));
//        element.click();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
