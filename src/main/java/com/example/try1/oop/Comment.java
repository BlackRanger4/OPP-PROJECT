package com.example.try1.oop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Comment implements Serializable {

    private String Text ;
    private User Sender ;
    private LocalDate CreatTime ;
    private LocalTime Creat_our ;

    public String getText() {
        return Text;
    }


    public Comment(User user , String text){
        this.Sender = user ;
        CreatTime = LocalDate.now();
        Creat_our = LocalTime.now();
        this.Text = user.getUser_Name()+":"+text+"\n"+CreatTime+" "+Creat_our ;
    }

}