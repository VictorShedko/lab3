package sample.model.writers;


import sample.model.Message;

import java.util.Objects;

public class RegisteredUser extends User {

    static String NAME_LESS = "no named user";

    String login;

    String password = "123";

    public RegisteredUser() {
        super();
        this.login = NAME_LESS;

    }


    public RegisteredUser(String startLogin) {
        this.login = startLogin;

    }


    public void changeLogin(String newLogin) {
        this.login = newLogin;

    }


    public String getLogin() {
        return this.login;

    }

    public boolean sigIn(String inputPassword) {
        if (this.password.equals(inputPassword)) return true;
        return false;


    }

    @Override
    public Message createNewMessage(String inputTxt) {
        Message newMessage = new Message(inputTxt, this.login);
        return newMessage;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredUser that = (RegisteredUser) o;
        return Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
