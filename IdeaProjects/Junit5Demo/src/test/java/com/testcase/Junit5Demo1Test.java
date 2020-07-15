package com.testcase;

import org.junit.jupiter.api.*;

public class Junit5Demo1Test {
    @BeforeAll
    public static void before(){
        System.out.println("Before");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
    }

    @Test
    public void fun(){
        System.out.println("Fun");
    }

    @Test
    public void fun1(){
        System.out.println("Fun1");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEacch");
    }

    @AfterAll
    public static void after(){
        System.out.println("After");
    }
}
