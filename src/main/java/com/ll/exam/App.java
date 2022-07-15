package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc =sc;
    }

    public void run() {
        System.out.println("==명언 SSG==");

        int wiseSayingsLastId = 0;

        outer:
        while(true) {
            System.out.println("명령) "); //명령 출력 후
            String cmd = sc.nextLine().trim(); //입력

            switch ( cmd ) { // 입력된 값이 종료일 경우
                case "등록":
                    int id = ++wiseSayingsLastId;
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "종료":
                    break outer; // 종료
            }
        }


    }




}
