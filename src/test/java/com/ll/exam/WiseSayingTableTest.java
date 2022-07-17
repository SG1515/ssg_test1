package com.ll.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//객체를 만들고 파일이 생기는지 test

public class WiseSayingTableTest {
   private WiseSayingTable wiseSayingTable;

    public WiseSayingTableTest() {
        wiseSayingTable = new WiseSayingTable("test_data");
    }

    @BeforeEach
    public void beforeEach() {
        Util.file.deleteDir("test_data"); //초기화

        //생성 두개
        wiseSayingTable.save("나에게 불가능이란 없다.", "나폴레옹");
        wiseSayingTable.save("나의 죽음을 적들에게 알리지마라.", "이순신신");

    }
    @Test
    public void 저장() {
        int newId = wiseSayingTable.getLastId()+ 1;
        wiseSayingTable.save("자유가 아니면 죽음을 달라!", "패트릭 헨리");



        assertTrue(new File("test_data/wise_saying/%d.json".formatted(newId)).exists());
    }

    @Test
    public void 조회() {
        WiseSaying wiseSaying =wiseSayingTable.findById(1);
        //객체를 파일로도 만들고 다시 가져오는 조회도 완성
        assertEquals(1, wiseSaying.id);
        assertEquals("나에게 불가능이란 없다.", wiseSaying.content);
        assertEquals("나폴레옹", wiseSaying.author);
    }

}
