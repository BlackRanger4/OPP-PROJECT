package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newpvchatcont implements Initializable {

    public TextField username;
    public ListView<String> results;

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;

    public ArrayList<User> users;
    public String selectedpv;
    public User selected;
    public int indexof;


    public void search_user(KeyEvent keyEvent) {
        results.getItems().clear();
        if (users != null) {
            users.clear();
        }
        ArrayList<User> users = dataBase.User_Search(username.getText());
        ArrayList<User> temp = new ArrayList<>();
        for (User value : users) {
            results.getItems().add(value.getUser_Name());
        }
        System.out.println(username.getText());
    }

    public void newpvchatcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene , Stage stage) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        newpvchatcont.stage = stage;
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
        newpvchatcont.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void Back(){
        chatscont.back();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        results.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {

                selectedpv = results.getSelectionModel().getSelectedItem();
                indexof = results.getItems().indexOf(selectedpv);
                selected = users.get(indexof);
                if (user.checkpvret(selected) == null){
                    user.createpvchat(selected);
                    chatscont.setSelectedpv(user.checkpvret(selected));
                    Back();
                }

                else {
                    chatscont.setSelectedpv(user.checkpvret(selected));
                    Back();
                }

            }
        });

    }
}
