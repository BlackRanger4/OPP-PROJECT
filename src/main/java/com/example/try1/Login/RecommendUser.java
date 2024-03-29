package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.util.Callback;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RecommendUser implements Initializable {

    public ListView<User> List;
    public AnchorPane Anchorpane;
    public Button Button;
    public Label Label;


    private FirstMenu firstMenu;
    private User user;


    public void recommenduser(FirstMenu firstMenu,User user ,DataBase dataBase,boolean Dark_Mod){

        this.firstMenu =firstMenu;
        this.user =user;


        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            List.setStyle("-fx-background-color: #E7717D;");
            Button.setTextFill(Paint.valueOf("#ffffff"));
            Button.setStyle("-fx-background-color: #6F2232;");
            Label.setTextFill(Paint.valueOf("#950740"));
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            List.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Label.setTextFill(Paint.valueOf("#AC3B61"));
        }
        User_recommend();
    }

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }

    public void User_recommend(){

        ArrayList<User> following_user = user.getMy_Following();

        ArrayList<User> recommend_user = new ArrayList<>();
        for (User value : following_user) {
            recommend_user.addAll(value.getMy_Following());
        }

        recommend_user = removeDuplicates(recommend_user);
        recommend_user.remove(user);
        for (int i=0 ; i < recommend_user.size() ;){

            if (recommend_user.get(i).Is_my_followers(user)){
                recommend_user.remove(i);

            }else {
                i++;
            }

        }

        int Size_R = recommend_user.size();
        ArrayList<Integer> score = new ArrayList<>() ;
        int scorei ;
        for (int i=0; i<Size_R ; i++){

            scorei =0 ;
            for (User value : following_user) {

                if (value.Is_my_followers(recommend_user.get(i))) {
                    scorei++;
                }
            }
            score.add(scorei);
        }

        if ( recommend_user.size() != 0) {

            int Max ;
            for (int i =0 ; i < 10 && recommend_user.size()>0 ; i++){

                Max = getIndexOfLargest(score);
                if (Max == -1){
                    break;
                }
                List.getItems().add(recommend_user.get(Max));
                score.remove(Max);
                recommend_user.remove(Max);

            }
        }
    }
    public int getIndexOfLargest( ArrayList<Integer> array ) {

        if ( array == null || array.size() == 0 ) return -1;

        int largest = 0;
        for ( int i = 1; i < array.size(); i++ )
        {
            if ( array.get(i) > array.get(largest))
                largest = i;
        }
        return largest;
    }

    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> userListView) {
                return new List3();
            }
        });
    }


    class List3 extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List3() {
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


}