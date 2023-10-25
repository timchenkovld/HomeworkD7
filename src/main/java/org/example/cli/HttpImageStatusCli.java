package org.example.cli;


import org.example.download.HttpStatusImageDownloader;
import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;
    private Scanner scanner;

    public HttpImageStatusCli() {
        scanner = new Scanner(System.in);
        downloader = new HttpStatusImageDownloader();
    }

    public void askStatus() throws IOException {
        System.out.println("Enter HTTP status code please: ");
        int code = validInput(scanner);
        downloader.downloadStatusImage(code);
    }

    private int validInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
