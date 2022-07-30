package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPage {

    private static Stage stage;
    private Scene scene;
    private  DataBase dataBase;


    public void Login(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login_to_account.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        LoginToAccount loginToAccount = fxmlLoader.getController();
        loginToAccount.logintoaccount(stage,scene,this,dataBase);

    }

    public void Create_Account(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Create_account.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        CreateAccount createAccount = fxmlLoader.getController();
        createAccount.Loading(this,dataBase);
    }

    public void Back(){
        stage.setScene(scene);
    }

    public void Exit(MouseEvent mouseEvent) {
        Store_Data_Base();
    }

    public void Read_Data_Base(){
        DataBase dataBase = new DataBase();
        this.dataBase = dataBase ;
    }
    public void Store_Data_Base(){

        System.exit(0);
    }
    public void firstPage (Stage stage ,Scene scene){
        FirstPage.stage = stage;
        this.scene = scene;
        Read_Data_Base();
    }

}
