package io.justinjordan.userlogin;

import java.io.BufferedReader;
import java.io.FileWriter;

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
            BufferedReader reader = DataStorage.getReader();

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
        } finally {
            DataStorage.cleanUp();
        }

        return null;
    }

    public static void updateUser(User user) {
        try {
            BufferedReader reader = DataStorage.getReader();
            FileWriter writer = DataStorage.getWriter();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (user.getUsername().equals(parts[0])) {
                    writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getName() + "," + user.getLocation() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Update User Error: " + e.getMessage());
        } finally {
            DataStorage.cleanUp();
        }
    }
}
