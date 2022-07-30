package com.example.try1.oop;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {


    Image Profile_Image ;
    String User_Name ;
    String Password ;
    Boolean business ;
    DataBase database;

    ArrayList<Post> My_Posts = new ArrayList<>();
    ArrayList<Post> My_B_Posts_like = new ArrayList<>();
    ArrayList<PV_Chat> My_Privete_Chat = new ArrayList<>();
    ArrayList<Group_Chat> My_Group_Chat = new ArrayList<>();

    ArrayList<User> My_Followers = new ArrayList<>();
    ArrayList<User> My_Following = new ArrayList<>();
    ArrayList<User> Blocked_User = new ArrayList<>();

    String[] Security_Q  ;
    String[] Security_A  ;

    LocalDate CreateTime ;
    ArrayList<Day_Information> day_informations = new ArrayList<>() ;

    // getter and setter
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean getBusiness() {
        return business;
    }
    public ArrayList<Post> getMy_Posts() {
        return My_Posts;
    }
    public ArrayList<Post> getMy_B_Posts_like() {
        return My_B_Posts_like;
    }
    public ArrayList<PV_Chat> getMy_Privete_Chat() {
        return My_Privete_Chat;
    }
    public ArrayList<Group_Chat> getMy_Group_Chat() {
        return My_Group_Chat;
    }
    public ArrayList<User> getMy_Followers() {
        return My_Followers;
    }
    public ArrayList<User> getMy_Following() {
        return My_Following;
    }
    public ArrayList<User> getBlocked_User() {
        return Blocked_User;
    }
    public LocalDate getCreateTime() {
        return CreateTime;
    }
    public ArrayList<Day_Information> getDay_informations() {
        return day_informations;
    }
    public String getUser_Name() {
        return User_Name;
    }
    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String[] getSecurity_Q() {
        return Security_Q;
    }
    public void setSecurity_Q(String[] security_Q) {
        Security_Q = security_Q;
    }
    public String[] getSecurity_A() {
        return Security_A;
    }
    public void setSecurity_A(String[] security_A) {
        Security_A = security_A;
    }
    public int getMy_Followers_num(){
        return My_Followers.size();
    }
    public int getMy_Followings_num(){
        return My_Following.size();
    }
    public Image getProfile_Image() {
        return Profile_Image;
    }
    public void setProfile_Image(Image profile_Image) {
        Profile_Image = profile_Image;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void Unblocked_User(User user){
         Blocked_User.remove(user);
    }
    public User getUnblocked_user(String name){
        for (User user : Blocked_User) {
            if (user.getUser_Name().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void Remove_post(Post post){
        if (business){
            post.delete_b_post();
        }
        database.Delete_post(post);
        My_Posts.remove(post);
    }
    public void Add_post(Post post){
        database.Add_post(post);
        My_Posts.add(post);
    }

    public void unfollowing_following_me(User user){
        if (My_Following.contains(user)){
            My_Following.remove(user);
            user.remove_followers(this);
        }
        else {
            My_Following.add(user);
            user.add_followers(this);
        }
    }
    public void remove_followers(User user){
        My_Followers.remove(user);
    }
    public void add_followers(User user){
        My_Followers.add(user);
    }

    public void add_B_Posts_to_my_likes(Post b_post){
        if (!My_B_Posts_like.contains(b_post)) {
            My_B_Posts_like.add(b_post);
        }
    }
    public void delete_b_posts_liked(Post b_post){
        My_B_Posts_like.remove(b_post);
    }
    public boolean Is_B_Post_liked(Post b_post){
        if (My_B_Posts_like.contains(b_post)){
            return true;
        }
        return false;
    }
    public boolean Is_my_followers (User user){
        if (My_Followers.contains(user)){
            return true ;
        }
        return false;
    }

    public void add_view_page(){

        int i;
        for ( i=0 ; i<day_informations.size(); i++){
            if (day_informations.get(i).localDate.equals(LocalDate.now())){
                break;
            }
        }
        if (i == day_informations.size()){
            Day_Information day_information = new Day_Information(0,0,LocalDate.now());
            day_informations.add(day_information);
        }
        day_informations.get(i).setViews();
    }



    public User(String user_Name, String password, Boolean business, DataBase database ,String[] security_Q, String[] security_A) {
        User_Name = user_Name;
        Password = password;
        this.business = business;
        this.database = database;
        Security_Q = security_Q;
        Security_A = security_A;
        this.CreateTime = LocalDate.now();
    }

}