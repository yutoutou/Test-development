package com.testcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5Demo2Test {
    @Test
    void asserttion(){
        System.out.println("xxx");
        assertAll("demo assertions",
                ()-> assertEquals(1, 5),
                ()-> assertEquals(1, 1),
                ()-> assertEquals(1, 6),
                ()-> assertEquals(1, 7));
    }
}
