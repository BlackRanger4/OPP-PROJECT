package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstMenu implements Initializable {


    public AnchorPane Anchorpane;
    public javafx.scene.control.Button Button;
    public javafx.scene.control.Button Button1;
    public javafx.scene.control.Button Button2;
    public javafx.scene.control.Button Button3;
    public javafx.scene.control.Button Button4;
    public javafx.scene.control.Button Button5;
    public javafx.scene.control.Label Label;
    public javafx.scene.control.Button Button6;
    public javafx.scene.control.Button Button7;
    public javafx.scene.control.Button Button8;
    public javafx.scene.control.Button Button9;
    public javafx.scene.control.Button Button10;
    public javafx.scene.control.Button Button11;
    public javafx.scene.control.Button Button12;
    public ListView<User> usersarr;
    public ListView<Comment> comments;
    private LoginToAccount loginToAccount;
    private DataBase dataBase ;
    private User user ;

    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;


    //////ok//////
    public void Home(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Home home = fxmlLoader.getController();
        home.home(stage,scene,this,dataBase,user,Dark_Mod);
        stage.setScene(scene);

    }

    //////nk//////
    public void Chats(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Chats.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Chatscont Chatscont = fxmlLoader.getController();
        Chatscont.Chatscont(dataBase,user,this,scene,stage,Dark_Mod);
        stage.setScene(scene);
    }

    //////ok//////
    public void Search(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        Search search = fxmlLoader.getController();
        search.search(stage,scene,this,user,dataBase,Dark_Mod);
        stage.setScene(scene);

    }

    //////ok//////
    public void Recommends(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Recommend_User.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        RecommendUser recommendUser = fxmlLoader.getController();
        recommendUser.recommenduser(this,user,dataBase,Dark_Mod);
        stage.setScene(scene);

    }

    //////ok//////
    public void Settings(MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SettingMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900 ,600);
        SettingMenu settingMenu = fxmlLoader.getController();
        settingMenu.settingmenu(this,user,dataBase,Dark_Mod);
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
    public void Back(boolean Dark_Mod){
        this.Dark_Mod = Dark_Mod;
        if (Dark_Mod) {

            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
            Button1.setStyle("-fx-background-color: #6F2232;");
            Button1.setTextFill(Paint.valueOf("WHITE"));
            Button2.setStyle("-fx-background-color: #6F2232;");
            Button2.setTextFill(Paint.valueOf("WHITE"));
            Button3.setStyle("-fx-background-color: #6F2232;");
            Button3.setTextFill(Paint.valueOf("WHITE"));
            Button4.setStyle("-fx-background-color: #6F2232;");
            Button4.setTextFill(Paint.valueOf("WHITE"));
            Button5.setStyle("-fx-background-color: #6F2232;");
            Button5.setTextFill(Paint.valueOf("WHITE"));
            Button6.setStyle("-fx-background-color: #6F2232;");
            Button6.setTextFill(Paint.valueOf("WHITE"));
            Button7.setStyle("-fx-background-color: #6F2232;");
            Button7.setTextFill(Paint.valueOf("WHITE"));
            Button8.setStyle("-fx-background-color: #6F2232;");
            Button8.setTextFill(Paint.valueOf("WHITE"));
            Button9.setStyle("-fx-background-color: #6F2232;");
            Button9.setTextFill(Paint.valueOf("WHITE"));
            Button10.setStyle("-fx-background-color: #6F2232;");
            Button10.setTextFill(Paint.valueOf("WHITE"));
            Button11.setStyle("-fx-background-color: #6F2232;");
            Button11.setTextFill(Paint.valueOf("WHITE"));
            Button12.setStyle("-fx-background-color: #6F2232;");
            Button12.setTextFill(Paint.valueOf("WHITE"));
            Label.setTextFill(Paint.valueOf("#950740"));
            Follow_unFollow.setStyle("-fx-background-color: #6F2232;");
            Follow_unFollow.setTextFill(Paint.valueOf("WHITE"));
            Create_time_of_ads.setTextFill(Paint.valueOf("#950740"));
            Creater_name_of_ads.setTextFill(Paint.valueOf("#950740"));
            Likes_of_ads.setTextFill(Paint.valueOf("#950740"));
            Views_of_ads.setTextFill(Paint.valueOf("#950740"));
            Text_of_ads.setTextFill(Paint.valueOf("#950740"));
            TextField_of_ads.setStyle("-fx-background-color: #E7717D;");
            usersarr.setStyle("-fx-background-color: #E7717D;");
            comments.setStyle("-fx-background-color: #E7717D;");
        }
        else {

            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            Button1.setStyle("-fx-background-color: #EDC7B7;");
            Button1.setTextFill(Paint.valueOf("#AC3B61"));
            Button2.setStyle("-fx-background-color: #EDC7B7;");
            Button2.setTextFill(Paint.valueOf("#AC3B61"));
            Button3.setStyle("-fx-background-color:#EDC7B7;");
            Button3.setTextFill(Paint.valueOf("#AC3B61"));
            Button4.setStyle("-fx-background-color: #EDC7B7;");
            Button4.setTextFill(Paint.valueOf("#AC3B61"));
            Button5.setStyle("-fx-background-color: #EDC7B7;");
            Button5.setTextFill(Paint.valueOf("#AC3B61"));
            Button6.setStyle("-fx-background-color:#EDC7B7;");
            Button6.setTextFill(Paint.valueOf("#AC3B61"));
            Button7.setStyle("-fx-background-color: #EDC7B7;");
            Button7.setTextFill(Paint.valueOf("#AC3B61"));
            Button8.setStyle("-fx-background-color: #EDC7B7;");
            Button8.setTextFill(Paint.valueOf("#AC3B61"));
            Button9.setStyle("-fx-background-color: #EDC7B7;");
            Button9.setTextFill(Paint.valueOf("#AC3B61"));
            Button10.setStyle("-fx-background-color: #EDC7B7;");
            Button10.setTextFill(Paint.valueOf("#AC3B61"));
            Button11.setStyle("-fx-background-color: #EDC7B7;");
            Button11.setTextFill(Paint.valueOf("#AC3B61"));
            Button12.setStyle("-fx-background-color: #EDC7B7;");
            Button12.setTextFill(Paint.valueOf("#AC3B61"));
            Label.setTextFill(Paint.valueOf("#AC3B61"));
            Follow_unFollow.setStyle("-fx-background-color: #EDC7B7;");
            Follow_unFollow.setTextFill(Paint.valueOf("#AC3B61"));
            Create_time_of_ads.setTextFill(Paint.valueOf("#AC3B61"));
            Creater_name_of_ads.setTextFill(Paint.valueOf("#AC3B61"));
            Likes_of_ads.setTextFill(Paint.valueOf("#AC3B61"));
            Views_of_ads.setTextFill(Paint.valueOf("#AC3B61"));
            Text_of_ads.setTextFill(Paint.valueOf("#AC3B61"));
            TextField_of_ads.setStyle("-fx-background-color: #C38D9E;");
            usersarr.setStyle("-fx-background-color: #C38D9E;");
            comments.setStyle("-fx-background-color: #C38D9E;");

        }
        stage.setScene(scene);
    }

    //////ok//////
    public void firstmenu(Stage stage,Scene scene,LoginToAccount loginToAccount,DataBase dataBase ,User user , boolean Dark_Mod){

        this.loginToAccount =loginToAccount;
        this.dataBase = dataBase;
        this.scene =scene;
        this.user = user;
        this.stage = stage;

        this.Dark_Mod = Dark_Mod;
        Back(Dark_Mod);
        ads_recomment();
        Upload_ads();
    }
    public void ads_recomment(){

        ArrayList<Post> posts = get_B_post();

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

        ArrayList<User> users = get_B_liked_post_user(posts);

        Size1 = posts.size();
        int[] scores = new int[Size1] ;

        for (int i =0 ; i< Size1 ; i++){
            scores[i] = 0 ;
            for (User value : users) {
                if (value.Is_B_Post_liked(posts.get(i))) {
                    scores[i]++;
                }
            }
        }
        quickSort(scores ,0 ,Size1-1, posts);
        this.posts =posts;
        post_Num = 0;
    }
    public ArrayList<Post> get_B_post(){

        ArrayList<Post> posts = new ArrayList<>();
        ArrayList<Post> B_post_liked = user.getMy_B_Posts_like();

        for (Post post : B_post_liked) {
            ArrayList<User> users = post.getLikers();
            users.remove(this.user);
            for (User user : users) {
                ArrayList<Post> temp = user.getMy_B_Posts_like();
                for (Post post1 : temp){
                    if (!posts.contains(post1)){
                        posts.add(post1);
                    }
                }
            }
        }

        return posts;
    }
    public ArrayList<User> get_B_liked_post_user(ArrayList<Post> posts){

        ArrayList<User> users = new ArrayList<>();

        for (Post post :posts){
            ArrayList<User> users1 = post.getLikers();
            for (User user :users1){
                if (!users.contains(user)){
                    users.add(user);
                }
            }
        }

        users.remove(this.user);
        return users;
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
            usersarr.getItems().clear();
            comments.getItems().clear();

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
            usersarr.getItems().clear();
            comments.getItems().clear();
            ArrayList<User> users = post.getLikers();
            usersarr.getItems().clear();
            usersarr.getItems().addAll(users);
            comments.setVisible(false);
            usersarr.setVisible(true);
        }catch (Exception e){}
    }

    public void See_Viewrs_of_ads(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_Num);
            usersarr.getItems().clear();
            comments.getItems().clear();
            ArrayList<User> users = post.getViwer();
            usersarr.getItems().clear();
            usersarr.getItems().addAll(users);
            comments.setVisible(false);
            usersarr.setVisible(true);
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
            ArrayList<Comment> comments = post.getComments();
            this.comments.getItems().clear();
            this.comments.getItems().addAll(comments);
            this.comments.setVisible(true);
            this.usersarr.setVisible(false);
            this.comments.setVisible(true);
            usersarr.setVisible(false);
        }catch (Exception e){}
    }
    public void See_Comments_of_ads() {

        try {
            Post post = posts.get(post_Num);
            ArrayList<Comment> comments = post.getComments();
            this.comments.getItems().clear();
            this.comments.getItems().addAll(comments);
            this.comments.setVisible(true);
            this.usersarr.setVisible(false);
            this.comments.setVisible(true);
            usersarr.setVisible(false);
        }catch (Exception e){}
    }

    public void Follow_of_ads_creater(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_Num);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usersarr.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new usersshow();
            }
        });

        comments.setCellFactory(new Callback<ListView<Comment>, ListCell<Comment>>() {
            @Override
            public ListCell<Comment> call(ListView<Comment> commentListView) {
                return new showcomments();
            }
        });



    }

    class usersshow extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public usersshow() {
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

    class showcomments extends ListCell<Comment> {

        HBox hBox = new HBox();
        HBox hBox2= new HBox();
        VBox vbox = new VBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        VBox vbox3 = new VBox();
        Circle circle = new Circle(15);
        Label text = new Label();
        Button like = new Button("Like");
        Label Likes = new Label("Likes");
        Label Replies = new Label("reply");
        Pane pane = new Pane();



        public showcomments() {
            super();
            vbox1.getChildren().add(circle);
            vbox2.getChildren().add(text);
            vbox2.setAlignment(Pos.CENTER_LEFT);
            vbox3.getChildren().add(like);
            vbox3.setAlignment(Pos.CENTER_RIGHT);
            hBox.getChildren().addAll(vbox1,vbox2,vbox3);
            hBox2.getChildren().addAll(Replies,pane,Likes);
            HBox.setHgrow(vbox2,Priority.ALWAYS);
            HBox.setHgrow(pane,Priority.SOMETIMES);
            vbox.getChildren().addAll(hBox,hBox2);
            Likes.setUnderline(true);
            Replies.setUnderline(true);
        }


        @Override
        public void updateItem(Comment comment, boolean empty) {

            super.updateItem( comment , empty);

            if (empty || comment == null){
                setGraphic(null);
            }

            else {

                circle.setFill(new ImagePattern(comment.getSender().getProfile_Image()));
                text.setText(comment.getText());

                if (comment.getLiker().contains(user)){
                    like.setVisible(false);
                }
                else {
                    like.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            comment.Add_like(user);
                            like.setVisible(false);
                            reflist();
                        }
                    });
                }

                Likes.setText(comment.getLiker().size() + " Likes");
                Replies.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        comment.Add_reply(TextField_of_ads.getText(),user.getUser_Name());
                        reflist();
                    }
                });

                setGraphic(vbox);
            }
        }
    }

    public void reflist() {
        try {
            comments.getItems().clear();
            usersarr.getItems().clear();
            comments.getItems().addAll(posts.get(post_Num).getComments());
        }catch (Exception ignored){}
    }

}