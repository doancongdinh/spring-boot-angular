package com.javainuse.controllers;

import com.javainuse.service.DataService;
import com.javainuse.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/api" })
public class DataController {

    @Autowired
    DataService dataService;

    @Autowired
    FirebaseService firebaseService;

    @Autowired
    private JdbcTemplate db;

//    @GetMapping("/summary")
//    public Object getSummary() throws Exception {
//        return firebaseService.saveSummary(dataService.getSummary());
//    }

}
