package weWork.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class schedulePageTest {
    private static WeWork weWork;

    @BeforeAll
    public static void initData(){
        weWork = new WeWork();
    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void add() {
        assertTrue(weWork.schedule().add("上班打卡", null).getSchedule(null).contains("上班打卡"));
    }

    @Test
    void getSchedule() {
    }
}