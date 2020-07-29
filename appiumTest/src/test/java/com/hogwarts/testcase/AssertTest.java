package com.hogwarts.testcase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.*;

public class AssertTest extends BaseTest{

    @Test
    public void assertTest(){
        Integer a = new Integer(1);
        Integer b = new Integer(2);

        assertNotNull(a);
        assertSame(a, b);
    }

    @Test
    public void priceTest(){
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).click();
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
        String realPrice = driver.findElement(By.xpath("//*[@text='09988']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();

        assertThat("股票价格的对比", Double.parseDouble(realPrice), greaterThan(200d));

    }
}
