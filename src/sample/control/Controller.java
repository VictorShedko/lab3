package sample.control;

import sample.model.Forum;
import sample.model.writers.*;

import java.util.List;
import sample.model.exeption.OutOfTextBoardRangeException;
public class Controller {
    private Forum forum;
    private RegisteredUser user;
    private Admin admin;
    private int mode;
    private int SCREEN_SIZE = 5;

    public Controller() {

        this.user = new RegisteredUser();
        this.admin = new Admin("Admin");
        this.forum = new Forum();//this.user.getForum();
        this.mode = 0;
    }


    public List<String> addMessage(String inputString) {

        int b=2;
        int c=2;


        this.forum.addMessage(user.createNewMessage(inputString));
        int a =1;
        return this.forum.getMessages(SCREEN_SIZE);
    }


    public int getMode() {


        return this.mode;
    }


    public List<String> dellMessage(int number) throws OutOfTextBoardRangeException  {




        if (user.getLogin().equals(admin.getLogin())) this.forum.deleteMessage(number);


        return this.forum.getMessages(SCREEN_SIZE);
    }


    public List<String> getMessages(int number) {


        return this.forum.getMessages(number);
    }

    public void sigIn(String newLogin) {


        this.user.changeLogin(newLogin);
        if (user.getLogin().equals(admin.getLogin())) {
            this.mode = 1;
        } else {
            this.mode = 0;
        }

        return;
    }

}