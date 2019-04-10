package sample.model;

import sample.model.exeption.OutOfTextBoardRangeException;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    public String forumName;
    private static String ADMIN_NAME = "Admin";
    private List<Message> messageList;

    public List<Message> getMessageList() {
        if (messageList == null) return this.messageList = new ArrayList<>();
        return messageList;
    }

    public void addMessage(Message input) {
        this.getMessageList().add(0, input);


    }

    public void deleteMessage(int number) throws OutOfTextBoardRangeException {
        if ((number <= getMessageList().size()) && (number > 0)) {
            messageList.remove(number);
        } else {

            throw new OutOfTextBoardRangeException("out of range",getMessageList().size());//throw
        }

    }

    public List<String> getMessages(int numberOfMessages) {
        if (this.messageList == null) return null;
        numberOfMessages = numberOfMessages > this.messageList.size() ? this.messageList.size() : numberOfMessages;

        List<String> textList = new ArrayList<>();
        for (int index = 0; index < numberOfMessages; index++) {
            Message temp = this.messageList.get(index);
            textList.add(index,
                    temp.getName() + " : " + temp.getText());

        }
        return textList;

    }


}
