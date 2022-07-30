package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newgroupchatcont implements Initializable {

    public TextField username;
    public ListView<String> results;
    public TextField groupname;
    public ListView<String> addedmembers;
    public Button create;
    public Text errorbox;

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;

    public ArrayList<User> users;
    public ArrayList<User> addedmemb;
    public String selecteduser;
    public User selected;
    public String groupnametext;
    public int indexof;
    boolean name;
    boolean members;

    public void newgroupchatcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene,Stage stage) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        newgroupchatcont.stage = stage;
        members = false;
        name = false;
        groupnametext = "";
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

    public void entergroupname(KeyEvent keyEvent) {
        groupnametext = groupname.getText();
        if (!groupnametext.equals("")) {
            name = !dataBase.Group_finder(groupnametext);
        }
        else {
            name = false;
        }
    }

    public void creategroup() {
        if (name && members) {
            user.creategroup(groupnametext , getAddedmemb());
            errorbox.setText("");
        }
        else  if (!name) {
            if (!groupnametext.equals("")) {
                errorbox.setText("Group with this name already exists.");
            }
            else {
                errorbox.setText("Enter a name for your group");
            }
        }
        else {
            errorbox.setText("You can't create a group with no users!");
        }
    }

    public void Back(){
        chatscont.back();
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

    public String getSelecteuser() {
        return selecteduser;
    }

    public void setSelecteduser (String selectedpv) {
        this.selecteduser = selectedpv;
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

    public ArrayList<User> getAddedmemb() {
        return addedmemb;
    }

    public void setAddedmemb(ArrayList<User> addedmemb) {
        this.addedmemb = addedmemb;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        results.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                setSelecteduser(results.getSelectionModel().getSelectedItem());
                indexof = results.getItems().indexOf(getSelecteuser());
                selected = users.get(indexof);
                if (user.checkblock(selected)){
                    errorbox.setText("This user has blocked you!");
                }
                else {
                    errorbox.setText("");
                    getAddedmembers().getItems().add(getSelecteuser());
                    getAddedmemb().add(selected);
                }

                if (getAddedmemb().size() == 0){
                    members = false;
                }
                else {
                    members = true;
                }

            }
        });

        addedmembers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                setSelecteduser(addedmembers.getSelectionModel().getSelectedItem());
                indexof = addedmembers.getItems().indexOf(getSelecteuser());
                selected = addedmemb.get(indexof);
                getAddedmembers().getItems().remove(getSelecteuser());
                getAddedmemb().remove(selected);

                if (getAddedmemb().size() == 0){
                    members = false;
                }
                else {
                    members = true;
                }

            }
        });

    }
}
