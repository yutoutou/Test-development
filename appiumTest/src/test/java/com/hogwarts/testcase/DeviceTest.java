package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DeviceTest {
    public static AndroidDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void initData() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "emulator-5554");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void callTest() throws Exception{
        driver.makeGsmCall("5551234567", GsmCallActions.CALL);
        Thread.sleep(5000);
        driver.sendSMS("555-123-4567", "Appium send message");
    }

    @Test
    public void netTest() throws Exception{
//        driver.toggleAirplaneMode();
//        Thread.sleep(5000);
        driver.toggleWifi();
        Thread.sleep(5000);
        driver.toggleData();
        Thread.sleep(5000);
    }

    @Test
    public void screenTest() throws Exception{
        //切换成横屏
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(5000);
        //切换成竖屏
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(5000);
    }

    @Test
    public void screenShotTest() throws Exception{
        Thread.sleep(3000);
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/demo.png");
        FileUtils.copyFile(screenshotAs, file);
    }
}
