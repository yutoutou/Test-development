package com.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({
        "com.testcase1", "com.testcase2"
})

@IncludePackages({
        "com.testcase1", "com.testcase2"
})
public class Junit5SuiteDemoTest {

}
