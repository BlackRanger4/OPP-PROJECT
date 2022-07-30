package com.example.try1.oop;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comment {

    private String Text ;
    private User Sender ;
    private LocalDate CreatTime ;
    private LocalTime Creat_our ;

    public String getText() {
        return Text;
    }


    public Comment(User user , String text){
        this.Sender = user ;
        this.Text = user.getUser_Name()+":"+text+"\n"+CreatTime+" "+Creat_our ;
        CreatTime = LocalDate.now();
        Creat_our = LocalTime.now();
    }

}