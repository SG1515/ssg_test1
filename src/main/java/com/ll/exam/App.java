package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc =sc;
    }

    public void run() {
        System.out.println("==명언 SSG==");

        outer:
        while(true) {
            System.out.println("명령) "); //명령 출력 후
            String cmd = sc.nextLine().trim(); //입력

            switch ( cmd ) { // 입력된 값이 종료일 경우
                case "등록":
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                case "종료":
                    break outer; // 종료
            }
        }
    }




}
