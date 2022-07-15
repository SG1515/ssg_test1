package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("==명언 SSG==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while(true) {
            System.out.println("명령) "); //명령 출력 후
            String cmd = sc.nextLine().trim(); //입력
            Rq rq = new Rq(cmd);

            switch ( rq.getPath() ) { // 입력된 값이 종료일 경우
                case "등록":
                    wiseSayingController.write(rq);
                    break;

                case "목록":
                    wiseSayingController.list(rq);
                    break;

                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "종료":
                    break outer; // 종료
            }
        }
    }
}
