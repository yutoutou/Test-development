package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToastTest {
    public static AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        try{
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("appPackage", "io.appium.android.apis");
            caps.setCapability("appActivity", "io.appium.android.apis.view.PopupMenul");
            //设置是否弹框
            caps.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void toastTest(){
        driver.findElement(By.xpath("//*[@text='Make a Popup!']")).click();
        System.out.println(driver.getPageSource());
        driver.findElement(By.xpath("//*[@text='Search']")).click();

        System.out.println(driver.findElement(By.xpath("//*[@class='android.widget.Toast']")));
        System.out.println(driver.getPageSource());
    }
}
