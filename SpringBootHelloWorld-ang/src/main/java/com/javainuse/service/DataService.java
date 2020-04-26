package com.javainuse.service;

import com.google.gson.Gson;
import com.javainuse.model.Global;
import com.javainuse.model.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    HttpService httpService;

    private static final String GET_SUMMARY_URL = "https://api.covid19api.com/summary";

    public Summary getSummary() throws Exception {
        Gson gson = new Gson();
        String res = httpService.sendGet(GET_SUMMARY_URL);
        return gson.fromJson(res, Summary.class);
    }
}
