package org.example.cli;

import java.io.IOException;

public class HttpImageStatusCliTest {
    public static void main(String[] args) throws IOException {
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
