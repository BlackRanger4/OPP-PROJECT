package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class newpvchatcont implements Initializable {

    public TextField username;
    public ListView<User> results;
    public javafx.scene.control.Button Button;
    public AnchorPane Anchorpane;

    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;

    public User selecteduser;
    public PV_Chat created;
    public int indexof;


    public void search_user(KeyEvent keyEvent) {
        results.getItems().clear();
        results.getItems().addAll(dataBase.User_Search(username.getText()));
        results.getItems().remove(user);
    }

    public void newpvchatcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene , Stage stage , boolean Dark_Mod) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        newpvchatcont.stage = stage;

        if (Dark_Mod){
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
            username.setStyle("-fx-background-color: #E7717D;");
            results.setStyle("-fx-background-color: #E7717D;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            username.setStyle("-fx-background-color: #AC3B61;");
            results.setStyle("-fx-background-color: #AC3B61;");
        }


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
        chatscont.reflists();
        chatscont.back();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        results.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List3();
            }
        });

        results.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user1, User t1) {


                selecteduser = results.getSelectionModel().getSelectedItem();

                if (user.checkpvret(selecteduser) != null) {
                    chatscont.porg.setValue("pv chats");
                    chatscont.List1.getSelectionModel().select(user.checkpvret(selecteduser));
                    chatscont.back();
                }
                else {
                    chatscont.porg.setValue("pv chats");
                    created = user.createpvchat(selecteduser);
                    chatscont.List1.getItems().add(created);
                    chatscont.List1.getSelectionModel().select(created);
                    chatscont.back();
                }

            }
        });
    }


    class List3 extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List3() {
            super();
            hBox.getChildren().addAll(imgview,pane);
            HBox.setHgrow(pane, Priority.ALWAYS);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
            this.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        }


        @Override
        public void updateItem(User user, boolean empty) {

            super.updateItem( user, empty);

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
