package io.justinjordan.userlogin;

import io.justinjordan.userlogin.settings.ChangePassword;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            User user = login();

            if (user != null) {
                Session session = new Session(user);
                settingsMenu(session);
            }
        } catch (Exception e) {
            //
        } finally {
            UserInput.cleanUp();
            DataStorage.cleanUp();
        }
    }

    private static User login() {
        Scanner scanner = UserInput.getScanner();
        User user;

        try {
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
        }

        return null;
    }

    private static void settingsMenu(Session session) {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("Change Password", new ChangePassword()));

        menu.run(session);
    }
}
