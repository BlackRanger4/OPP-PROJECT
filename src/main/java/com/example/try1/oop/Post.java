package com.example.try1.oop;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Post implements Serializable {

    private User Creater ;
    String Text  ;
    boolean business ;
    String image;

    LocalDate CreatTime ;
    LocalTime Creat_our ;

    ArrayList<User> Likers = new ArrayList<>();
    ArrayList<User> Viwer = new ArrayList<>();
    ArrayList<Comment> Comments = new ArrayList<>();
    ArrayList<Day_Information> day_informations = new ArrayList<>();


    public String getText() {
        return Text;
    }
    public boolean isBusiness() {
        return business;
    }
    public Image getImage() {

        Image image = new Image(this.image);
        return image;
    }
    public LocalDate getCreatTime() {
        return CreatTime;
    }
    public LocalTime getCreat_our() {
        return Creat_our;
    }
    public ArrayList<User> getLikers() {
        return Likers;
    }
    public ArrayList<User> getViwer() {
        return Viwer;
    }
    public ArrayList<Comment> getComments() {
        return Comments;
    }
    public ArrayList<Day_Information> getDay_informations() {
        return day_informations;
    }


    public void Add_Comment(Comment coment){
        Comments.add(coment);
    }
    public void Add_Like(User user){

        if (!Likers.contains(user)){
            Likers.add(user);
            if (business){
                Add_like_b();
                user.add_B_Posts_to_my_likes(this);
            }
        }
    }
    public void Add_like_b(){

        int Size = day_informations.size();
        int i;
        for ( i=0 ; i<Size; i++){
            if (day_informations.get(i).localDate.equals(LocalDate.now())){
                break;
            }
        }
        if (i == Size){
            Day_Information day_information = new Day_Information(0,0,LocalDate.now());
            day_informations.add(day_information);
        }
        day_informations.get(i).setLikes();

    }
    public void Add_View(User user){

        if (!Viwer.contains(user)){
            Viwer.add(user);
            //Views++;

            if (business){
                Add_view_b();
            }
        }

    }
    public void Add_view_b(){

        int Size = day_informations.size();
        int i;
        for ( i=0 ; i<Size; i++){
            if (day_informations.get(i).localDate.equals(LocalDate.now())){
                break;
            }
        }
        if (i == Size){
            Day_Information day_information = new Day_Information(0,0,LocalDate.now());
            day_informations.add(day_information);
        }
        day_informations.get(i).setViews();

    }

    public void delete_b_post(){

        for (User liker : Likers) {
            liker.delete_b_posts_liked(this);
        }
    }

    public User getCreater() {
        return Creater;
    }
    public int getLikes(){
        return Likers.size();
    }
    public int getViews(){
        return Viwer.size();
    }

    public Post (String text , User user){
        this.Creater = user;
        this.business = user.getBusiness();
        if (business){
            this.Text = "..ad..\n" + text;
        }
        else {
            this.Text = text;
        }
        this.CreatTime = LocalDate.now();
        this.Creat_our = LocalTime.now();
    }
    public Post(User creater, String text, String image) {
        Creater = creater;
        Text = text;
        this.image = image;
        this.business = creater.getBusiness();
        if (business){
            this.Text = "..ad..\n" + text;
        }
        else {
            this.Text = text;
        }
        this.CreatTime = LocalDate.now();
        this.Creat_our = LocalTime.now();
    }

}
