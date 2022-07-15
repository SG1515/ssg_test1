package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    int wiseSayingsLastId;
    List<WiseSaying> wiseSayings;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingsLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("==명언 SSG==");



        outer:
        while(true) {
            System.out.println("명령) "); //명령 출력 후
            String cmd = sc.nextLine().trim(); //입력
            Rq rq = new Rq(cmd);

            switch ( rq.getPath() ) { // 입력된 값이 종료일 경우
                case "등록":
                    int id = ++wiseSayingsLastId;
                    System.out.println("명언 : ");
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();

                    wiseSayings.add(new WiseSaying(id, content, author));

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for (int i = wiseSayings.size() -1; i >= 0; i--){
                        WiseSaying wiseSaying = wiseSayings.get(i);

                        System.out.printf("%d / %s / %s\n", wiseSaying.id ,wiseSaying.author, wiseSaying.content);
                    }
                    break;

                case "삭제":
                    remove(rq);
                    break;
                case "수정":
                    modify(rq);
                    break;
                case "종료":
                    break outer; // 종료
            }
        }


    }

    private void modify(Rq rq) { // 수정
        int id = rq.getIntParam("id", 0);

        //삭제와 동일한 구문
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        //기존 명언 출력
        System.out.printf("명언(기존) : %s\n", wiseSaying.content);
        //새로운 명언 입력
        System.out.println("명언 : ");
        String content = sc.nextLine();
        //기존 작가 출력
        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        //새로운 작가 입력
       System.out.println("작가 : ");
        String author = sc.nextLine();

        wiseSaying.content = content; //입력된 명언 저장
        wiseSaying.author = author; //입력된 작가 저장
    }

    private void remove(Rq rq) {  //삭제
        int id = rq.getIntParam("id", 0);
        //번호가 있는지 조회
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);
        //데이터가 있는지 조회
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

    }

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == id) {
                return wiseSaying;
            }
        }

        return null;
    }


}
