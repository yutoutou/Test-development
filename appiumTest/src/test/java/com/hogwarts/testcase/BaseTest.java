package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        try{
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("udid", "MQS0219827054149");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("appPackage", "com.xueqiu.android");
            caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
            //设置是否弹框
            caps.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
