package sample.model.login;

import sample.model.writers.*;

public class LoginLogic {

    public static User createUser(String login) {

        if (login.equals("Admin")) {
            Admin admin = new Admin(login);
            return admin;
        }
        User user = new RegisteredUser(login);
        return user;

    }


}
