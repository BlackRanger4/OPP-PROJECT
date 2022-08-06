package com.example.try1.Login;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FirstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        FirstPage firstPage = fxmlLoader.getController();
        Image ic = new Image(String.valueOf(getClass().getResource("stageicon.png")));
        firstPage.firstPage(stage,scene);
        stage.setTitle("ASTA");
        stage.getIcons().add(ic);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){
        launch();
    }

}