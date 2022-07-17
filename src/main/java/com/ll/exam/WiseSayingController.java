package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;

    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc =sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write(Rq rq) {
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);

    }


    public void list(Rq rq) {
        System.out.printf("번호 / 작가 / 명언\n");
        System.out.printf("----------------------\n");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() -1; i >= 0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.id ,wiseSaying.author, wiseSaying.content);
        }
    }


    public void modify(Rq rq) { // 수정
        int id = rq.getIntParam("id", 0);

        //삭제와 동일한 구문
        if (id == 0) {
            System.out.printf("번호를 입력해주세요.\n");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        //기존 명언 출력
        System.out.printf("명언(기존) : %s\n", wiseSaying.content);
        //새로운 명언 입력
        System.out.printf("명언 : ");
        String content = sc.nextLine();


        //기존 작가 출력
        System.out.printf("작가(기존) : %s\n", wiseSaying.author);
        //새로운 작가 입력
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }


    public void remove(Rq rq) {  //삭제
        int id = rq.getIntParam("id", 0);
        //번호가 있는지 조회
        if (id == 0) {
            System.out.printf("번호를 입력해주세요.\n");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);
        //데이터가 있는지 조회
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.remove(id);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

    }


    public void build(Rq rq) {
        wiseSayingService.dumpToJson();

    }
}
