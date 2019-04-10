package sample.model;

import sample.model.exeption.OutOfTextBoardRangeException;

import java.util.List;
import java.util.ArrayList;
import sample.model.writers.*;
public class UserBase {
    private static String ADMIN_NAME = "Admin";
    private List<RegisteredUser> userList;
    public List<RegisteredUser> getUserList() {
        if (userList == null) return this.userList = new ArrayList<>();
        return userList;
    }

    private void addUser(String userName ) {

        this.getUserList().add(0, new RegisteredUser(userName));


    }

    private void deleteUser(String userName) {

        this.userList.removeIf(u -> userName.equals(u.getLogin()));
    }

    public void addRequest(String userName){
        this.addUser(userName);


    }

    public void deleteRequest(String userName){
        this.deleteUser(userName);


    }



}
