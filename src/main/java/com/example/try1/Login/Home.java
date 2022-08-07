package com.example.try1.Login;

import com.example.try1.oop.Comment;
import com.example.try1.oop.DataBase;
import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Home implements Serializable {


    public ImageView Page_Image;
    private Boolean Dark_Mod;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;
    private DataBase dataBase;
    private User user;

    boolean Me_Or_Myfollowing = true;

    public void home(Stage stage ,Scene scene,FirstMenu firstMenu,DataBase dataBase,User user,boolean Dark_Mod){

        this.stage =stage;
        this.scene =scene;
        this.firstMenu =firstMenu;
        this.dataBase =dataBase;
        this.user =user;
        this.users = user.getMy_Following();
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
            Page_last_button.setStyle("-fx-background-color: #6F2232;");
            Page_last_button.setTextFill(Paint.valueOf("WHITE"));
            Post_Next_button.setStyle("-fx-background-color: #6F2232;");
            Post_Next_button.setTextFill(Paint.valueOf("WHITE"));
            Create_fuf_button.setStyle("-fx-background-color: #6F2232;");
            Create_fuf_button.setTextFill(Paint.valueOf("WHITE"));
            Remove_post.setStyle("-fx-background-color: #6F2232;");
            Remove_post.setTextFill(Paint.valueOf("WHITE"));
            Followers_see_button.setStyle("-fx-background-color: #6F2232;");
            Followers_see_button.setTextFill(Paint.valueOf("WHITE"));
            Followings_see_button.setStyle("-fx-background-color: #6F2232;");
            Followings_see_button.setTextFill(Paint.valueOf("WHITE"));
            Text_field.setStyle("-fx-background-color: #E7717D;");
            List.setStyle("-fx-background-color: #E7717D;");
            Post_text.setTextFill(Paint.valueOf("#950740"));
            Post_Creater_Name.setTextFill(Paint.valueOf("#950740"));
            Post_Create_time.setTextFill(Paint.valueOf("#950740"));
            Post_Views.setTextFill(Paint.valueOf("#950740"));
            Posr_Likes.setTextFill(Paint.valueOf("#950740"));
            Followers_num.setTextFill(Paint.valueOf("#950740"));
            Followings_num.setTextFill(Paint.valueOf("#950740"));
            owner_name.setTextFill(Paint.valueOf("#950740"));
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            Button1.setStyle("-fx-background-color: #EDC7B7;");
            Button1.setTextFill(Paint.valueOf("#AC3B61"));
            Button2.setStyle("-fx-background-color: #EDC7B7;");
            Button2.setTextFill(Paint.valueOf("#AC3B61"));
            Button3.setStyle("-fx-background-color: #EDC7B7;");
            Button3.setTextFill(Paint.valueOf("#AC3B61"));
            Button4.setStyle("-fx-background-color: #EDC7B7;");
            Button4.setTextFill(Paint.valueOf("#AC3B61"));
            Button5.setStyle("-fx-background-color: #EDC7B7;");
            Button5.setTextFill(Paint.valueOf("#AC3B61"));
            Button6.setStyle("-fx-background-color: #EDC7B7;");
            Button6.setTextFill(Paint.valueOf("#AC3B61"));
            Button7.setStyle("-fx-background-color: #EDC7B7;");
            Button7.setTextFill(Paint.valueOf("#AC3B61"));
            Button8.setStyle("-fx-background-color: #EDC7B7;");
            Button8.setTextFill(Paint.valueOf("#AC3B61"));
            Button9.setStyle("-fx-background-color: #EDC7B7;");
            Button9.setTextFill(Paint.valueOf("#AC3B61"));
            Page_last_button.setStyle("-fx-background-color: #EDC7B7;");
            Page_last_button.setTextFill(Paint.valueOf("#AC3B61"));
            Post_Next_button.setStyle("-fx-background-color: #EDC7B7;");
            Post_Next_button.setTextFill(Paint.valueOf("#AC3B61"));
            Create_fuf_button.setStyle("-fx-background-color: #EDC7B7;");
            Create_fuf_button.setTextFill(Paint.valueOf("#AC3B61"));
            Remove_post.setStyle("-fx-background-color: #EDC7B7;");
            Remove_post.setTextFill(Paint.valueOf("#AC3B61"));
            Followers_see_button.setStyle("-fx-background-color: #EDC7B7;");
            Followers_see_button.setTextFill(Paint.valueOf("#AC3B61"));
            Followings_see_button.setStyle("-fx-background-color: #EDC7B7;");
            Followings_see_button.setTextFill(Paint.valueOf("#AC3B61"));
            Text_field.setStyle("-fx-background-color: #E7717D;");
            List.setStyle("-fx-background-color: #E7717D;");
            Post_text.setTextFill(Paint.valueOf("#AC3B61"));
            Post_Creater_Name.setTextFill(Paint.valueOf("#AC3B61"));
            Post_Create_time.setTextFill(Paint.valueOf("#AC3B61"));
            Post_Views.setTextFill(Paint.valueOf("#AC3B61"));
            Posr_Likes.setTextFill(Paint.valueOf("#AC3B61"));
            Followers_num.setTextFill(Paint.valueOf("#AC3B61"));
            Followings_num.setTextFill(Paint.valueOf("#AC3B61"));
            owner_name.setTextFill(Paint.valueOf("#AC3B61"));
        }
        My_Post();

    }

    public AnchorPane Anchorpane;
    public javafx.scene.control.Button Button;
    public javafx.scene.control.Button Button1;
    public javafx.scene.control.Button Button2;
    public javafx.scene.control.Button Button3;
    public javafx.scene.control.Button Button4;
    public javafx.scene.control.Button Button5;
    public javafx.scene.control.Button Button6;
    public javafx.scene.control.Button Button7;
    public javafx.scene.control.Button Button8;
    public javafx.scene.control.Button Button9;
    public TextField Text_field;
    public Label Post_text;
    public ImageView Post_Image;
    public ListView<String> List;
    public ImageView Post_Creater_Image;
    public Label Post_Create_time;
    public Label Post_Creater_Name;
    public Label Post_Views;
    public Label Posr_Likes;
    public Button Page_last_button;
    public Button Post_Next_button;
    public Button Create_fuf_button;
    public Button Remove_post;
    public Label Followers_num;
    public Label Followings_num;
    public Button Followers_see_button;
    public Button Followings_see_button;
    public Label owner_name;

    private ArrayList<User> users ;
    private int user_num =0;
    private ArrayList<Post> posts ;
    private int post_num;


    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }
    public void back(){
        stage.setScene(scene);
        My_Post();
    }

    public void Add_Like(MouseEvent mouseEvent) {

        try {
            Post post = posts.get(post_num);
            post.Add_Like(user);
            Posr_Likes.setText("Likes:" + post.getLikes());
        }catch (Exception e){}
    }

    public void Add_Comment(MouseEvent mouseEvent) {

        if (!Text_field.getText().equals("")){
            try {
                Comment comment = new Comment(user, Text_field.getText());
                Post post = posts.get(post_num);
                post.Add_Comment(comment);
            }catch (Exception e){}
        }
        else {
            Text_field.setText(" enter your message ");
        }
        See_Comments();
    }

    public void See_Likers(MouseEvent mouseEvent) {

        try {
            List.getItems().clear();
            ArrayList<User> users = posts.get(post_num).getLikers();

            for (User value : users) {
                List.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

    public void See_Viewers(MouseEvent mouseEvent) {

        try {
            List.getItems().clear();
            ArrayList<User> users = posts.get(post_num).getViwer();

            for (User value : users) {
                List.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

    public void See_Comments(MouseEvent mouseEvent) {

        try {
            List.getItems().clear();
            ArrayList<Comment> comments = posts.get(post_num).getComments();

            for (Comment value : comments) {
                List.getItems().add(value.comment_info()+"\n"+value.getText());
            }
        }catch (Exception e){}
    }
    public void See_Comments() {
        try {
            List.getItems().clear();
            ArrayList<Comment> comments = posts.get(post_num).getComments();

            for (Comment value : comments) {
                List.getItems().add(value.comment_info()+"\n"+value.getText());
            }
        }catch (Exception e){}
    }

    public void Next_Post(MouseEvent mouseEvent) {

        Clear();
        post_num--;
        if (post_num <= -1){
            post_num =0;
        }

        try {
            Post post = posts.get(post_num);
            post.Add_View(user);

            Text_field.setText("");
            Post_text.setText(post.getText());
            try {
                Post_Image.setImage(post.getImage());
            }catch (Exception e){}
            List.getItems().clear();
            try {
                Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
            Post_Creater_Name.setText(post.getCreater().getUser_Name());
            Post_Views.setText("Views:" + (post.getViews()));
            Posr_Likes.setText("Likes:" + (post.getLikes()));
        }
        catch (Exception e){}
    }
    public void Next_Post() {

        Clear();
        post_num--;
        if (post_num <= -1){
            post_num =0;
        }

        try {
            Post post = posts.get(post_num);
            post.Add_View(user);

            Text_field.setText("");
            Post_text.setText(post.getText());
            try {
                Post_Image.setImage(post.getImage());
            }catch (Exception e){}
            List.getItems().clear();
            try {
                Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
            Post_Creater_Name.setText(post.getCreater().getUser_Name());
            Post_Views.setText("Views:" + (post.getViews()));
            Posr_Likes.setText("Likes:" + (post.getLikes()));
        }
        catch (Exception e){}
    }

    public void Last_Post(MouseEvent mouseEvent) {

        Clear();
        post_num++;
        if (post_num >= posts.size()){
            post_num = posts.size()-1;
        }

        try {
            Post post = posts.get(post_num);
            post.Add_View(user);

            Text_field.setText("");
            Post_text.setText(post.getText());
            try {
                Post_Image.setImage(post.getImage());
            }catch (Exception e){}
            List.getItems().clear();
            try {
                Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
            Post_Creater_Name.setText(post.getCreater().getUser_Name());
            Post_Views.setText("Views:" + (post.getViews()));
            Posr_Likes.setText("Likes:" + (post.getLikes()));
        }
        catch (Exception e){}
    }


    public void My_Post(MouseEvent mouseEvent) {

        Clear();
        owner_name.setText(user.getUser_Name());
        Followings_num.setText("Followings:"+user.getMy_Followings_num());
        Followers_num.setText("Followers:"+user.getMy_Followers_num());
        posts = user.getMy_Posts();
        post_num = posts.size()-1;
        Me_Or_Myfollowing = true;
        try {
            Post post = posts.get(post_num);
            Text_field.setText("");
            Post_text.setText(post.getText());
            try {
                Post_Image.setImage(post.getImage());
                Page_Image.setImage(user.getProfile_Image());
            }catch (Exception e){}
            List.getItems().clear();
            try {
                Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
            Post_Creater_Name.setText(post.getCreater().getUser_Name());
            Post_Views.setText("Views:" + (post.getViews()));
            Posr_Likes.setText("Likes:" + (post.getLikes()));
            Followers_num.setText("Followers:"+user.getMy_Followers_num());
            Followings_num.setText("Followings:"+user.getMy_Followings_num());
        }
        catch (Exception e){}
        if (user.getBusiness()){
            Page_last_button.setText("Page analyze");
            Post_Next_button.setText("Post analyze");
            Create_fuf_button.setText("Create Post");
        }
        else {
            Page_last_button.setText("------------");
            Post_Next_button.setText("------------");
            Create_fuf_button.setText("Create Post");
        }
        Remove_post.setText("Remove");
    }
    public void My_Post() {

        Clear();
        posts = user.getMy_Posts();
        owner_name.setText(user.getUser_Name());
        Followings_num.setText("Followings:"+user.getMy_Followings_num());
        Followers_num.setText("Followers:"+user.getMy_Followers_num());
        post_num = posts.size()-1;
        Me_Or_Myfollowing = true;

        try {
            Post post = posts.get(post_num);
            Text_field.setText("");
            Post_text.setText(post.getText());
            try {
                Page_Image.setImage(user.getProfile_Image());
                Post_Image.setImage(post.getImage());
            }catch (Exception e){}
            List.getItems().clear();
            try {
                Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
            }catch (Exception e){}
            Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
            Post_Creater_Name.setText(post.getCreater().getUser_Name());
            Post_Views.setText("Views:" + (post.getViews()));
            Posr_Likes.setText("Likes:" + (post.getLikes()));
            Followers_num.setText("Followers:"+user.getMy_Followers_num());
            Followings_num.setText("Followings:"+user.getMy_Followings_num());

        }
        catch (Exception e){}
        if (user.getBusiness()){
            Page_last_button.setText("Page analyze");
            Post_Next_button.setText("Post analyze");
            Create_fuf_button.setText("Create Post");
        }
        else {
            Page_last_button.setText("------------");
            Post_Next_button.setText("------------");
            Create_fuf_button.setText("Create Post");
        }
        Remove_post.setText("Remove");
    }


    public void My_Following_Post(MouseEvent mouseEvent) {

        Clear();
        try {
            if (users.get(user_num).getBusiness()) {
                users.get(user_num).add_view_page();
            }
            posts = users.get(user_num).getMy_Posts();
            owner_name.setText(users.get(user_num).getUser_Name());
            Followings_num.setText("Followings:" + users.get(user_num).getMy_Followings_num());
            Followers_num.setText("Followers:" + users.get(user_num).getMy_Followers_num());
            post_num = posts.size() - 1;
            Me_Or_Myfollowing = false;
            try {
                Post post = posts.get(post_num);
                post.Add_View(user);
                Text_field.setText("");
                Post_text.setText(post.getText());
                try {
                    Post_Image.setImage(post.getImage());
                    Page_Image.setImage(users.get(user_num).getProfile_Image());
                } catch (Exception e) {
                }
                List.getItems().clear();
                try {
                    Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
                } catch (Exception e) {
                }
                Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
                Post_Creater_Name.setText(post.getCreater().getUser_Name());
                Post_Views.setText("Views:" + (post.getViews()));
                Posr_Likes.setText("Likes:" + (post.getLikes()));
                Followers_num.setText("Followers:" + users.get(user_num).getMy_Followers_num());
                Followings_num.setText("Followings:" + users.get(user_num).getMy_Followings_num());
            } catch (Exception e) {}

            if (users.get(user_num).Is_my_followers(user)) {
                Create_fuf_button.setText("unFollow");
            }
            else {
                Create_fuf_button.setText("Follow");
            }

        }catch (Exception e){
            owner_name.setText("you are not following a user");
        }
        Page_last_button.setText("Last user");
        Post_Next_button.setText("Next user");
        Remove_post.setText("---------");

    }
    public void My_Following_Post() {

        Clear();
        try {
            if (users.get(user_num).getBusiness()) {
                users.get(user_num).add_view_page();
            }
            posts = users.get(user_num).getMy_Posts();
            owner_name.setText(users.get(user_num).getUser_Name());
            Followings_num.setText("Followings:" + users.get(user_num).getMy_Followings_num());
            Followers_num.setText("Followers:" + users.get(user_num).getMy_Followers_num());
            post_num = posts.size() - 1;
            Me_Or_Myfollowing = false;
            try {
                Post post = posts.get(post_num);
                post.Add_View(user);
                Text_field.setText("");
                Post_text.setText(post.getText());
                try {
                    Post_Image.setImage(post.getImage());
                    Page_Image.setImage(users.get(user_num).getProfile_Image());
                } catch (Exception e) {
                }
                List.getItems().clear();
                try {
                    Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
                } catch (Exception e) {
                }
                Post_Create_time.setText(post.getCreatTime() + "," + post.getCreat_our());
                Post_Creater_Name.setText(post.getCreater().getUser_Name());
                Post_Views.setText("Views:" + (post.getViews()));
                Posr_Likes.setText("Likes:" + (post.getLikes()));
                Followers_num.setText("Followers:" + users.get(user_num).getMy_Followers_num());
                Followings_num.setText("Followings:" + users.get(user_num).getMy_Followings_num());
            } catch (Exception e) {}
            if (users.get(user_num).Is_my_followers(user)) {
                Create_fuf_button.setText("unFollow");
            }
            else {
                Create_fuf_button.setText("Follow");
            }
        }catch (Exception e){
            owner_name.setText("you are not following a user");
        }
        Page_last_button.setText("Last user");
        Post_Next_button.setText("Next user");
        Remove_post.setText("---------");

    }

    public void Clear(){
        Text_field.setText("");
        Post_text.setText("");
        Post_Image.setImage(null);
        List.getItems().clear();
        Post_Creater_Image.setImage(null);
        Post_Create_time.setText("");
        Post_Creater_Name.setText("");
        Post_Views.setText("");
        Posr_Likes.setText("");
    }

    public void Post_Analyze_or_Nextuser(MouseEvent mouseEvent) throws IOException {

        if (Post_Next_button.getText().equals("Post analyze")){

            try {
                Post post = posts.get(post_num);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PostAnalyze.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 600);
                PostAnalyze postAnalyze = fxmlLoader.getController();
                postAnalyze.postanalyze(this, post,Dark_Mod);
                stage.setScene(scene);
            }catch (Exception e){}
        }
        else if (Post_Next_button.getText().equals("Next user")){
            user_num++;
            if (user_num >= users.size()){
                user_num = users.size()-1;
            }
            My_Following_Post();
        }
    }

    public void Page_Analyze_or_Pastuser(MouseEvent mouseEvent) throws IOException {

        if (Page_last_button.getText().equals("Page analyze")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PageAnalyze.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),900,600);
            PageAnalyze pageAnalyze = fxmlLoader.getController();
            pageAnalyze.pageanalyze(this,user,Dark_Mod);
            stage.setScene(scene);

        }
        else if (Page_last_button.getText().equals("Next user")){
            user_num--;
            if (user_num <= -1){
                user_num = 0;
            }
            My_Following_Post();
        }
    }

    public void CraetePost_or_Follow_UnFollow(MouseEvent mouseEvent) throws IOException {

        if (Create_fuf_button.getText().equals("Create Post")){

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreatePost.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),900,600);
            CreatePost createPost = fxmlLoader.getController();
            createPost.createpost(this,user,Dark_Mod);
            stage.setScene(scene);

        }
        else if (Create_fuf_button.getText().equals("Follow") || Create_fuf_button.getText().equals("unFollow")){
           try {
               user.unfollowing_following_me(users.get(user_num));
               if (users.get(user_num).Is_my_followers(user)){
                   Create_fuf_button.setText("unFollow");
               }
               else {
                   Create_fuf_button.setText("Follow");
               }
           }
           catch (Exception e){}
        }

    }

    public void Remove_post(MouseEvent mouseEvent) {

        if (Remove_post.getText().equals("Remove")){
            try {
                user.Remove_post(posts.get(post_num));
                Text_field.setText("Post Removed");
                Next_Post();
            }
            catch (Exception e){}
        }
    }

    public void Follower_See(MouseEvent mouseEvent) {

        if (Me_Or_Myfollowing){
            try {
                List.getItems().clear();
                ArrayList<User> users = user.getMy_Followers();
                for (User user:users){
                    List.getItems().add(user.getUser_Name());
                }
            }catch (Exception e){}
        }
        else {
            try {
                List.getItems().clear();
                ArrayList<User> users = this.users.get(user_num).getMy_Followers();
                for (User user:users){
                    List.getItems().add(user.getUser_Name());
                }
            }catch (Exception e){}
        }
    }

    public void Following_See(MouseEvent mouseEvent) {

        if (Me_Or_Myfollowing){
            try {
                List.getItems().clear();
                ArrayList<User> users = user.getMy_Following();
                for (User user:users){
                    List.getItems().add(user.getUser_Name());
                }
            }catch (Exception e){}
        }
        else {
            try {
                List.getItems().clear();
                ArrayList<User> users = this.users.get(user_num).getMy_Following();
                for (User user:users){
                    List.getItems().add(user.getUser_Name());
                }
            }catch (Exception e){}
        }
    }

}