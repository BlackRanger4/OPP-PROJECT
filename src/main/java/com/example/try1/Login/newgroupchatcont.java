package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newgroupchatcont implements Initializable, Serializable {

    public TextField username;
    public ListView<String> results;
    public TextField groupname;
    public ListView<String> addedmembers;
    public Button create;
    public Text errorbox;
    public javafx.scene.text.Text Text;
    public javafx.scene.text.Text Text1;
    public javafx.scene.control.Button Button;
    public javafx.scene.text.Text Text2;
    public AnchorPane Anchorpane;
    public javafx.scene.text.Text Text4;

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;

    public ArrayList<User> addedmemb;
    public String selecteduser;
    public User selected;
    public String groupnametext;
    public int indexof;
    boolean name;
    boolean members;

    public void newgroupchatcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene,Stage stage,boolean Dark_Mod) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        newgroupchatcont.stage = stage;
        members = false;
        name = false;
        groupnametext = "";
        addedmemb = new ArrayList<>();

        if (Dark_Mod){
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
            username.setStyle("-fx-background-color: #E7717D;");
            results.setStyle("-fx-background-color: #E7717D;");
            Text.setFill(Paint.valueOf("#950740"));
            Text1.setFill(Paint.valueOf("#950740"));
            Text2.setFill(Paint.valueOf("#950740"));
            Text4.setFill(Paint.valueOf("#950740"));
            create.setStyle("-fx-background-color: #6F2232;");
            create.setTextFill(Paint.valueOf("WHITE"));
            addedmembers.setStyle("-fx-background-color: #E7717D;");
            groupname.setStyle("-fx-background-color: #E7717D;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            username.setStyle("-fx-background-color: #EDC7B7;");
            results.setStyle("-fx-background-color: #EDC7B7;");
            Text.setFill(Paint.valueOf("#AC3B61"));
            Text1.setFill(Paint.valueOf("#AC3B61"));
            Text2.setFill(Paint.valueOf("#AC3B61"));
            Text4.setFill(Paint.valueOf("#AC3B61"));
            create.setStyle("-fx-background-color: #EDC7B7;");
            create.setTextFill(Paint.valueOf("#AC3B61"));
            addedmembers.setStyle("-fx-background-color: #E7717D;");
            groupname.setStyle("-fx-background-color: #E7717D;");
        }

    }


    public void search_user(KeyEvent keyEvent) {
        results.getItems().clear();
        ArrayList<User> users = user.searchfromfollow(username.getText());
        users.remove(user);

        for (User value : users) {
            results.getItems().add(value.getUser_Name());
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
        chatscont.back();
    }

    public void Back(){
        chatscont.reflists();
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

    public String getSelecteduser() {
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

        addedmembers.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> stringListView) {
                return new Add();
            }
        });
        results.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> stringListView) {
                return new results();
            }
        });

    }


    class Add extends ListCell<String> {
        HBox hBox = new HBox();
        Label label = new Label();
        Pane pane = new Pane();
        Button button = new Button();

        public Add() {
            super();
            hBox.getChildren().addAll(label,pane,button);
            HBox.setHgrow(pane,Priority.ALWAYS);
            button.setText("x");
        }


        @Override
        public void updateItem(String person, boolean empty) {
            super.updateItem(person, empty);
            if (empty || person == null) {
                setText(null);
                setGraphic(null);
            } else {
                label.setText(person);
                setGraphic(hBox);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        getAddedmembers().getItems().remove(person);
                    }
                });
            }
        }
    }

    class results extends ListCell<String> {
        HBox hBox = new HBox();
        Label label = new Label();
        Pane pane = new Pane();
        Button button = new Button();

        public results() {
            super();
            hBox.getChildren().addAll(label,pane,button);
            HBox.setHgrow(pane,Priority.ALWAYS);
            button.setText("+");
        }


        @Override
        public void updateItem(String person, boolean empty) {
            super.updateItem(person, empty);
            if (empty || person == null) {
                setText(null);
                setGraphic(null);
            } else {
                label.setText(person);
                setGraphic(hBox);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setSelecteduser(person);
                        selected = dataBase.User_finder_U(getSelecteduser());
                                if (user.checkblock(selected)){
                                    errorbox.setText("This user has blocked you!");
                                }
                                else if (getAddedmembers().getItems().contains(person)){
                                    errorbox.setText("You have added this user!");
                                }
                                else {
                                    errorbox.setText("");
                                    getAddedmembers().getItems().add(getSelecteduser());
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
                    }
                }
    }
}