package sample.model;

public class Message {
    private String tetxMessage;
    private String sender;
    private static String NONAME_USER_NAME = "noname";

    public Message(String inputTxt) {
        this.tetxMessage = inputTxt;
        this.sender = NONAME_USER_NAME;


    }

    public Message(String inputTxt, String login) {
        this.tetxMessage = inputTxt;
        this.sender = login;


    }

    public String getText() {

        return this.tetxMessage;

    }

    public String getName() {

        return this.sender;

    }


}
