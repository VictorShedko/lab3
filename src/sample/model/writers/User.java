package sample.model.writers;

import sample.model.Forum;
import sample.model.Message;


public class User {
    protected Forum ownForum;

    public User() {
        this.ownForum = new Forum();

    }


    public Message createNewMessage(String inputTxt) {
        Message newMessage = new Message(inputTxt);
        ownForum.addMessage(newMessage);


        return newMessage;

    }

    public Forum getForum() {
        return this.ownForum;

    }


}
