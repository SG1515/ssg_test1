package com.ll.exam;

import java.util.List;

public class WiseSayingRepository {

    private WiseSayingTable wiseSayingTable;

    public WiseSayingRepository() {
        wiseSayingTable = new WiseSayingTable(App.getBaseDir());
    }
    //repository에는 write보다는 add라고 사용한다.
    //비즈니스 로직을 가지면 안좋다.

    public WiseSaying add(String content, String author) {
        return wiseSayingTable.save(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingTable.findById(id);
    }

    public boolean modify(int id, String content, String author) {
        return wiseSayingTable.save(id, content, author);
    }

    public boolean remove(int id) {
        return wiseSayingTable.removeById(id);
    }
}