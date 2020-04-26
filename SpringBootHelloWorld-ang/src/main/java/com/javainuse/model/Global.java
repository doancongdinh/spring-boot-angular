package com.javainuse.model;

import lombok.Data;

@Data
public class Global {
    private long NewConfirmed;
    private long TotalConfirmed;
    private long NewDeaths;
    private long TotalDeaths;
    private long NewRecovered;
    private long TotalRecovered;
}
