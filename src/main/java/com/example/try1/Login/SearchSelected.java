package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.PV_Chat;
import com.example.try1.oop.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class SearchSelected implements Serializable {
    
    public ImageView Prof;
    public Label UserName;
    public Label Followers_num;
    public Label Followings_num;
    public ListView<String> List;
    public Label Text;
    public Button Follow_Button;

    private static Stage stage;
    private Scene scene;
    private Search search;
    private User user;
    private User user_selected;
    private DataBase dataBase;


    public void searchselected(Stage stage,Scene scene,Search search,User user,User user_selected,DataBase dataBase){

        this.stage =stage;
        this.scene =scene;
        this.search =search;
        this.user =user;
        this.user_selected =user_selected;
        this.dataBase =dataBase;

        try {
            this.Prof.setImage(user_selected.getProfile_Image());
        }
        catch (Exception e){}
        this.UserName.setText(user_selected.getUser_Name());
        this.Followers_num.setText("Followers:"+user_selected.getMy_Followers_num());
        this.Followings_num.setText("Followings:"+user_selected.getMy_Followings_num());
        this.Text.setText("");
        List.getItems().clear();

        if (user_selected.getBusiness()){
            user_selected.add_view_page();
        }

        if (user_selected.Is_my_followers(user)){
            Follow_Button.setText("Unfollow");
        }

    }

    public void Back(MouseEvent mouseEvent) {
        search.back();
    }
    public void back(){
        stage.setScene(scene);
    }

    public void Posts(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("See_Post_of_user.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        SeePostOfUser seePostOfUser = fxmlLoader.getController();
        seePostOfUser.seepostofuser(this,user,user_selected);
        stage.setScene(scene);
    }

    public void Create_Pv_Chat(MouseEvent mouseEvent){

        Text.setText("");
        List.getItems().clear();

        if (checkpv(this.user , user_selected)){
            Text.setText("You already have a pv chat with this user");
        }
        else {
            if (user_selected.getBlocked_User().contains(this.user)){
                Text.setText("User with this username has blocked you");
            }
            else if (this.user.getBlocked_User().contains(user_selected)){
                Text.setText("You have blocked this user.first you have to unblock.");
            }
            else {
                PV_Chat test = new PV_Chat(this.user, user_selected, null, dataBase);
                this.user.getMy_Privete_Chat().add(test);
                user_selected.getMy_Privete_Chat().add(test);
                dataBase.Add_PV_Chat(test);
                Text.setText(" pv chat created , for chat, go to chats and select the chat you created ");
            }
        }
    }
    public boolean checkpv (User x , User y){
        int i;
        int cap = x.getMy_Privete_Chat().size();
        for (i=0;i<cap;i++){
            if (x.getMy_Privete_Chat().get(i).getSecond().getUser_Name().equals(y.getUser_Name()) ||
                    x.getMy_Privete_Chat().get(i).getFirst().getUser_Name().equals(y.getUser_Name())){
                return true;
            }
        }
        return false;
    }

    public void Follow_unFollow(MouseEvent mouseEvent) {

        Text.setText("");
        List.getItems().clear();

        if (user_selected.Is_my_followers(user)){
            Follow_Button.setText("Follow");
        }
        else {
            Follow_Button.setText("Unfollow");
        }
        this.user.unfollowing_following_me(user_selected);
        this.Followers_num.setText("Followers:"+user_selected.getMy_Followers_num());
    }

    public void Print_Followers(MouseEvent mouseEvent) {

        Text.setText("");
        List.getItems().clear();

        ArrayList<User> users = user_selected.getMy_Followers();

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }

    }

    public void Print_Followings(MouseEvent mouseEvent) {

        Text.setText("");
        List.getItems().clear();

        ArrayList<User> users = user_selected.getMy_Following();

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }

    }
    
}