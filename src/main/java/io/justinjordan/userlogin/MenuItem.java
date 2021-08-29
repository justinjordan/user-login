package io.justinjordan.userlogin;

import lombok.Data;

@Data
public class MenuItem {
    private String name;
    private Setting setting;

    public MenuItem(String name, Setting setting) {
        this.name = name;
        this.setting = setting;
    }

    public void run(Session session) {
        this.setting.run(session);
    }
}
