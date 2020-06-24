package com.javainuse.scheduler;

import com.javainuse.model.Summary;
import com.javainuse.service.DataService;
import com.javainuse.service.FirebaseService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Log
@Component
public class DataCollector {

    @Autowired
    FirebaseService firebaseService;

    @Autowired
    DataService dataService;

    @Scheduled(fixedDelay = 1 * 1000)
    public Object getSummary() throws Exception {
        Summary summary = dataService.getSummary();
        log.log(Level.INFO, "getting summary" + summary.toString());
        firebaseService.saveSummary(summary);
        return "Ok";
    }
}
