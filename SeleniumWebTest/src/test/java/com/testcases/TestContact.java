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
        //todo: assert
    }

    @Test
    public void testSearch(){
        contact.search("3").delete();
    }

    @AfterAll
    public static void tearDown() throws Exception{
        Thread.sleep(1000);
        main.tearDown();
    }
}
