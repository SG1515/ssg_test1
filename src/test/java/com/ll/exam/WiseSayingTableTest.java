package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

//객체를 만들고 파일이 생기는지 test

public class WiseSayingTableTest {
    @Test
    public void 저장() {
        WiseSayingTable WiseSayingTable = new WiseSayingTable("test_data");


        WiseSayingTable.save("나에게 불가능이란 없다.", "나폴레옹");
        //파일이 정말 존재하는지 test
        assertTrue(new File("test_data/wise_saying/1.json").exists());

        WiseSayingTable.save("나의 죽음을 적들에게 알리지마라.", "이순신신");
        //파일이 정말 존재는지 test
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }


}
