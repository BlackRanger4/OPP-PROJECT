package com.example.try1.oop;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Message implements Serializable {

    private String Text ;
    private User Sender ;
    private Message reply ;
    private User forwarded ;
    private ArrayList<PV_Chat> frwrded_pv ;
    private ArrayList<Group_Chat> frwrded_gr ;

    private LocalTime Creat_time_our ;
    private LocalDate Creat_time_date;
    private String image ;


    private ArrayList<User> Viewrs = new ArrayList<>();

    public String getText() {
        return Text;
    }
    public User getSender() {
        return Sender;
    }
    public Message getReply() {
        return reply;
    }
    public User getForwarded() {
        return forwarded;
    }
    public ArrayList<PV_Chat> getFrwrded_pv() {
        return frwrded_pv;
    }
    public ArrayList<Group_Chat> getFrwrded_gr() {
        return frwrded_gr;
    }
    public LocalTime getCreat_time_our() {
        return Creat_time_our;
    }
    public LocalDate getCreat_time_date() {
        return Creat_time_date;
    }
    public void setText(String text) {
        Text = text;
    }

    public Image getImage() {
        if (this.image != null){
        Image image = new Image(this.image);
        return image;
        }
        return null;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public void Add_Viewers(User user){

        if (!Viewrs.contains(user)){
            Viewrs.add(user);
        }
    }
    public boolean User_See_Message(User user){
        if (Viewrs.contains(user)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean IsAfter(Message message){

        if (this.Creat_time_date.equals(message.getCreat_time_date())){
            if (this.Creat_time_our.isAfter(message.getCreat_time_our())){
                return true;
            }else {
                return false;
            }
        }
        else if (this.Creat_time_date.isAfter(message.getCreat_time_date())){
            return true;
        }
        else {
            return false;
        }
    }

    public Message(User sender, String text, Message reply, User forwarded,String image) {
        Text = text;
        Sender = sender;
        this.reply = reply;
        this.forwarded = forwarded;
        this.image =image;
        frwrded_gr = new ArrayList<>();
        frwrded_pv = new ArrayList<>();
        Creat_time_our = LocalTime.now();
        Creat_time_date = LocalDate.now();
    }
}