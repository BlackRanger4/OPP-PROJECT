package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class newgroupchatcont {

    public TextField username;
    public ListView<String> results;
    public TextField groupname;
    public ListView<String> addedmembers;

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;

    public ArrayList<User> users;
    public String selectedpv;
    public User selected;
    public int indexof;

    public void newgroupchatcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        newgroupchatcont.stage = stage;
    }


    public void search_user(KeyEvent keyEvent) {
        results.getItems().clear();
        users.clear();
        ArrayList<User> users = dataBase.User_Search(username.getText());
        for (User value : users) {
            results.getItems().add(value.getUser_Name());
            users.add(value);
        }
    }





    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public ListView<String> getResults() {
        return results;
    }

    public void setResults(ListView<String> results) {
        this.results = results;
    }

    public TextField getGroupname() {
        return groupname;
    }

    public void setGroupname(TextField groupname) {
        this.groupname = groupname;
    }

    public ListView<String> getAddedmembers() {
        return addedmembers;
    }

    public void setAddedmembers(ListView<String> addedmembers) {
        this.addedmembers = addedmembers;
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
        newgroupchatcont.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getSelectedpv() {
        return selectedpv;
    }

    public void setSelectedpv(String selectedpv) {
        this.selectedpv = selectedpv;
    }

    public User getSelected() {
        return selected;
    }

    public void setSelected(User selected) {
        this.selected = selected;
    }

    public int getIndexof() {
        return indexof;
    }

    public void setIndexof(int indexof) {
        this.indexof = indexof;
    }
}
