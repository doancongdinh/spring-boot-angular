package com.javainuse.model;

import lombok.Data;

import java.util.List;

@Data
public class Chapter {
    private String chapterNo;
    private String chapterUrl;
    private List<String> chapterPageUrl;

    public Chapter(String chapterNo, String chapterUrl) {
        this.chapterNo = chapterNo;
        this.chapterUrl = chapterUrl;
    }
}
