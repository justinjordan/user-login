package io.justinjordan.userlogin;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = null;

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    public static void cleanUp() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
