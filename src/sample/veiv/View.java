package sample.veiv;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.control.Controller;
import sample.model.exeption.*;

public class View extends Application {
    private Controller myController;

    AnchorPane forum = new AnchorPane();
    Label errorLabel;
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane root = new AnchorPane();


            errorLabel = new Label("");

            AnchorPane.setBottomAnchor(errorLabel, 500.0);
            AnchorPane.setTopAnchor(errorLabel, 20.0);
            AnchorPane.setRightAnchor(errorLabel, 500.0);
            AnchorPane.setLeftAnchor(errorLabel, 200.0);


            Button createMessageButton = new Button("Write");
            Button loginButton = new Button("Sig in");


            TextField inputMessage = new TextField();
            TextField loginTextField = new TextField();


            AnchorPane.setBottomAnchor(createMessageButton, 70.0);
            AnchorPane.setTopAnchor(createMessageButton, 400.0);
            AnchorPane.setRightAnchor(createMessageButton, 30.0);
            AnchorPane.setLeftAnchor(createMessageButton, 600.0);

            AnchorPane.setBottomAnchor(loginTextField, 540.0);
            AnchorPane.setTopAnchor(loginTextField, 30.0);
            AnchorPane.setRightAnchor(loginTextField, 100.0);
            AnchorPane.setLeftAnchor(loginTextField, 600.0);


            AnchorPane.setBottomAnchor(loginButton, 540.0);
            AnchorPane.setTopAnchor(loginButton, 30.0);
            AnchorPane.setRightAnchor(loginButton, 30.0);
            AnchorPane.setLeftAnchor(loginButton, 700.0);


            AnchorPane.setBottomAnchor(forum, 250.0);
            AnchorPane.setTopAnchor(forum, 100.0);
            AnchorPane.setRightAnchor(forum, 30.0);
            AnchorPane.setLeftAnchor(forum, 30.0);
//////////////////////
            AnchorPane.setBottomAnchor(inputMessage, 30.0);
            AnchorPane.setTopAnchor(inputMessage, 400.0);
            AnchorPane.setRightAnchor(inputMessage, 250.0);
            AnchorPane.setLeftAnchor(inputMessage, 40.0);


            root.getChildren().add(inputMessage);
            root.getChildren().add(loginTextField);
            root.getChildren().add(createMessageButton);
            root.getChildren().add(errorLabel);

            root.getChildren().add(forum);
            root.getChildren().add(loginButton);


            //TextField Message = new TextField();
            //  AnchorPane.setBottomAnchor(Message, 0.0);
            //AnchorPane.setTopAnchor(Message, 0.0);
            //  AnchorPane.setRightAnchor(Message, 0.0);
            // AnchorPane.setLeftAnchor(Message, 0.0);
            // forum.getChildren().add(Message);

            createMessageButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {


                    myController.addMessage(inputMessage.getText());

                    View.this.rebuildForum();
                }
            });
            loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {


                    myController.sigIn(loginTextField.getText());
                    View.this.rebuildForum();

                }
            });


            Scene scene = new Scene(root, 800, 600);
            primaryStage.setTitle("Random Wandering");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public View() {
        try {
            this.myController = new Controller();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void rebuildForum() {
        ArrayList<String> MessageList;
        if (this.myController.getMode() == 3) {
             MessageList = (ArrayList<String>) this.myController.getUsers(3);
        }else {
            MessageList = (ArrayList<String>) this.myController.getMessages(3);
        }
        if (MessageList == null) {
            Label tempMessage = new Label("there is no message");

            AnchorPane.setBottomAnchor(tempMessage, 25.0 + 50);
            AnchorPane.setTopAnchor(tempMessage, 250 - 25.0 - 50 - 50);
            AnchorPane.setRightAnchor(tempMessage, 20.0);
            AnchorPane.setLeftAnchor(tempMessage, 20.0);


            forum.getChildren().add(tempMessage);

        } else {
            if (this.myController.getMode() == 0) {

                forum.getChildren().clear();
                for (int i = 0; i < MessageList.size(); i++) {
                    Label tempMessage = new Label(MessageList.get(i));

                    AnchorPane.setBottomAnchor(tempMessage, 25.0 + 50 * i);
                    AnchorPane.setTopAnchor(tempMessage, 250 - 25.0 - 50 * i - 50);
                    AnchorPane.setRightAnchor(tempMessage, 20.0);
                    AnchorPane.setLeftAnchor(tempMessage, 20.0);


                    forum.getChildren().add(tempMessage);
                }
            }
            if ((this.myController.getMode() == 1)||(this.myController.getMode() == 3)) {


                forum.getChildren().clear();
                TextField delNumber = new TextField();
                Button delButton = new Button("del");
                Button delUserButton = new Button("del User");
                Button getUserButton = new Button("get Users");
                AnchorPane.setBottomAnchor(delNumber, 200.0);
                AnchorPane.setTopAnchor(delNumber, 0.0);
                AnchorPane.setRightAnchor(delNumber, 20.0);
                AnchorPane.setLeftAnchor(delNumber, 600.0);

                AnchorPane.setBottomAnchor(delButton, 200.0);
                AnchorPane.setTopAnchor(delButton, 0.0);
                AnchorPane.setRightAnchor(delButton, 80.0);
                AnchorPane.setLeftAnchor(delButton, 500.0);


                AnchorPane.setBottomAnchor(delUserButton, 100.0);
                AnchorPane.setTopAnchor(delUserButton, 100.0);
                AnchorPane.setRightAnchor(delUserButton, 80.0);
                AnchorPane.setLeftAnchor(delUserButton, 500.0);

                AnchorPane.setBottomAnchor(getUserButton, 0.0);
                AnchorPane.setTopAnchor(getUserButton, 200.0);
                AnchorPane.setRightAnchor(getUserButton, 80.0);
                AnchorPane.setLeftAnchor(getUserButton, 500.0);

                delButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {


                        try {


                            myController.dellMessage(Integer.parseInt(delNumber.getText()));

                            View.this.rebuildForum();
                        }catch (OutOfTextBoardRangeException ex){
                            View.this.errorLabel.setText("out of range ,last message has number"+ex.getNumber());
                        }

                    }
                });


                delUserButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {


                        try {


                            myController.deleteUser(delNumber.getText());

                            View.this.rebuildForum();
                        }catch (EmptyUserListExeption ex){
                            View.this.errorLabel.setText("user does not exist ");
                        }

                    }
                });


                getUserButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {




                            myController.setMode(3);

                            View.this.rebuildForum();


                    }
                });

                ///////////////////////////////////////////


                forum.getChildren().add(delButton);
                forum.getChildren().add(delUserButton);
                forum.getChildren().add(getUserButton);
                forum.getChildren().add(delNumber);


                for (int i = 0; i < MessageList.size(); i++) {
                    Label tempMessage = new Label(MessageList.get(i));


                    AnchorPane.setBottomAnchor(delButton, 25.0 + 50 * i);
                    AnchorPane.setTopAnchor(delButton, 250 - 25.0 - 50 * i - 50);
                    AnchorPane.setRightAnchor(delButton, 20.0);
                    AnchorPane.setLeftAnchor(delButton, 600.0);

                    AnchorPane.setBottomAnchor(tempMessage, 25.0 + 50 * i);
                    AnchorPane.setTopAnchor(tempMessage, 250 - 25.0 - 50 * i - 50);
                    AnchorPane.setRightAnchor(tempMessage, 80.0);
                    AnchorPane.setLeftAnchor(tempMessage, 20.0);


                    forum.getChildren().add(tempMessage);


                }
            }
        }
    }


}