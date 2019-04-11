package sample.model.writers;
import sample.model.exeption.OutOfTextBoardRangeException;
import sample.model.UserBase;
import sample.model.exeption.EmptyUserListExeption;

import java.util.List;

public class Admin extends RegisteredUser {
    private UserBase userBase;
    public Admin(String startLogin) {

        super(startLogin);
        this.userBase=new UserBase();

    }

    public void dellMessage(int number) {
        try {
            this.ownForum.deleteMessage(number);

        }catch (OutOfTextBoardRangeException ex){


        }



    }
    public void createUser(String userName) {
       this.userBase.addRequest(userName);



    }
    public void deleteUser(String userName)throws EmptyUserListExeption {
        this.userBase.deleteRequest(userName);



    }
    public List<String> getUsers(int number) {
       return this.userBase.getUsers(number);



    }

}
