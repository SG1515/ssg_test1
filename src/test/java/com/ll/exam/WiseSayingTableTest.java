package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

//객체를 만들고 파일이 생기는지 test

public class WiseSayingTableTest {
    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {
        WiseSayingTable WiseSayingTable = new WiseSayingTable("test_data");
        WiseSaying wiseSaying = new WiseSaying(1, "나에게 불가능이란 없다.","나폴레옹");
        WiseSayingTable.save(wiseSaying);

        //파일이 정말 존재하는지 test
        assertTrue(new File("test_data/wise_saying/1.json").exists());
    }


}
