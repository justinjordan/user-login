package io.justinjordan.userlogin;

import lombok.Data;

@Data
public class Session {
    private User authenticatedUser;
    private User activeUser;

    public Session(User user) {
        this.authenticatedUser = user;
        this.activeUser = user;
    }
}
