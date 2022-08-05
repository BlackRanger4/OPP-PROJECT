package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class forwardcont implements Initializable, Serializable {

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;
    private Message message;


    public Button cancel;
    public ChoiceBox<String> choose;
    public TextField searchingbox;
    public ListView<User> List1;
    public ListView<Group_Chat> List2;

    static String[] choice = {"PV chats","Group chats"};
    public String textmssg;
    public ArrayList<User> resultpvchat = new ArrayList<>();
    public ArrayList<Group_Chat> resultgrchat = new ArrayList<>();
    public ArrayList<String> result = new ArrayList<>();
    boolean pvorgr;
    String selectedchat;
    public User selecteduser;
    public Group_Chat selectedgr;


    public void forwardcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene, Message message , Stage stage) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        this.message = message;
        forwardcont.stage = stage;
        pvorgr = false;
    }

    public void cancelfor () {
        chatscont.Back();
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatscont getChatscont() {
        return chatscont;
    }

    public void setChatscont(Chatscont chatscont) {
        this.chatscont = chatscont;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        forwardcont.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ArrayList<User> getResultpvchat() {
        return resultpvchat;
    }

    public void setResultpvchat(ArrayList<User> resultpvchat) {
        this.resultpvchat = resultpvchat;
    }

    public ArrayList<Group_Chat> getResultgrchat() {
        return resultgrchat;
    }

    public void setResultgrchat(ArrayList<Group_Chat> resultgrchat) {
        this.resultgrchat = resultgrchat;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choose.getItems().addAll(choice);
        choose.setValue("PV chats");

        List1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user, User t1) {

                selecteduser = List1.getSelectionModel().getSelectedItem();

                if (user.checkpvret(selecteduser) != null){
                    user.checkpvret(selecteduser).getMessages().add(message);
                }
                else {
                    user.createpvchat(selecteduser);
                    Message temp = null;
                    if (message.getImage() != null && message.getForwarded()==null) {
                        temp = new Message(user, message.getText(), null,
                                message.getSender(), message.getImage().getUrl());
                    }
                    if (message.getImage() != null && message.getForwarded()!=null){
                        temp = new Message(user, message.getText(), null,
                                message.getForwarded(), message.getImage().getUrl());
                    }
                   if (message.getImage() == null && message.getForwarded()==null) {
                        temp = new Message(user, message.getText(), null,
                                message.getSender(), message.getImage().getUrl());
                    }
                   if (message.getImage() == null && message.getForwarded()!=null){
                       temp = new Message(user, message.getText(), null,
                               message.getForwarded(), message.getImage().getUrl());
                   }
                    user.checkpvret(selecteduser).getMessages().add(temp);
                }

            }
        });

        List2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group_Chat>() {
            @Override
            public void changed(ObservableValue<? extends Group_Chat> observableValue, Group_Chat group_chat, Group_Chat t1) {

                selectedgr = List2.getSelectionModel().getSelectedItem();

                Message temp = null;
                if (message.getImage() != null && message.getForwarded()==null) {
                    temp = new Message(user, message.getText(), null,
                            message.getSender(), message.getImage().getUrl());
                }
                if (message.getImage() != null && message.getForwarded()!=null){
                    temp = new Message(user, message.getText(), null,
                            message.getForwarded(), message.getImage().getUrl());
                }
                if (message.getImage() == null && message.getForwarded()==null) {
                    temp = new Message(user, message.getText(), null,
                            message.getSender(), message.getImage().getUrl());
                }
                if (message.getImage() == null && message.getForwarded()!=null){
                    temp = new Message(user, message.getText(), null,
                            message.getForwarded(), message.getImage().getUrl());
                }
                selectedgr.getMessages().add(temp);

            }
        });

    }

    public void searchbox() {
        textmssg = searchingbox.getText();
        if (!pvorgr) {
            setResultpvchat(user.searchfromfollow(textmssg));
            List1.getItems().clear();
            List1.getItems().addAll(getResultpvchat());
        }
        else {
            setResultgrchat(user.getMy_Group_Chat());;
            List2.getItems().clear();
            List2.getItems().addAll(getResultgrchat());
        }
    }

    public void recogchoose () {
        pvorgr = !choose.getValue().equals("PV chats");
        if (!pvorgr) {
            List1.setVisible(true);
            List2.setVisible(false);
        }
        else {
            List2.setVisible(true);
            List1.setVisible(false);
        }
    }



}
