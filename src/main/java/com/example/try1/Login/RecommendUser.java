package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.User;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.util.ArrayList;

public class RecommendUser implements Serializable {

    public ListView<String> List;
    public AnchorPane Anchorpane;


    private FirstMenu firstMenu;
    private User user;


    public void recommenduser(FirstMenu firstMenu,User user ,DataBase dataBase,boolean Dark_Mod){

        this.firstMenu =firstMenu;
        this.user =user;


        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #767676;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
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

        if (recommend_user.size() == 0){
            List.getItems().add(" sorry we cannot recommend a user to you for below reason.\n 1. you not follow a user " +
                    "\n 2. your followings not follow a user \n 3. you follow all of your following's followings  ");
        }
        else {


            int Max ;
            for (int i =0 ; i < 10 && recommend_user.size()>0 ; i++){

                Max = getIndexOfLargest(score);
                if (Max == -1){
                    break;
                }
                List.getItems().add(recommend_user.get(Max).getUser_Name());

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

}