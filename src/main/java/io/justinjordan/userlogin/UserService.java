package io.justinjordan.userlogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class UserService {
    public static boolean attemptLogin() {
        Scanner scanner = new Scanner(System.in);

        // ask for username
        System.out.println("Username: ");
        String username = scanner.nextLine();
        User user = getUser(username);

        // check username
        if (user == null) {
            return false;
        }

        // ask for password
        System.out.println("Password: ");
        String password = scanner.nextLine();

        // check password
        if (!user.checkPassword(password)) {
            return false;
        }

        return true;
    }

    public static User getUser(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users.csv"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (username.equals(parts[0])) {
                    User user = new User();

                    user.setUsername(parts[0]);
                    user.setPassword(parts[1]);
                    user.setName(parts[2]);
                    user.setLocation(parts[3]);

                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
