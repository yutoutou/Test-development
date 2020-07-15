package junit5;

import io.qameta.allure.Allure;
import io.qameta.allure.Link;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    @Tag("xxx")
    //@Link("https://www.baidu.com")
    @Link(name = "allure", type = "mylink", url = "https://www.baidu.com")
    void div() {
        Allure.step("1");
        Calc calc = new Calc();
        Allure.step("2");
        Allure.addAttachment("xxx", "dddd");
        Allure.addAttachment("demo", "image/png", this.getClass().getResourceAsStream("/照片.jpeg"), ".jpeg");
        assertEquals(calc.div(2, 1), 2);
    }
}