package com.example.try1.oop;



import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Group_Chat implements Serializable {

    private ArrayList<User> Members ;
    private ArrayList<User> banned = new ArrayList<>();
    private User Admin;
    private String GroupName;
    private DataBase data;
    private ArrayList<Message> Messages = new ArrayList<>();
    private LocalDate CreateTime ;
    private String image;




    public ArrayList<User> getMembers() {
        return Members;
    }
    public User getAdmin() {
        return Admin;
    }
    public String getGroupName() {
        return GroupName;
    }
    public ArrayList<Message> getMessages() {
        return Messages;
    }
    public LocalDate getCreateTime() {
        return CreateTime;
    }
    public Image getImage() {
        try {
            Image image = new Image(this.image);
            return image;
        }catch (Exception e){}
        return null;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public void Add_Message(Message message){
        Messages.add(message);
    }
    public void Delete_Message(Message message){
        Messages.remove(message);
    }

    public void Add_Member(User user){
        Members.add(user);
    }
    public void Delete_Member(User user){
        Members.remove(user);
    }

    public Message getLast_Message(){
        return Messages.get(Messages.size()-1);
    }
    public int How_many_Message_not_see(User user){

        int result = 0;
        for (Message message : Messages) {
            if (!message.User_See_Message(user)) {
                result++;
            }
        }
        return result;
    }

    public Group_Chat(ArrayList<User> members, User admin, String groupName, DataBase data ,String image) {
        Members = members;
        Admin = admin;
        GroupName = groupName;
        this.data = data;
        CreateTime = LocalDate.now();
        this.image = image;
    }

    public ArrayList<User> getBanned() {
        return banned;
    }

    public void setBanned(ArrayList<User> banned) {
        this.banned = banned;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public void Seen_ALl(User user){
        for (Message message : Messages){
            message.Add_Viewers(user);
        }
    }

}