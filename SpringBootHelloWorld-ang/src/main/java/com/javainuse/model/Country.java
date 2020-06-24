package com.javainuse.model;

import lombok.Data;

@Data
public class Country extends Global {
    private String Country;
    private String CountryCode;
    private String Slug;
    private String Date;
}
