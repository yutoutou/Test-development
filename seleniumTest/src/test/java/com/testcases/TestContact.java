package com.testcases;

import com.page.ContactPage;
import com.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestContact {
    static MainPage main;
    static ContactPage contact;
    @BeforeAll
    public static void initData(){
        main = new MainPage();
        contact = main.toContact();
    }

    @Test
    public void testAddMember(){
        contact.addMember("3", "3", "15361827882");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //todo: assert
    }

    @Test
    public void testSearch(){
        contact.search("3").delete();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        main.tearDown();
    }
}
