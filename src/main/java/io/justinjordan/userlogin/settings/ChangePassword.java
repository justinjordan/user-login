package io.justinjordan.userlogin.settings;

import io.justinjordan.userlogin.Session;
import io.justinjordan.userlogin.Setting;
import io.justinjordan.userlogin.User;
import io.justinjordan.userlogin.UserInput;

import java.util.Scanner;

public class ChangePassword implements Setting {
    public void run(Session session) {
        try {
            Scanner scanner = UserInput.getScanner();

            System.out.println("New Password:");
            String password = scanner.nextLine();

            User user = session.getActiveUser();
            user.setPassword(password);
            user.save();
        } catch (Exception e) {
            System.out.println("Change Password Error: " + e.getMessage());
        }
    }
}
