package com.example.try1.oop;

import java.io.Serializable;
import java.time.LocalDate;

public class Day_Information implements Serializable {
    LocalDate localDate ;
    int Likes =0 ;
    int Views =0 ;

    public int getLikes() {
        return Likes;
    }
    public void setLikes() {
        Likes ++;
    }

    public int getViews() {
        return Views;
    }
    public void setViews() {
        Views ++;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Day_Information(int Likes , int Views , LocalDate localDate){

        this.Likes = Likes;
        this.Views = Views;
        this.localDate = localDate;

    }

}
