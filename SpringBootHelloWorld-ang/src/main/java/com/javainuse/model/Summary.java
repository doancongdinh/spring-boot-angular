package com.javainuse.model;

import lombok.Data;

import java.util.List;

@Data
public class Summary {
    private Global Global;
    private List<Country> Countries;
    private String Date;
}
