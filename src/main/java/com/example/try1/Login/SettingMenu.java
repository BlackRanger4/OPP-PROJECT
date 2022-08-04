package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class SettingMenu implements Serializable {

    public TextField Text;
    public Label Error;
    public ListView<String> List;
    public Label Information;
    public javafx.scene.control.Button Button;
    public ImageView Profile_fig;
    public Label User_Name;


    private FirstMenu firstMenu;
    private User user;
    private DataBase dataBase;


    public void settingmenu(FirstMenu firstMenu , User user, DataBase dataBase){
        this.firstMenu =firstMenu;
        this.user =user;
        this.dataBase =dataBase;

        User_Name.setText(user.getUser_Name());
        Information.setText(" Select a button ");
        Error.setText("");
        List.getItems().clear();
        Text.setText("");
        Button.setText(".");
        try {
            Profile_fig.setImage(user.getProfile_Image());
        }
        catch (NullPointerException e){}
    }

    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }

    public void Change_Name(MouseEvent mouseEvent) {

        List.getItems().clear();
        Error.setText("");
        Information.setText(" enter new user name ");
        Text.setText("");
        Button.setText("Change");

    }

    public void Change_Pass(MouseEvent mouseEvent) {

        List.getItems().clear();
        Error.setText("");
        Information.setText(" enter new password ");
        Text.setText("");
        Button.setText("Change");

    }

    public void Blocked_User(MouseEvent mouseEvent) {

        List.getItems().clear();
        Error.setText("");
        Information.setText(" enter name of user you want to unblock ");
        Text.setText("");
        Button.setText("Unblock");
        List_Completer();

    }
    private void List_Completer() {

        ArrayList<User> users = user.getBlocked_User();
        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }
    }

    public void Change_Theme(MouseEvent mouseEvent) {
    }

    public void First_A(MouseEvent mouseEvent) {

        List.getItems().clear();
        Error.setText("");
        Information.setText(" What is the name of your favorite pet? ");
        Text.setText("");
        Button.setText("Change");
    }

    public void Second_A(MouseEvent mouseEvent) {

        List.getItems().clear();
        Error.setText("");
        Information.setText(" What was your favorite food as a child? ");
        Text.setText("");
        Button.setText("Change");
    }

    public void DO(MouseEvent mouseEvent) {

        switch (Information.getText()) {
            case " enter new user name ":

                UserName_Changer(Text.getText());
                break;
            case " enter new password ":

                PassWord_Changer(Text.getText());
                break;
            case " enter name of user you want to unblock ":

                Unblocker(Text.getText());
                break;
            case  " What is the name of your favorite pet? ":

                First_A_C(Text.getText());
                break;
            case  " What was your favorite food as a child? ":

                Second_A_C(Text.getText());
                break;
            default:

                Error.setText(" select a button ");
                break;
        }
    }

    private void Unblocker(String text) {

        if (user.getUnblocked_user(text) == null){

            Error.setText(" no user blocked with this name ");
        }
        else {
            user.Unblocked_User(user.getUnblocked_user(text));

            Error.setText(" user unblocked ");
            Text.setText("");
            List.getItems().clear();
            List_Completer();
        }
    }

    private void PassWord_Changer(String text) {

        if (Pass_analyze(text)){
        user.setPassword(text);
        Error.setText("");
        Information.setText(" password changed ");
        Button.setText(".");
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

    private void UserName_Changer(String text) {

        if (!dataBase.User_finder(text)){
            user.setUser_Name(text);
            Error.setText("");
            Information.setText(" UserName changed ");
            Button.setText(".");
            Text.setText("");
            User_Name.setText(user.getUser_Name());
        }
        else {
            Error.setText(" a user exist with this name ");
        }
    }

    private void Second_A_C(String text) {

        String[] A = user.getSecurity_A();
        A[1] = text;
        Error.setText("");
        Information.setText(" Security answer changed ");
        Button.setText(".");
        Text.setText("");

    }

    private void First_A_C(String text) {

        String[] A = user.getSecurity_A();
        A[0] = text;
        Error.setText("");
        Information.setText(" Security answer changed ");
        Button.setText(".");
        Text.setText("");

    }

    public void Change_Fid(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.*"));
        File file = fileChooser.showOpenDialog(null);

        if ( file != null) {
            try {
                Image image = new Image(file.toURI().toString());
                Profile_fig.setImage(image);
                user.setProfile_Image(file.toURI().toString());
            }
            catch (Exception e){}
        }
    }

}