package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.Group_Chat;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

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

    public Button applychanges;
    public TextField grname;
    public Button grouppic;
    public ListView<User> members = new ListView<>();
    public ListView<User> results = new ListView<>();
    public TextField username;
    public ContextMenu contextMenu;
    public MenuItem removeuser = new MenuItem();
    public MenuItem banuser = new MenuItem();
    public MenuItem unbanuser = new MenuItem();
    public ImageView grouppicview;
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
        removeuser.setText("Remove");
        banuser.setText("Ban");
        unbanuser.setText("Unban");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        removeuser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getMembers().remove(selectedmember);
            }
        });

        banuser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getBanned().add(selectedmember);
            }
        });

        unbanuser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getBanned().remove(selectedmember);
            }
        });


        members.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user, User t1) {


                selectedmember = members.getSelectionModel().getSelectedItem();

                if (!group.getBanned().contains(selectedmember)) {

                    contextMenu.getItems().clear();
                    contextMenu.getItems().addAll(removeuser,banuser);
                    members.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                        @Override
                        public void handle(ContextMenuEvent event) {
                            contextMenu.show(members.getScene().getWindow(), event.getScreenX(), event.getScreenY());
                            members.getSelectionModel().getSelectedIndices().clear();
                        }
                    });

                }

                else {

                    contextMenu.getItems().clear();
                    contextMenu.getItems().addAll(removeuser,unbanuser);
                    members.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                        @Override
                        public void handle(ContextMenuEvent event) {
                            contextMenu.show(members.getScene().getWindow(), event.getScreenX(), event.getScreenY());
                            members.getSelectionModel().getSelectedIndices().clear();
                        }
                    });
                }
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
        chatscont.back();
    }



}
