package com.test_app.xueqiu.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPageTest {
    public static MainPage mainPage;
    public static SearchPage searchPage;
    
    @BeforeAll
    public static void setUp(){
        searchPage = new MainPage().toSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba, 阿里巴巴",
            "baidu, 百度"
    })
    public void testSearch(String keyword, String name){
        assertEquals(searchPage.search(keyword).getSearchList().get(0), name);
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba",
            "wangyi"
    })
    public void testGetPrice(String keyword){
        assertTrue(searchPage.search(keyword).getPrice() > 200);
    }

    @AfterAll
    public static void tearDown(){
        searchPage.quit();
    }
}
