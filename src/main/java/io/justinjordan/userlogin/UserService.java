package io.justinjordan.userlogin;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserService {
    public static User login(String username, String password) {
        User user = getUser(username);

        if (user == null || !user.checkPassword(password)) {
            return null;
        }

        return user;
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
