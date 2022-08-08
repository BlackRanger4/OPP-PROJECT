package com.example.try1.Login;

import com.example.try1.oop.Comment;
import com.example.try1.oop.PV_Chat;
import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SeePostOfUser implements Serializable, Initializable {


    public ImageView Creater_prof;
    public ImageView Post_image;
    public ListView<Comment> comments;
    public ListView<User> usersarr;
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
                usersarr.setStyle("-fx-background-color: #E7717D;");
                comments.setStyle("-fx-background-color: #E7717D;");
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
                usersarr.setStyle("-fx-background-color: #E7717D;");
                comments.setStyle("-fx-background-color: #E7717D;");
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
            usersarr.getItems().clear();
            comments.getItems().clear();
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
            usersarr.getItems().clear();
            comments.getItems().clear();
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

    public void Add_Comment() {
            if (!Text.getText().equals("")) {
                Comment comment = new Comment(user, Text.getText());
                user_selected.getMy_Posts().get(post_num).Add_Comment(comment);
            } else {
                Error.setText(" you must enter a message ");
            }
            See_Comments();
    }

    public void LIKE() {

        try {
            user_selected.getMy_Posts().get(post_num).Add_Like(user);
            Text.setText("");
            usersarr.getItems().clear();
            Error.setText("");
            Likes.setText("Likes:" + user_selected.getMy_Posts().get(post_num).getLikes());
        }catch (Exception e){}
    }

    public void See_Likers() {

        try {
            usersarr.getItems().clear();
            usersarr.getItems().addAll(user_selected.getMy_Posts().get(post_num).getLikers());
            comments.setVisible(false);
            usersarr.setVisible(true);
        }catch (Exception e){}
    }

    public void See_Comments(){

            comments.getItems().clear();
            comments.getItems().addAll(user_selected.getMy_Posts().get(post_num).getComments());
            comments.setVisible(true);
            usersarr.setVisible(false);
    }

    public void See_Viewers() {

        try {
            usersarr.getItems().clear();
            usersarr.getItems().addAll(user_selected.getMy_Posts().get(post_num).getViwer());
            comments.setVisible(false);
            usersarr.setVisible(true);
        }catch (Exception e){}
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
                        comment.Add_reply(Text.getText(),user.getUser_Name());
                        reflist();
                    }
                });

                setGraphic(vbox);
            }
        }
    }

    public void reflist() {
        comments.getItems().clear();
        usersarr.getItems().clear();
        usersarr.getItems().addAll(user_selected.getMy_Posts().get(post_num).getLikers());
        comments.getItems().addAll(user_selected.getMy_Posts().get(post_num).getComments());
    }


}