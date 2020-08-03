package test_framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WebTest {
    private static BasePage basePage;

    @BeforeAll
    public static void initData(){

    }

    @BeforeEach
    public void beforeEach(){

    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource
    void classic(UIAuto uiAuto, String path){

        basePage.run(uiAuto);
    }

    static List<Arguments> classic(){
        basePage = UIAutoFactory.create("web");
        List<Arguments> all = new ArrayList<Arguments>();

        Arrays.asList(
                "/test_framework/webauto.yaml",
                "/test_framework/webauto_1.yaml"
        ).stream().forEach(path->{
            UIAuto uiAuto = basePage.load(path);
//            uiAuto.description = path;
            all.add(arguments(uiAuto, path));
            ;
        });
//        UIAuto uiAuto = basePage.load("/test_framework/webauto.yaml");
        return all;
    }
}
