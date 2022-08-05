package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Search implements Serializable {


    public ListView<String> List;
    public TextField Text;
    public Label Error;
    public AnchorPane Anchorpane;

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
            Anchorpane.setStyle("-fx-background-color: #767676;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
        }

    }



    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }
    public void back(){
        stage.setScene(scene);

    }

    public void Next(MouseEvent mouseEvent) throws IOException {

        if (user.getUser_Name().equals(Text.getText())){
            Error.setText(" you can Search yourself ");
        }
        else if (dataBase.User_finder(Text.getText())){

            User user = dataBase.User_finder_U(Text.getText());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search_Selected.fxml"));
            Scene scene = new Scene(fxmlLoader.load() , 900,600);
            SearchSelected searchSelected = fxmlLoader.getController();
            searchSelected.searchselected(stage,scene,this,this.user,user,dataBase,Dark_Mod);
            stage.setScene(scene);

        }
        else {
            Error.setText(" no user exist with this name ");
        }
    }

    public void search_user(KeyEvent keyEvent) {

        List.getItems().clear();
        ArrayList<User> users = dataBase.User_Search(Text.getText());
        users.remove(user);
        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }
    }

}