//13 서비스 도입
package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingReposiotory wiseSayingReposiotory;


    public WiseSayingService() {

        wiseSayingReposiotory = new WiseSayingReposiotory();
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingReposiotory.write(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingReposiotory.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingReposiotory.findById(id);
    }

    public boolean modify(int id, String content, String author) {
        return wiseSayingReposiotory.modify(id, content,author);
    }

    public boolean remove(int id) {
        return wiseSayingReposiotory.remove(id);
    }
}