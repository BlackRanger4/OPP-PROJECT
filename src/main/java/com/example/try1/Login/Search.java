package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {


    public ListView<User> List;
    public TextField Text;
    public AnchorPane Anchorpane;
    public Button Button;


    private DataBase dataBase;
    private User user;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;

    public void search(Stage stage ,Scene scene,FirstMenu firstMenu,User user ,DataBase dataBase ,boolean Dark_Mod ){

        this.stage = stage;
        this.scene =scene;
        this.firstMenu =firstMenu;
        this.user =user;
        this.dataBase =dataBase;
        this.Dark_Mod =Dark_Mod;
        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
            Text.setStyle("-fx-background-color: #E7717D;");
            List.setStyle("-fx-background-color: #E7717D;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            Text.setStyle("-fx-background-color: #AC3B61;");
            List.setStyle("-fx-background-color: #E7717D;");
        }

    }



    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }
    public void back(){
        stage.setScene(scene);

    }


    public void search_user(KeyEvent keyEvent) {
        List.getItems().clear();
        ArrayList<User> users = dataBase.User_Search(Text.getText());
        users.remove(user);
        List.getItems().addAll(users);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List3();
            }
        });

        List.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user1, User t1) {

                User selecteduser = List.getSelectionModel().getSelectedItem();

                if (selecteduser != null) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search_Selected.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 900, 600);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    SearchSelected searchSelected = fxmlLoader.getController();
                    searchSelected.searchselected(stage, scene, Search.this, user, selecteduser, dataBase, Dark_Mod);
                    stage.setScene(scene);
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