package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int wiseSayingsLastId;
    private List<WiseSaying> wiseSayings;

    public WiseSayingService() {
        wiseSayingsLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingsLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.id == id) {
                return wiseSaying;
            }
        }

        return null;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return false;
        }

        wiseSaying.content = content;
        wiseSaying.author = author;

        return true;
    }

    public boolean remove(int id) {
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return false;
        }

        wiseSayings.remove(wiseSaying);

        return true;
    }
}