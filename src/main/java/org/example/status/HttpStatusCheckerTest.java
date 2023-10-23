package org.example.status;

import java.io.IOException;

public class HttpStatusCheckerTest {
    public static void main(String[] args) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(404);
        System.out.println(imageUrl);

        String imageUrl1 = checker.getStatusImage(10000);
        System.out.println(imageUrl1);
    }
}