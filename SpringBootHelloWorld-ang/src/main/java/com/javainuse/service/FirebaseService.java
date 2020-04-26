package com.javainuse.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.javainuse.model.Global;
import com.javainuse.model.Summary;
import io.netty.util.internal.StringUtil;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

@Service
@Log
public class FirebaseService {
    public String saveSummary(Summary summary) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            Global global = summary.getGlobal();
            Map<String, Object> docData = new HashMap<>();
            docData.put("NewConfirmed", global.getNewConfirmed());
            docData.put("NewDeaths", global.getNewDeaths());
            docData.put("NewRecovered", global.getNewRecovered());
            docData.put("TotalConfirmed", global.getTotalConfirmed());
            docData.put("TotalDeaths", global.getTotalDeaths());
            docData.put("TotalRecovered", global.getTotalRecovered());
            docData.put("Date", summary.getDate());
            ApiFuture<WriteResult> collectionsApiFuture = db.collection("global").document("global").set(docData);
            return collectionsApiFuture.get().getUpdateTime().toString();
        } catch(Exception e) {
            log.log(Level.WARNING, e.toString());
        }
        return "";
    }
}
