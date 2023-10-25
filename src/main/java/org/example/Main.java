package org.example;

import org.example.cli.HttpImageStatusCli;
import org.example.download.HttpStatusImageDownloader;
import org.example.status.HttpStatusChecker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpStatusChecker checker = new HttpStatusChecker();
        System.out.println(checker.getStatusImage(200));

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(203);

        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }
}
