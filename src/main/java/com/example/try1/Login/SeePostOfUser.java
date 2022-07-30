package com.example.try1.Login;

import com.example.try1.oop.Comment;
import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class SeePostOfUser {

    public ImageView Creater_prof;
    public ImageView Post_image;
    public ListView<String> List;
    public TextField Text;
    public Label Views;
    public Label Creater;
    public Label Likes;
    public Label Create_day;
    public Label Create_time;
    public Label Post_text;
    public Label Error;

    private SearchSelected searchSelected;
    private User user;
    private User user_selected;

    private int post_num ;

    public void seepostofuser(SearchSelected searchSelected,User user,User user_selected){

        this.searchSelected =searchSelected;
        this.user =user;
        this.user_selected =user_selected;
        Creater_prof.setImage(user_selected.getProfile_Image());
        Creater.setText(user_selected.getUser_Name());
        Text.setText("");
        Error.setText("");
        List.getItems().clear();
        post_num = user_selected.getMy_Posts().size()-1;
        user_selected.getMy_Posts().get(post_num).Add_View(user);
        Update_Post_information();

    }

    public void Update_Post_information(){

        Post post = user_selected.getMy_Posts().get(post_num);
        try {
            Post_image.setImage(post.getImage());
        }
        catch (Exception e){}
        List.getItems().clear();
        Text.setText("");
        Views.setText("Views:"+post.getViews());
        Likes.setText("Likes"+post.getLikes());
        Create_day.setText(String.valueOf(post.getCreatTime()));
        Create_time.setText(String.valueOf(post.getCreat_our()));
        Post_text.setText(post.getText());
        Error.setText("");
        post.Add_View(user);

    }

    public void Back(MouseEvent mouseEvent) {
        searchSelected.back();
    }

    public void NEXT(MouseEvent mouseEvent) {

        post_num--;
        if (post_num <= -1){
            post_num =0;
            Error.setText(" its first post user uploaded ");
        }
        else {
            Update_Post_information();
        }
    }

    public void LAST(MouseEvent mouseEvent) {

        post_num++;
        if (post_num >= user_selected.getMy_Posts().size()){
            post_num = user_selected.getMy_Posts().size()-1;
            Error.setText(" its last post user uploaded ");
        }
        else {
            Update_Post_information();
        }
    }

    public void Add_Comment(MouseEvent mouseEvent) {

        if (Text.getText().equals("")){
            Comment comment = new Comment(user ,Text.getText());
            user_selected.getMy_Posts().get(post_num).Add_Comment(comment);
        }
        else {
            Error.setText(" you must enter a message ");
        }
        See_Comments();
    }

    public void LIKE(MouseEvent mouseEvent) {

        user_selected.getMy_Posts().get(post_num).Add_Like(user);
        Text.setText("");
        List.getItems().clear();
        Error.setText("");
        Likes.setText("Likes"+user_selected.getMy_Posts().get(post_num).getLikes());

    }

    public void See_Likers(MouseEvent mouseEvent) {

        ArrayList<User> users = user_selected.getMy_Posts().get(post_num).getLikers();
        Text.setText("");
        List.getItems().clear();
        Error.setText("");

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }

    }

    public void See_Comments(MouseEvent mouseEvent){

        ArrayList<Comment> comments = user_selected.getMy_Posts().get(post_num).getComments();
        Text.setText("");
        List.getItems().clear();
        Error.setText("");

        for (Comment value : comments) {
            List.getItems().add(value.getText());
        }
    }
    public void See_Comments(){

        ArrayList<Comment> comments = user_selected.getMy_Posts().get(post_num).getComments();
        Text.setText("");
        List.getItems().clear();
        Error.setText("");

        for (Comment value : comments) {
            List.getItems().add(value.getText());
        }
    }

    public void See_Viewers(MouseEvent mouseEvent) {

        ArrayList<User> users = user_selected.getMy_Posts().get(post_num).getViwer();
        Text.setText("");
        List.getItems().clear();
        Error.setText("");

        for (User value : users) {
            List.getItems().add(value.getUser_Name());
        }
    }

}