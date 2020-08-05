package com.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class TestCookie {

    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
    }

    //@Test
    public void addCookie(){
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line=bufferedReader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String domain = tokenizer.nextToken();

                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")){
                    //把String转换成date
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    sdf.parse(dt);
                }
                String path = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                //把String 转换成boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());

                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCookie(){
        try {
            FileWriter fileWriter = new FileWriter("cookie.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println(driver.manage().getCookies());
            //cookie 处理，每次只取一条cookie进行处理
            for(Cookie cookie:driver.manage().getCookies()){
                //获取所有的cookie内容，进行保存
                bufferedWriter.write(cookie.getName() + ';' + cookie.getDomain() + ';' + cookie.getExpiry() + ';' +
                        cookie.getPath() + ';' + cookie.getValue() + ';' + cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @AfterAll
//    public static void tearDown(){
//        driver.quit();
//    }
}
