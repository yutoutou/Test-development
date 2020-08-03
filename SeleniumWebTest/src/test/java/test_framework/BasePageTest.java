package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasePageTest {
    private static BasePage basePage;
    @BeforeAll
    static void initData(){
        basePage = new BasePage();
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void click() {
    }

    @Test
    void find() {
    }

    @Test
    void send() {
    }

    @Test
    void getText() {
    }

    @Test
    void run() {
        UIAuto uiAuto = basePage.load("/test_framework/uiauto.yaml");
        basePage.run(uiAuto);
    }

    @Test
    void load() throws JsonProcessingException {
        UIAuto uiAuto = basePage.load("/test_framework/uiauto.yaml");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(uiAuto));
    }
}