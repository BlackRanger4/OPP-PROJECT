package com.example.try1.Login;

import com.example.try1.oop.Comment;
import com.example.try1.oop.DataBase;
import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.ArrayList;

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
        this.users = user.getMy_Following();
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
    public Button Page_last_button;
    public Button Post_Next_button;
    public Button Create_fuf_button;


    private ArrayList<User> users ;
    private ArrayList<Post> posts ;
    private int post_num;


    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }

    public void Add_Like(MouseEvent mouseEvent) {
        Post post = posts.get(post_num);
        post.Add_Like(user);
        Posr_Likes.setText("Likes:"+post.getLikes());
    }

    public void Add_Comment(MouseEvent mouseEvent) {

        if (!Text_field.getText().equals("")){
            Comment comment = new Comment(user,Text_field.getText());
            Post post = posts.get(post_num);
            post.Add_Comment(comment);
        }
        else {
            Text_field.setText(" enter your message ");
        }
        See_Comments();
    }

    public void See_Likers(MouseEvent mouseEvent) {

        List.getItems().clear();
        ArrayList<User> users = posts.get(post_num).getLikers();

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }
    }

    public void See_Viewers(MouseEvent mouseEvent) {
        List.getItems().clear();
        ArrayList<User> users = posts.get(post_num).getViwer();

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }
    }

    public void See_Comments(MouseEvent mouseEvent) {
        List.getItems().clear();
        ArrayList<Comment> comments = posts.get(post_num).getComments();

        for (Comment value : comments) {
            List.getItems().add(value.getText());
        }
    }
    public void See_Comments() {
        List.getItems().clear();
        ArrayList<Comment> comments = posts.get(post_num).getComments();

        for (Comment value : comments) {
            List.getItems().add(value.getText());
        }
    }

    public void Next_Post(MouseEvent mouseEvent) {

        post_num--;
        if (post_num <= -1){
            post_num =0;
        }

        Post post = posts.get(post_num);

        Text_field.setText("");
        Post_Create_time.setText(post.getText());
        Post_Image.setImage(post.getImage());
        List.getItems().clear();
        Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
        Post_Create_time.setText(post.getCreatTime()+","+post.getCreat_our());
        Post_Creater_Name.setText(post.getCreater().getUser_Name());
        Post_Views.setText("Views:"+(post.getViews()));
        Posr_Likes.setText("Likes"+(post.getLikes()));

    }

    public void Last_Post(MouseEvent mouseEvent) {

        post_num++;
        if (post_num >= posts.size()){
            post_num = posts.size()-1;
        }

        Post post = posts.get(post_num);

        Text_field.setText("");
        Post_Create_time.setText(post.getText());
        Post_Image.setImage(post.getImage());
        List.getItems().clear();
        Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
        Post_Create_time.setText(post.getCreatTime()+","+post.getCreat_our());
        Post_Creater_Name.setText(post.getCreater().getUser_Name());
        Post_Views.setText("Views:"+(post.getViews()));
        Posr_Likes.setText("Likes"+(post.getLikes()));

    }

    public void My_Post(MouseEvent mouseEvent) {

        posts = user.getMy_Posts();
        post_num = posts.size()-1;

        Post post = posts.get(post_num);

        Text_field.setText("");
        Post_Create_time.setText(post.getText());
        Post_Image.setImage(post.getImage());
        List.getItems().clear();
        Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
        Post_Create_time.setText(post.getCreatTime()+","+post.getCreat_our());
        Post_Creater_Name.setText(post.getCreater().getUser_Name());
        Post_Views.setText("Views:"+(post.getViews()));
        Posr_Likes.setText("Likes"+(post.getLikes()));

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
    }
    public void My_Post() {

        posts = user.getMy_Posts();
        post_num = posts.size()-1;

        Post post = posts.get(post_num);

        Text_field.setText("");
        Post_Create_time.setText(post.getText());
        Post_Image.setImage(post.getImage());
        List.getItems().clear();
        Post_Creater_Image.setImage(post.getCreater().getProfile_Image());
        Post_Create_time.setText(post.getCreatTime()+","+post.getCreat_our());
        Post_Creater_Name.setText(post.getCreater().getUser_Name());
        Post_Views.setText("Views:"+(post.getViews()));
        Posr_Likes.setText("Likes"+(post.getLikes()));

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
    }

    public void My_Following_Post(MouseEvent mouseEvent) {
    }

    public void Post_Analyze_or_Nextuser(MouseEvent mouseEvent) {
    }

    public void Page_Analyze_or_Pastuser(MouseEvent mouseEvent) {
    }

    public void CraetePost_or_Follow_UnFollow(MouseEvent mouseEvent) {
    }

}