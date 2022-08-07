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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class adminviewcont implements Initializable, Serializable {


    public javafx.scene.control.Label Label;
    public Button backbutton;
    public javafx.scene.control.Label Label2;
    public javafx.scene.control.Label Label3;
    public javafx.scene.control.Label Label1;
    public AnchorPane Anchorpane;

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

        if (Dark_Mod){
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            backbutton.setStyle("-fx-background-color: #6F2232;");
            backbutton.setTextFill(Paint.valueOf("WHITE"));
            grouppic.setStyle("-fx-background-color: #6F2232;");
            grouppic.setTextFill(Paint.valueOf("WHITE"));
            members.setStyle("-fx-background-color: #E7717D;");
            results.setStyle("-fx-background-color: #E7717D;");
            grname.setStyle("-fx-background-color: #E7717D;");
            username.setStyle("-fx-background-color: #E7717D;");
            Label.setTextFill(Paint.valueOf("#950740"));
            Label1.setTextFill(Paint.valueOf("#950740"));
            Label2.setTextFill(Paint.valueOf("#950740"));
            Label3.setTextFill(Paint.valueOf("#950740"));
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            backbutton.setStyle("-fx-background-color: #EDC7B7;");
            backbutton.setTextFill(Paint.valueOf("#AC3B61"));
            grouppic.setStyle("-fx-background-color: #EDC7B7;");
            grouppic.setTextFill(Paint.valueOf("#AC3B61"));
            members.setStyle("-fx-background-color: #E7717D;");
            results.setStyle("-fx-background-color: #E7717D;");
            grname.setStyle("-fx-background-color: #E7717D;");
            username.setStyle("-fx-background-color: #E7717D;");
            Label.setTextFill(Paint.valueOf("#AC3B61"));
            Label1.setTextFill(Paint.valueOf("#AC3B61"));
            Label2.setTextFill(Paint.valueOf("#AC3B61"));
            Label3.setTextFill(Paint.valueOf("#AC3B61"));
        }

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

    public void ChangeFig(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.*"));
        File file = fileChooser.showOpenDialog(null);

        if ( file != null) {
            try {
                Image image = new Image(file.toURI().toString());
                grouppicview.setImage(image);
                group.setImage(file.toURI().toString());
            }
            catch (Exception e){}
        }

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
