package com.javainuse.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpService {
    private final OkHttpClient httpClient = new OkHttpClient();

//    public static void main(String[] args) throws Exception {
//
//        OkHttpExample obj = new OkHttpExample();
//
//        System.out.println("Testing 1 - Send Http GET request");
//        obj.sendGet();
//
//        System.out.println("Testing 2 - Send Http POST request");
//        obj.sendPost();
//
//    }

    public String sendGet(String url) throws Exception {

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")  // add request headers
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            return response.body().string();
        }

    }

    private void sendPost() throws Exception {

        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("username", "abc")
                .add("password", "123")
                .add("custom", "secret")
                .build();

        Request request = new Request.Builder()
                .url("https://httpbin.org/post")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }
}
