package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class LoginToAccount implements Serializable {

    public  Label Q2 ;
    public  Label Q1 ;
    public Label Error;
    public TextField Pass_or_A2;
    public TextField Name_or_A1;


    private static Stage stage;
    public AnchorPane Anchorpane;
    private Scene scene;
    private FirstPage firstPage;
    private DataBase dataBase;

    private String userName;

    public void logintoaccount(Stage stage , Scene scene , FirstPage firstPage ,DataBase dataBase ){

        this.stage = stage;
        this.scene = scene;
        this.firstPage = firstPage;
        this.dataBase = dataBase;


        Q1.setText("User Name");
        Q2.setText("Password");
        Error.setText("");
    }

    public void Back(MouseEvent mouseEvent) {
        firstPage.Back();
    }
    public void back(){

        stage.setScene(scene);
        Q1.setText("User Name");
        Q2.setText("Password");
        Error.setText("");
    }

    public void Forget_Pass(MouseEvent mouseEvent) {

        Q1.setText(" What is the name of your favorite pet? ");
        Q2.setText(" What was your favorite food as a child? ");
        userName = Name_or_A1.getText();
        Name_or_A1.setText("");
        Pass_or_A2.setText("");
        Error.setText("");
    }

    public void Login_to_acc(MouseEvent mouseEvent) throws IOException {

        if (Q1.getText().equals("User Name")){

            if (dataBase.User_finder(Name_or_A1.getText())){

                User user = dataBase.User_finder_U(Name_or_A1.getText());

                if (user.getPassword().equals(Pass_or_A2.getText())){
                Log_to_acc(user);
                }
                else {
                 Error.setText("Password isn't correct");
                }
            }
            else {
            Error.setText("No User exist with this name");
            }
        }
        else {

            if (dataBase.User_finder(userName)){

                User user = dataBase.User_finder_U(userName);

                if (Name_or_A1.getText().equals(user.getSecurity_A()[0])){
                    if (Pass_or_A2.getText().equals(user.getSecurity_A()[1])){

                        Log_to_acc(user);
                    }
                    else {
                        Error.setText(" sorry We can't give you access to your account");
                    }
                }
                else {
                    Error.setText(" sorry We can't give you access to your account");
                }
            }
            else {
                Error.setText("No User exist with this name");
            }
        }
    }
    public void Log_to_acc(User user) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirstMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        FirstMenu firstMenu = fxmlLoader.getController();
        firstMenu.firstmenu(stage,scene,this,dataBase,user,false);
        stage.setScene(scene);
    }

}