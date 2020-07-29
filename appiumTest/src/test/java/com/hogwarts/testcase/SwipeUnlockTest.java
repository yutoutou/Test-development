package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeUnlockTest {
    public static AppiumDriver driver;
    public WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        try{
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("udid", "emulator-5554");
            caps.setCapability("deviceName", "emulator-5554");
            caps.setCapability("appPackage", "cn.kmob.screenfingermovelock");
            caps.setCapability("appActivity", "com.samsung.ui.FlashActivity");
            //设置是否弹框
            caps.setCapability("noReset", "true");

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void unlockTest() throws Exception{
        TouchAction touchAction = new TouchAction(driver);

        Duration duration = Duration.ofMillis(3000);

        driver.findElement(By.id("cn.kmob.screenfingermovelock:id/patternTxt")).click();
        Thread.sleep(3000);
        touchAction.press(PointOption.point(248, 389)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(770, 381)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1286, 400)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1286, 400)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1289, 894)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(1288, 1409)).waitAction(WaitOptions.waitOptions(duration)).perform();
    }
}
