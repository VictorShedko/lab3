package sample.control;

import sample.model.Forum;
import sample.model.exeption.EmptyUserListExeption;
import sample.model.writers.*;

import java.util.List;

import sample.model.exeption.OutOfTextBoardRangeException;

public class Controller {
    private Forum forum;
    private RegisteredUser user;
    private Admin admin;
    private int mode;
    private int viewMode;
    private int SCREEN_SIZE = 5;

    public Controller() {

        this.user = new RegisteredUser();
        this.admin = new Admin("Admin");
        this.forum = new Forum();//this.user.getForum();
        this.mode = 0;
        this.viewMode = 0;
    }

    public void setViewMode(int viewMode) {
        this.viewMode = viewMode;
    }

    public int getViewMode() {
        return viewMode;
    }

    public List<String> addMessage(String inputString) {


        this.setViewMode(1);
        this.forum.addMessage(user.createNewMessage(inputString));

        return this.forum.getMessages(SCREEN_SIZE);
    }


    public int getMode() {


        return this.mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public List<String> dellMessage(int number) throws OutOfTextBoardRangeException {


        if (user.getLogin().equals(admin.getLogin())) this.forum.deleteMessage(number);


        return this.forum.getMessages(SCREEN_SIZE);
    }


    public List<String> getMessages(int number) {


        return this.forum.getMessages(number);
    }

    public void sigIn(String newLogin) {

        this.addUser(newLogin);
        this.user.changeLogin(newLogin);
        if (user.getLogin().equals(admin.getLogin())) {
            this.mode = 1;
        } else {
            this.mode = 0;
        }

        return;
    }

    public void deleteUser(String name) throws EmptyUserListExeption {
        this.admin.deleteUser(name);


    }

    public void addUser(String name) {
        this.admin.createUser(name);


    }

    public List<String> getUsers(int screenSize) {


        return this.admin.getUsers(screenSize);
    }


}