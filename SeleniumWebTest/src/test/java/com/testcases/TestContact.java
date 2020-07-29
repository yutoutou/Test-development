package com.testcases;

import com.page.ContactPage;
import com.page.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String username = contact.addMember("3", "3", "15361827882").search("3").getUserName();
        //todo: assert
        assertEquals(username, "3");

    }

    @Test
    public void testSearch(){
        contact.search("3").delete();
    }

    @Test
    public void testImportFromFile(){
        //todo:文件中文命名会有编码问题
        contact.importFromFile(this.getClass().getResource("/通讯录导入模板.xlsx"));
    }

    @Test
    public void testAddDepartment(){
        String departmentName = contact.addDepartment("行政部").getDepartmentName();
        assertEquals(departmentName, "行政部");
        contact.deleteDepartment("行政部");
    }

    @Test
    public void testDeleteDepartment(){
        contact.addDepartment("研发部").deleteDepartment("研发部");
    }

    @Test
    public void testAddTag(){
//        contact.addTag("北京研发中心");
        String tagName = contact.addTag("北京中心").getTagName();
        assertEquals(tagName, "北京中心");
        contact.deleteTag("北京中心");
    }

    @Test
    public void testDeleteTag(){
        contact.addTag("深圳研发中心").deleteTag("深圳研发中心");
    }

    @AfterAll
    public static void tearDown() throws Exception{
        Thread.sleep(1000);
        main.tearDown();
    }
}
