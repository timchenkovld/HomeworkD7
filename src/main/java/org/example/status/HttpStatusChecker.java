package org.example.status;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpStatusChecker {
    private OkHttpClient client;

    public HttpStatusChecker() {
        client = new OkHttpClient();
    }

    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return url;
            } else {
                throw new IOException("HTTP status code " + response.code());
            }
        }
    }
}

