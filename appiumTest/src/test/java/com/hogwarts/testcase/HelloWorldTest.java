package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelloWorldTest {
    private static AppiumDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setUp(){
        try{
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("udid", "emulator-5554");
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

    @Test
    public void helloSnowBallTest(){
        //定位首页的搜索框
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        //定位搜索页的搜索框
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");

        //
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println(driver.findElement(By.id("current_price")).getText());

    }

    @Test
    public void swipeTest(){
        try {
            int width = driver.manage().window().getSize().getWidth();
            int height = driver.manage().window().getSize().getHeight();

            Thread.sleep(7000);

            TouchAction touchActions = new TouchAction(driver);
            touchActions.press(PointOption.point((int)(width*0.5), (int)(height*0.8))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point((int)(width*0.5), (int)(height*0.2))).release().perform();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        }
}
