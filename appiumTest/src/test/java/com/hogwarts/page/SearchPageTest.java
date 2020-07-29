package com.hogwarts.page;

import com.hogwarts.testcase.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SearchPageTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("byNameGetPrice")
    public void searchByName(String name, String code, double price){
        driver.findElement(By.id("com.xueqiu.android:id/tv_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(name);
        //driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).click();
        driver.findElement(By.xpath("//*[@text='"+ code + "']")).click();
        String realPrice = driver.findElement(By.xpath("//*[@text='"+ code + "']/../../..//*[@resource-id='com.xueqiu.android:id/current_price']")).getText();

        System.out.println(realPrice);
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();

        assertThat("股票实际价格与期望价格的比较", Double.parseDouble(realPrice), greaterThan(price));

    }

    private static Stream<Arguments> byNameGetPrice(){
        return Stream.of(Arguments.of("alibaba", "BABA", 210d),
                         Arguments.of("wangyi", "NTES", 250d),
                         Arguments.of("baidu", "BIDU", 180d),
                         Arguments.of("google", "GOOAV", 300d));
    }

}
