package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class CreateAccount implements Serializable {

    public TextField Text;
    public Label Question;
    public Label Error;
    public Button Next_B;
    public AnchorPane Anchorpane;

    private FirstPage firstPage;
    private DataBase dataBase;
    private String Name ="";
    private String Pass ="";
    private boolean Business ;
    private String[] A = new String[2];


    public void Next(MouseEvent mouseEvent) {

        switch (Question.getText()) {
            case " Enter User Name ":

                User_Name(Text.getText());
                break;
            case " Enter your password ":

                Password(Text.getText());
                break;
            case " Repeat your password " :

                Password_Confirm(Text.getText());
                break;
            case " Are you want create business account? ":

                Business_Normal(Text.getText());
                break;
            case " What is the name of your favorite pet? ":

                First_answer(Text.getText());
                break;
            case " What was your favorite food as a child? ":

                Second_answer(Text.getText());
                break;
        }
    }

    public void Back(MouseEvent mouseEvent) {
        firstPage.Back();
    }

    public void User_Name(String user){

        if (user.equals("")){
            Error.setText(" you must enter a name ");
            return;
        }

        if (dataBase.User_finder(user)){
            Error.setText(" a user exist with this user name ");
        }

        else {

            Error.setText("");
            Question.setText(" Enter your password ");
            Text.setText("");
            Name = user ;
        }

    }
    private void Password(String text) {

        if (Pass_analyze(text)){
         Pass = text;
         Error.setText("");
         Question.setText(" Repeat your password ");
            Text.setText("");
        }
    }
    public boolean Pass_analyze (String temp){

        if (temp.length() < 8){
            Error.setText(" more then 8 characters ");
            return false;
        }

        int Size = temp.length();
        boolean Num = false;
        boolean Big = false;
        boolean Small = false;

        for (int i =0; i< Size ;i++){

            if (temp.charAt(i)<='9' && temp.charAt(i)>='0'){
                Num = true;
            }
            else if (temp.charAt(i)<='z' && temp.charAt(i)>='a'){
                Small = true;
            }
            else if (temp.charAt(i)<='Z' && temp.charAt(i)>='A'){
                Big = true;
            }

        }

        if (!Num){
            Error.setText(" a number must be used ");
            return false;
        }
        if (!Big){
            Error.setText(" a Big letter must be used ");
            return false;
        }
        if (!Small){
            Error.setText(" a Small letter must be used ");
            return false;
        }

        return true;
    }
    private void Password_Confirm(String text) {
        if (text.equals(Pass)){

            Error.setText("");
            Question.setText(" Are you want create business account? ");
            Text.setText("");
        }
        else {
            Error.setText(" not same ");
        }
    }
    private void Business_Normal(String text) {

        if (text.equals("yes")){

            Error.setText("");
            Question.setText(" What is the name of your favorite pet? ");
            Business = true;
            Text.setText("");

        }
        else if (text.equals("no")){

            Error.setText("");
            Question.setText(" What is the name of your favorite pet? ");
            Business = false;
            Text.setText("");
        }
        else {
            Error.setText(" yes or no ");
        }
    }
    private void First_answer(String text) {

        A[0] = text;
        Question.setText(" What was your favorite food as a child? ");
        Next_B.setText("Create");
        Text.setText("");
    }
    private void Second_answer(String text) {

        A[1] = text;
        Text.setText("");
        Next_B.setText("...");
        User_Create();
    }
    private void User_Create(){

        String[] Q = new String[2];
        Q[0] = " What is the name of your favorite pet? ";
        Q[1] = " What was your favorite food as a child? ";

        User user = new User(Name,Pass,Business,dataBase, Q ,A);
        user.setProfile_Image(String.valueOf(getClass().getResource("defpic.png")));
        dataBase.Add_User_to_datas(user);
        Question.setText(Name + " , your account created successfully , click on back to go first menu.");

    }

    public void Loading(FirstPage firstPage , DataBase dataBase ){
        this.firstPage =firstPage;
        this.dataBase = dataBase;

        Question.setText(" Enter User Name ");
    }

}