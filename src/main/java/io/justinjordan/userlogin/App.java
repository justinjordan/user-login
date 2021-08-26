package io.justinjordan.userlogin;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        User user = consoleLogin();

        if (user != null) {
            System.out.println(
                "Logged in as...\n\n" +
                "Username: " + user.getUsername() + "\n" +
                "Name: " + user.getName() + "\n" +
                "Location: " + user.getLocation() + "\n"
            );
        }
    }

    private static User consoleLogin() {
        Scanner scanner = null;
        User user;

        try {
            scanner = new Scanner(System.in);

            for (int attemptsLeft = 5; attemptsLeft > 0; attemptsLeft--) {
                try {
                    System.out.println(attemptsLeft + " attempts left.");

                    // ask for username
                    System.out.println("Username: ");
                    String username = scanner.nextLine();

                    // ask for password
                    System.out.println("Password: ");
                    String password = scanner.nextLine();

                    user = UserService.login(username, password);

                    if (user == null) {
                        throw new RuntimeException("Invalid username/password");
                    }

                    System.out.println("Login successful!\n");

                    return user;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return null;
    }
}
