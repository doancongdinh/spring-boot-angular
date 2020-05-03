package com.javainuse.model;

import lombok.Data;

import java.util.List;

@Data
public class Comic {
    private String name;
    private List<Chapter> chapters;
}
