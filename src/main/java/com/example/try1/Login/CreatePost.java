package com.example.try1.Login;

import com.example.try1.oop.Post;
import com.example.try1.oop.User;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.Serializable;

public class CreatePost implements Serializable {


    public TextField Text;
    public ImageView image;
    public AnchorPane Anchorpane;


    private File file;
    private Home home;
    private User user;

    public void createpost(Home home,User user,boolean Dark_Mod){
        this.user =user;
        this.home =home;

        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #767676;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
        }
    }

    public void Cancel(MouseEvent mouseEvent) {
        home.back();
    }

    public void Create(MouseEvent mouseEvent) {

        if (!Text.getText().equals("") || image.getImage() != null) {

            try {
                if (file != null) {
                    Post post = new Post(user, Text.getText(), file.toURI().toString());
                    user.Add_post(post);
                }
                else {
                    Post post = new Post( Text.getText(),user);
                    user.Add_post(post);
                }
                home.back();
            }catch (Exception e){}
        }
        else {
            Text.setText(" enter a text or add a fig ");
        }
    }

    public void Add_Fig(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.*"));
        File file = fileChooser.showOpenDialog(null);
        this.file =file;
        if ( file != null) {
            try {
                 image.setImage(new Image(file.toURI().toString()));
            }
            catch (Exception e){}
        }
    }

}
