package sample.model;

import sample.model.exeption.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import sample.model.writers.*;

public class UserBase {
    private static String ADMIN_NAME = "Admin";
    private List<RegisteredUser> userList;

    public List<RegisteredUser> getUserList() {
        if (userList == null) return this.userList = new ArrayList<>();
        return userList;
    }

    private void addUser(String userName) {

        this.getUserList().add(0, new RegisteredUser(userName));


    }

    private void deleteUser(String userName) throws EmptyUserListExeption {
        if (this.userList == null) throw new EmptyUserListExeption("sorry");

        this.getUserList().removeIf(u -> userName.equals(u.getLogin()));
    }

    public void addRequest(String userName) {
        this.addUser(userName);


    }

    public void deleteRequest(String userName) throws EmptyUserListExeption {
        this.deleteUser(userName);


    }

    public List<String> getUsers(int numberOfUsers) {
        if (this.userList == null) return null;
        numberOfUsers = numberOfUsers > this.userList.size() ? this.userList.size() : numberOfUsers;

        List<String> textList = userList.stream()
                .limit(numberOfUsers)
                .map(RegisteredUser::getLogin)
                .collect(Collectors.toList());

        return textList;

    }


}
