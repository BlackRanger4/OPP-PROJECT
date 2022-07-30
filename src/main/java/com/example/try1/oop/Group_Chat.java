package com.example.try1.oop;

import java.time.LocalDate;
import java.util.ArrayList;

public class Group_Chat {

    private ArrayList<User> Members ;
    private User Admin;
    private String GroupName;
    private DataBase data;
    private ArrayList<Message> Messages = new ArrayList<>();
    private LocalDate CreateTime ;

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



    public Group_Chat(ArrayList<User> members, User admin, String groupName, DataBase data) {
        Members = members;
        Admin = admin;
        GroupName = groupName;
        this.data = data;
        CreateTime = LocalDate.now();
    }

}