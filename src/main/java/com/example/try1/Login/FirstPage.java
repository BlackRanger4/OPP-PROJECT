package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class FirstPage implements Serializable {

    //version 1.0.0.0

    private static Stage stage;
    public AnchorPane Anchorpane;
    private Scene scene;
    private  DataBase dataBase;
    public Connection conn;



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

    public void Exit(MouseEvent mouseEvent) throws SQLException {
        Store_Data_Base();
    }

    public void Read_Data_Base() throws Exception {
        DataBase test = new DataBase();
        setDataBase(test);
        conn = getDataBase().getConnection();
        if (getDataBase().checkdata(conn)) {
            setDataBase(getDataBase().loaddata(conn));
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        FirstPage.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void Store_Data_Base() throws SQLException {
        dataBase.savedata(conn);
        System.exit(0);
    }
    public void firstPage (Stage stage ,Scene scene) throws Exception {
        FirstPage.stage = stage;
        this.scene = scene;
        Read_Data_Base();
        Anchorpane.setStyle("-fx-background-color: #767676;");
    }

}