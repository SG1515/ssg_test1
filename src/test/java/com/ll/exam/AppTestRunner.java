package com.ll.exam;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {

        Scanner sc = TestUtil.genScanner(input);
        //평소에는 표준출력이 모니터를 향하고 있다.
        //그것을 특정 바이트스트림에 쌓이도록 한다.
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        // 바이트스트림이 여태까지 모아놓은 출력들을 방출한다.
        new App(sc).run();

        String rs = output.toString(); //결과로 받기 (rs)
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
