package com.javainuse.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.javainuse.model.Country;
import com.javainuse.model.Global;
import com.javainuse.model.Summary;
import io.netty.util.internal.StringUtil;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Service
@Log
public class FirebaseService {
    public void saveSummary(Summary summary) {
        try {
            Firestore db = FirestoreClient.getFirestore();
            ObjectMapper m = new ObjectMapper();
            Map<String,Object> globalMap = m.convertValue(summary.getGlobal(), Map.class);
            Map<String,Object> countryMap = new HashMap<>();
            WriteBatch batch = db.batch();
            DocumentReference globalRef = db.collection("Summary").document("global");
            batch.set(globalRef, globalMap);
            summary.getCountries().forEach(country -> {
                DocumentReference Ref = db.collection("Summary").document(country.getSlug());
                batch.set(Ref, new ObjectMapper().convertValue(country, Map.class));
            });
            ApiFuture<List<WriteResult>> future = batch.commit();
            log.log(Level.INFO, "done!!!");
        } catch(Exception e) {
            log.log(Level.WARNING, e.toString());
        }
    }

    public void getSummary(String name) {

    }
}
