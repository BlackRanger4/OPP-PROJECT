package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.Group_Chat;
import com.example.try1.oop.PV_Chat;
import com.example.try1.oop.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class memberviewcont implements Initializable, Serializable {

    @FXML
    public ListView<User> members;

    private DataBase dataBase;
    private User user;
    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;
    private Group_Chat group;
    private Chatscont chatscont;

    public void memberviewcont(DataBase dataBase, User user, Scene scene, boolean dark_Mod,
                               Group_Chat group, Chatscont chatscont , Stage stage) {
        this.dataBase = dataBase;
        this.user = user;
        this.scene = scene;
        Dark_Mod = dark_Mod;
        this.group = group;
        this.chatscont = chatscont;
        memberviewcont.stage = stage;
        members.getItems().clear();
        members.getItems().addAll(group.getMembers());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        members.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List();
            }
        });
    }

    public void leavegroup() {
        user.getMy_Group_Chat().remove(group);
        group.getMembers().remove(user);
        members.getItems().remove(user);
        backtochat();
        chatscont.List2.refresh();
    }

    public void backtochat() {
        chatscont.reflists();
        chatscont.back();
    }

    class List extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List() {
            super();
            hBox.getChildren().addAll(imgview,pane);
            HBox.setHgrow(pane, Priority.ALWAYS);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
            this.setStyle("-fx-background-color: transparent;");
        }


        @Override
        public void updateItem(User user , boolean empty) {

            super.updateItem(user, empty);

            if (empty || user == null){
                setText(null);
                setGraphic(null);
            }

            else {
                setText(user.getUser_Name());
                imgview.setImage(user.getProfile_Image());
                setGraphic(hBox);
            }


        }
    }


}
