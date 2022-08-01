package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class FirstMenu implements Serializable {


    private LoginToAccount loginToAccount;
    private DataBase dataBase ;
    private User user ;

    private static Stage stage;
    private Scene scene;


    //////nk//////
    public void Home(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Home home = fxmlLoader.getController();
        home.home(stage,scene,this,dataBase,user);
        stage.setScene(scene);

    }

    //////nk//////
    public void Chats(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Chats.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Chatscont Chatscont = fxmlLoader.getController();
        Chatscont.Chatscont(dataBase,user,this,scene,stage);
        stage.setScene(scene);
    }

    //////ok//////
    public void Search(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Search search = fxmlLoader.getController();
        search.search(stage,scene,this,user,dataBase);
        stage.setScene(scene);

    }

    //////ok//////
    public void Recommends(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Recommend_User.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        RecommendUser recommendUser = fxmlLoader.getController();
        recommendUser.recommenduser(this,user,dataBase);
        stage.setScene(scene);

    }

    //////ok//////
    public void Settings(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SettingMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        SettingMenu settingMenu = fxmlLoader.getController();
        settingMenu.settingmenu(this,user,dataBase);
        stage.setScene(scene);

    }

    //////ok//////
    public void Exit(MouseEvent mouseEvent) {
        loginToAccount.back();
    }

    //////ok//////
    public void Back(){
        stage.setScene(scene);
    }

    //////ok//////
    public void firstmenu(Stage stage,Scene scene,LoginToAccount loginToAccount,DataBase dataBase ,User user){

        this.loginToAccount =loginToAccount;
        this.dataBase = dataBase;
        this.scene =scene;
        this.user = user;
        this.stage = stage;

        ads_recomment();
        Upload_ads();
    }
    public void ads_recomment(){

        ArrayList<User> following_user = user.getMy_Following();

        ArrayList<Post> posts = new ArrayList<>();

        for (User item : following_user) {
            posts.addAll(item.getMy_B_Posts_like());
        }

        int Size1 = posts.size();

        for (int i=0 ; i < Size1 ;){
            if (user.Is_B_Post_liked(posts.get(i))){
                posts.remove(i);
                Size1--;
            }
            else {
                i++;
            }
        }

        Size1 = posts.size();
        int[] scores = new int[Size1] ;

        for (int i =0 ; i< Size1 ; i++){
            scores[i] = 0 ;
            for (User value : following_user) {

                if (value.Is_B_Post_liked(posts.get(i))) {

                    scores[i]++;
                }
            }
        }
        quickSort(scores ,0 ,Size1-1, posts);
        this.posts =posts;
        post_Num = 0;
    }
    public void swap(int[] arr, int i, int j,ArrayList<Post> b_posts) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Post b_post = b_posts.get(i);
        b_posts.set(i , b_posts.get(j));
        b_posts.set(j , b_post);

    }
    public int partition(int[] arr, int low, int high,ArrayList<Post> b_posts) {

        int pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {


            if (arr[j] > pivot)
            {
                i++;
                swap(arr, i, j,b_posts);
            }
        }
        swap(arr, i + 1, high,b_posts);
        return (i + 1);
    }
    public void quickSort(int[] arr, int low, int high,ArrayList<Post> b_posts) {
        if (low < high)
        {
            int pi = partition(arr, low, high,b_posts);
            quickSort(arr, low, pi - 1,b_posts);
            quickSort(arr, pi + 1, high,b_posts);
        }
    }


    private ArrayList<Post> posts ;
    public ImageView Prof_image_of_ads;
    public Label Creater_name_of_ads;
    public Label Create_time_of_ads;
    public Label Likes_of_ads;
    public Label Views_of_ads;
    public Label Text_of_ads;
    public ImageView Image_of_ads;
    public ListView<String> List_of_ads;
    public TextField TextField_of_ads;
    public Button Follow_unFollow;
    private int post_Num;


    public void Upload_ads(){

        try {
            Post post = posts.get(post_Num);
            post.Add_View(user);

            try {
                Prof_image_of_ads.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Creater_name_of_ads.setText(post.getCreater().getUser_Name());
            Create_time_of_ads.setText(post.getCreatTime() + "," + post.getCreat_our());
            Likes_of_ads.setText("Likes:" + post.getLikes());
            Views_of_ads.setText("Views:" + post.getViews());
            Text_of_ads.setText(post.getText());
            try {
                Image_of_ads.setImage(post.getImage());
            }catch (Exception e){}
            List_of_ads.getItems().clear();

            if (post.getCreater().Is_my_followers(user)) {
                Follow_unFollow.setText("Unfollow");
            } else {
                Follow_unFollow.setText("Follow");
            }
        }catch (Exception e){}
    }

    public void Like_ads(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_Num);
            post.Add_Like(user);
            Likes_of_ads.setText("Likes:" + post.getLikes());
        }catch (Exception e){}
    }

    public void See_Likers_of_ads(MouseEvent mouseEvent) {
        try {
            Post post = posts.get(post_Num);
            List_of_ads.getItems().clear();
            ArrayList<User> users = post.getLikers();
            for (User value : users) {
                List_of_ads.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

    public void See_Viewrs_of_ads(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_Num);
            List_of_ads.getItems().clear();
            ArrayList<User> users = post.getViwer();
            for (User value : users) {
                List_of_ads.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

    public void Add_Comments_of_ads(MouseEvent mouseEvent) {

        try {
            if (!TextField_of_ads.getText().equals("")) {
                Comment comment = new Comment(user, TextField_of_ads.getText());
                Post post = posts.get(post_Num);
                post.Add_Comment(comment);
                See_Comments_of_ads();
            }
        }catch (Exception e){}
    }

    public void See_Comments_of_ads(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_Num);
            List_of_ads.getItems().clear();
            ArrayList<Comment> comments = post.getComments();
            for (Comment value : comments) {
                List_of_ads.getItems().add(value.getText());
            }
        }catch (Exception e){}
    }
    public void See_Comments_of_ads() {

        try {
            Post post = posts.get(post_Num);
            List_of_ads.getItems().clear();
            ArrayList<Comment> comments = post.getComments();
            for (Comment value : comments) {
                List_of_ads.getItems().add(value.getText());
            }
        }catch (Exception e){}
    }

    public void Follow_of_ads_creater(MouseEvent mouseEvent) {

        Post post = posts.get(post_Num);
        try {
            this.user.unfollowing_following_me(post.getCreater());
            if (post.getCreater().Is_my_followers(user)) {
                Follow_unFollow.setText("Unfollow");
            } else {
                Follow_unFollow.setText("Follow");
            }
        }catch (Exception e){}
    }

    public void Last_ads(MouseEvent mouseEvent) {

        post_Num--;
        if (post_Num <= -1){
            post_Num =0;
            TextField_of_ads.setText("its first post");
        }
        Upload_ads();
    }

    public void Next_ads(MouseEvent mouseEvent) {

        post_Num++;
        if (post_Num >= posts.size()){
            post_Num = posts.size()-1;
            TextField_of_ads.setText("its last post");
        }
        Upload_ads();
    }
    

}