package sample.model.writers;
import sample.model.exeption.OutOfTextBoardRangeException;
import sample.model.UserBase;

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
    public void deleteUser(String userName) {
        this.userBase.deleteRequest(userName);



    }

}
