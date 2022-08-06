package com.example.try1.Login;

import com.example.try1.oop.Comment;
import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

import java.io.Serializable;
import java.util.ArrayList;

public class SeePostOfUser implements Serializable {


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
    public AnchorPane Anchorpane;
    public Button Button;
    public javafx.scene.control.Button Button1;
    public javafx.scene.control.Button Button2;
    public javafx.scene.control.Button Button3;
    public javafx.scene.control.Button Button4;
    public javafx.scene.control.Button Button5;
    public javafx.scene.control.Button Button6;
    public javafx.scene.control.Button Button7;

    private SearchSelected searchSelected;
    private User user;
    private User user_selected;
    private int post_num ;


    public void seepostofuser(SearchSelected searchSelected,User user,User user_selected , boolean Dark_Mod){

        try {
            this.searchSelected = searchSelected;
            this.user = user;
            this.user_selected = user_selected;
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
                List.setStyle("-fx-background-color: #E7717D;");
                Text.setStyle("-fx-background-color: #E7717D;");
                Views.setTextFill(Paint.valueOf("#950740"));
                Create_time.setTextFill(Paint.valueOf("#950740"));
                Create_day.setTextFill(Paint.valueOf("#950740"));
                Creater.setTextFill(Paint.valueOf("#950740"));
                Likes.setTextFill(Paint.valueOf("#950740"));
                Post_text.setTextFill(Paint.valueOf("#950740"));
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
                List.setStyle("-fx-background-color: #E7717D;");
                Text.setStyle("-fx-background-color: #E7717D;");
                Views.setTextFill(Paint.valueOf("#AC3B61"));
                Create_time.setTextFill(Paint.valueOf("#AC3B61"));
                Create_day.setTextFill(Paint.valueOf("#AC3B61"));
                Creater.setTextFill(Paint.valueOf("#AC3B61"));
                Likes.setTextFill(Paint.valueOf("#AC3B61"));
                Post_text.setTextFill(Paint.valueOf("#AC3B61"));
            }
            try {
                Creater_prof.setImage(user_selected.getProfile_Image());
            }catch (Exception e){}
            Creater.setText(user_selected.getUser_Name());
            Text.setText("");
            Error.setText("");
            List.getItems().clear();
            post_num = user_selected.getMy_Posts().size() - 1;
            user_selected.getMy_Posts().get(post_num).Add_View(user);
            Update_Post_information();
        }catch (Exception e){}
    }

    public void Update_Post_information(){

        try {
            Post post = user_selected.getMy_Posts().get(post_num);
            try {
                Post_image.setImage(post.getImage());
            }catch (Exception e){}
            List.getItems().clear();
            Text.setText("");
            Views.setText("Views:" + post.getViews());
            Likes.setText("Likes:" + post.getLikes());
            Create_day.setText(String.valueOf(post.getCreatTime()));
            Create_time.setText(String.valueOf(post.getCreat_our()));
            Post_text.setText(post.getText());
            Error.setText("");
            post.Add_View(user);
        }catch (Exception e){}
    }

    public void Back(MouseEvent mouseEvent) {
        searchSelected.back();
    }

    public void NEXT(MouseEvent mouseEvent) {

        try {
            post_num--;
            if (post_num <= -1) {
                post_num = 0;
                Error.setText(" its first post user uploaded ");
            } else {
                Update_Post_information();
            }
        }catch (Exception e){}
    }

    public void LAST(MouseEvent mouseEvent) {

        try {
            post_num++;
            if (post_num >= user_selected.getMy_Posts().size()) {
                post_num = user_selected.getMy_Posts().size() - 1;
                Error.setText(" its last post user uploaded ");
            } else {
                Update_Post_information();
            }
        }catch (Exception e){}
    }

    public void Add_Comment(MouseEvent mouseEvent) {

        try {
            if (!Text.getText().equals("")) {
                Comment comment = new Comment(user, Text.getText());
                user_selected.getMy_Posts().get(post_num).Add_Comment(comment);
            } else {
                Error.setText(" you must enter a message ");
            }
            See_Comments();
        }catch (Exception e){}
    }

    public void LIKE(MouseEvent mouseEvent) {

        try {
            user_selected.getMy_Posts().get(post_num).Add_Like(user);
            Text.setText("");
            List.getItems().clear();
            Error.setText("");
            Likes.setText("Likes:" + user_selected.getMy_Posts().get(post_num).getLikes());
        }catch (Exception e){}
    }

    public void See_Likers(MouseEvent mouseEvent) {

        try {
            ArrayList<User> users = user_selected.getMy_Posts().get(post_num).getLikers();
            Text.setText("");
            List.getItems().clear();
            Error.setText("");

            for (User value : users) {
                List.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

    public void See_Comments(MouseEvent mouseEvent){

        try {
            ArrayList<Comment> comments = user_selected.getMy_Posts().get(post_num).getComments();
            Text.setText("");
            List.getItems().clear();
            Error.setText("");

            for (Comment value : comments) {
                List.getItems().add(value.comment_info()+"\n"+value.getText());
            }
        }catch (Exception e){}
    }
    public void See_Comments(){

        try {
            ArrayList<Comment> comments = user_selected.getMy_Posts().get(post_num).getComments();
            Text.setText("");
            List.getItems().clear();
            Error.setText("");

            for (Comment value : comments) {
                List.getItems().add(value.comment_info()+"\n"+value.getText());
            }
        }catch (Exception e){}
    }

    public void See_Viewers(MouseEvent mouseEvent) {

        try {
            ArrayList<User> users = user_selected.getMy_Posts().get(post_num).getViwer();
            Text.setText("");
            List.getItems().clear();
            Error.setText("");

            for (User value : users) {
                List.getItems().add(value.getUser_Name());
            }
        }catch (Exception e){}
    }

}