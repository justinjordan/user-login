package io.justinjordan.userlogin;

public class App {
    public static void main(String[] args) {
        login();
    }

    private static void login() {
        for (int attemptsLeft = 5; attemptsLeft > 0; attemptsLeft--) {
            if (UserService.attemptLogin()) {
                System.out.println("You are now logged in.");
                return;
            } else {
                System.out.println("Invalid username/password");
                System.out.println((attemptsLeft - 1) + " attempts left.");
            }
        }

        System.out.println("Access Denied");
    }
}
