package com.example.try1.Login;

import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class CreatePost {


    public TextField Text;
    public ImageView image;

    private Home home;
    private User user;

    public void createpost(Home home,User user){
        this.user =user;
        this.home =home;
    }

    public void Cancel(MouseEvent mouseEvent) {
        home.back();
    }

    public void Create(MouseEvent mouseEvent) {

        if (!Text.getText().equals("") || image.getImage() != null) {

            try {
                Post post = new Post(user,Text.getText(),image.getImage());
                user.Add_post(post);
            }catch (Exception e){}
            home.back();
        }
        else {
            Text.setText(" enter a text or add a fig ");
        }
    }

    public void Add_Fig(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.*"));
        File file = fileChooser.showOpenDialog(null);

        if ( file != null) {
            try {
                 image.setImage(new Image(file.toURI().toString()));
            }
            catch (Exception e){}
        }
    }

}
