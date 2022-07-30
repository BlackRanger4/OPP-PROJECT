package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Home {


    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;
    private DataBase dataBase;
    private User user;

    public void home(Stage stage ,Scene scene,FirstMenu firstMenu,DataBase dataBase,User user){

        this.stage =stage;
        this.scene =scene;
        this.firstMenu =firstMenu;
        this.dataBase =dataBase;
        this.user =user;
        My_Post();
    }


    public TextField Text_field;
    public Label Post_text;
    public ImageView Post_Image;
    public ListView<String> List;
    public ImageView Post_Creater_Image;
    public Label Post_Create_time;
    public Label Post_Creater_Name;
    public Label Post_Views;
    public Label Posr_Likes;

    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }

    public void CraetePost_or_Follow_UnFollow(MouseEvent mouseEvent) {
    }

    public void Add_Like(MouseEvent mouseEvent) {
    }

    public void Add_Comment(MouseEvent mouseEvent) {
    }

    public void See_Likers(MouseEvent mouseEvent) {
    }

    public void See_Viewers(MouseEvent mouseEvent) {
    }

    public void See_Comments(MouseEvent mouseEvent) {
    }

    public void Next_Post(MouseEvent mouseEvent) {
    }

    public void Last_Post(MouseEvent mouseEvent) {
    }

    public void My_Post(MouseEvent mouseEvent) {
    }
    public void My_Post() {
    }

    public void My_Following_Post(MouseEvent mouseEvent) {
    }

    public void Post_Analyze_or_Nextuser(MouseEvent mouseEvent) {
    }

    public void Page_Analyze_or_Pastuser(MouseEvent mouseEvent) {
    }

}