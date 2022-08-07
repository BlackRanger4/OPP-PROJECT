package com.example.try1.oop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Comment implements Serializable {

    private String Text ;
    private User Sender ;
    private LocalDate CreatTime ;
    private LocalTime Creat_our ;
    private ArrayList<User> Liker = new ArrayList<>();

    public String getText() {
        return Text;
    }

    public void Add_reply(String reply , String user){

        Text +="\n   Reply:: "+user+":"+reply;
    }
    public void Add_like(User user){
        if (!Liker.contains(user)) {
            Liker.add(user);
        }
    }

    public String comment_info(){
        String string = "Likes:"+Liker.size()+","+CreatTime+","+Creat_our.getHour()+":"+Creat_our.getMinute() ;
        return string;
    }


    public Comment(User user , String text){
        this.Sender = user ;
        CreatTime = LocalDate.now();
        Creat_our = LocalTime.now();
        this.Text = user.getUser_Name()+":"+text ;
    }

}