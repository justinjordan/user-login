package io.justinjordan.userlogin;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String location;

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void save() {
        UserService.updateUser(this);
    }
}
