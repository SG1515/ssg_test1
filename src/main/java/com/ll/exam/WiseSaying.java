package com.ll.exam;

public class WiseSaying {
    public int id;
    public String author;
    public String content;
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.author=author;
        this.content =content;
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "author": "%s"
                }
                """.stripIndent().formatted(id, content, author);
    }
    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
