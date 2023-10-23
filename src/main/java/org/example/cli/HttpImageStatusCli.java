package org.example.cli;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.example.status.HttpStatusChecker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HttpImageStatusCli {
    private OkHttpClient client;
    private HttpStatusChecker checker;
    private Scanner scanner;

    public HttpImageStatusCli() {
        client = new OkHttpClient();
        checker = new HttpStatusChecker();
        scanner = new Scanner(System.in);
    }

    public void askStatus() throws IOException {
        System.out.println("Enter HTTP status code please: ");
        int code = scanner.nextInt();
        String imageUrl = checker.getStatusImage(code);
        if (imageUrl != null) {
            Request request = new Request.Builder()
                    .url(imageUrl)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        try (InputStream inputStream = body.byteStream();
                             FileOutputStream outputStream = new FileOutputStream(code + ".jpg")) {
                            byte[] buffer = new byte[8192];
                            int bytesRead;
                            while ((bytesRead = inputStream.read(buffer)) != -1){
                                outputStream.write(buffer, 0 , bytesRead);
                            }
                            System.out.println("Image downloaded and saved as " + code + ".jpg");
                        }
                    }
                } else {
                    throw new IOException("Response body is null");
                }
            }
        } else {
            throw new IOException("There is not image for HTTP status " + code);
        }
    }
}
