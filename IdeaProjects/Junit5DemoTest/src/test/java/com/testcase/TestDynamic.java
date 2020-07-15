package com.testcase;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestDynamic {
    public boolean isPalindrome(String str){
        return true;
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection(){
        return Arrays.asList(
                dynamicTest("1st dynamic test", ()-> assertTrue(isPalindrome("madam"))),
                dynamicTest("2nd dynamic test", ()-> assertEquals(4, 4))
        );
    }

}
