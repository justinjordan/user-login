package io.justinjordan.userlogin;

import lombok.Data;

import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void run(Session session) {
        Scanner scanner = UserInput.getScanner();
        int choice;

        try {
            while (true) {
                System.out.println("0) Exit");

                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ") " + items.get(i).getName());
                }

                choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    break;
                }

                items.get(choice - 1).run(session);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
