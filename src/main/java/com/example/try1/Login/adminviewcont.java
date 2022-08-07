package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.Group_Chat;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class adminviewcont implements Initializable, Serializable {


    private DataBase dataBase;
    private User user;
    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;
    private Group_Chat group;
    private Chatscont chatscont;

    @FXML
    public TextField grname ;
    @FXML
    public Button grouppic ;
    @FXML
    public ListView<User> members ;
    @FXML
    public ListView<User> results ;
    @FXML
    public TextField username;
    @FXML
    public ImageView grouppicview ;


    public ArrayList<User> searched = new ArrayList<>();

    public User selectedmember;


    public void adminviewcont(DataBase dataBase, User user, Scene scene, boolean dark_Mod ,Group_Chat gr1,
                              Chatscont chatscont, Stage stage) {
        this.dataBase = dataBase;
        this.user = user;
        this.scene = scene;
        this.group = gr1;
        this.chatscont = chatscont;
        adminviewcont.stage = stage;
        Dark_Mod = dark_Mod;
        members.getItems().addAll(gr1.getMembers());
        grname.setText(group.getGroupName());
        grouppicview.setImage(group.getImage());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        members.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List3();
            }
        });

        results.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List2();
            }
        });


    }

    public void namechanging() {
        group.setGroupName(grname.getText());
    }

    public void searchuser () {
        searched = user.searchfromfollow(username.getText());
        results.getItems().clear();
        results.getItems().addAll(searched);
    }

    public void back() {
        chatscont.reflists();
        chatscont.back();
    }

    class List3 extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Label name = new Label();
        Button ban = new Button("Ban");
        Button remove = new Button("Remove");
        Pane pane = new Pane();



        public List3() {
            super();
            hBox.getChildren().addAll(imgview,name,pane,ban,remove);
            HBox.setHgrow(pane, Priority.ALWAYS);
            hBox.setAlignment(Pos.CENTER);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
        }


        @Override
        public void updateItem(User user, boolean empty) {

            super.updateItem( user, empty);

            if (empty || user == null){
                setGraphic(null);
            }

            else {
                name.setText(user.getUser_Name());
                ban.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (ban.getText().equals("Ban")) {
                            group.getBanned().add(user);
                            ban.setText("Unaban");
                            name.setTextFill(Color.RED);
                        }
                        else {
                            group.getBanned().remove(user);
                            ban.setText("Ban");
                            name.setTextFill(Color.BLACK);
                        }
                    }
                });
                remove.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        group.getMembers().remove(user);
                        members.getItems().remove(user);
                        user.getMy_Group_Chat().remove(group);
                    }
                });
                imgview.setImage(user.getProfile_Image());
                setGraphic(hBox);
            }

        }
    }

    class List2 extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Label name = new Label();
        Button add = new Button("Add");
        Pane pane = new Pane();



        public List2() {
            super();
            hBox.getChildren().addAll(imgview,name,pane,add);
            HBox.setHgrow(pane, Priority.ALWAYS);
            hBox.setAlignment(Pos.CENTER);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
        }


        @Override
        public void updateItem(User user, boolean empty) {

            super.updateItem( user, empty);

            if (empty || user == null){
                setGraphic(null);
            }

            else {
                name.setText(user.getUser_Name());
                add.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!group.getMembers().contains(user)) {
                            group.getMembers().add(user);
                            members.getItems().add(user);
                            user.getMy_Group_Chat().add(group);
                        }
                        else {
                            members.getSelectionModel().select(user);
                        }
                    }
                });
                imgview.setImage(user.getProfile_Image());
                setGraphic(hBox);
            }

        }
    }

}
