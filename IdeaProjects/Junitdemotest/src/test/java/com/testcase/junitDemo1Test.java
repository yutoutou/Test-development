package com.testcase;

import org.junit.*;

public class junitDemo1Test {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void fun1(){
        System.out.println("fun1 test");
    }

    @Test
    public void fun2(){
        System.out.println("fun2 test");
    }

    @Test
    @Ignore
    public void fun3(){
        System.out.println("fun3 test");
    }
    @After
    public void after(){
        System.out.println("After");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("after Class");
    }
}
