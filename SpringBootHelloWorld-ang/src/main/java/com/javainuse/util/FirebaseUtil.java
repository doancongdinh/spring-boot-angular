package com.javainuse.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.logging.Level;

@Service
@Log
public class FirebaseUtil {

    @PostConstruct
    public void init() {
        try {

            FileInputStream fileInputStream =
                    new FileInputStream("/Users/admin/Desktop/spring/spring-boot-angular/SpringBootHelloWorld-ang/src/main/resources/firebase.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(fileInputStream))
                    .setDatabaseUrl("https://covid-6d27f.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            log.log(Level.WARNING, e.toString());
        }
    }
}
