package org.example.download;


import java.io.IOException;

public class HttpStatusImageDownloaderTest {
    public static void main(String[] args) throws IOException {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(203);
    }
}
