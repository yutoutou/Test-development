package com.hogwarts.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.UriSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSnowBall extends BaseTest{
    @Test
    public void TestSearch(){
       WebElement elem = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
       System.out.println("搜索框是否可用？ " + elem.isEnabled());
       System.out.println("搜索框的坐标： " + elem.getLocation());
       System.out.println("搜索框的宽高：" + elem.getSize());
       elem.click();
       driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
       WebElement conn = driver.findElement(By.xpath("//*[@text='BABA']"));
        if (conn.isDisplayed()){
           System.out.println("搜索成功");
           conn.click();
       }else{
           System.out.println("搜索失败");
       }
    }

    @Test
    public void priceTest(){
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).click();
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        System.out.println(driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText());
    }

    @Test
    public void uiautomatorSelectTest(){
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").text(\"交易\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"行情\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"雪球\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/scroll_view\").childSelector(text(\"热门\"))").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\").fromParent(text(\"我的\"))").click();
    }

    @Test
    public void scrollTest() throws Exception{
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;

        Thread.sleep(10000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"富国基金\").instance(0))").click();

    }
}
