package com.javainuse.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Summary {
    private Global Global;
    private List<Country> Countries;
    private String Date;
}
