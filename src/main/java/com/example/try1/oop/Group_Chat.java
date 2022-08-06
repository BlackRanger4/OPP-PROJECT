package com.example.try1.oop;



import javafx.scene.image.Image;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Group_Chat implements Serializable {

    private ArrayList<User> Members ;
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

    /*
    public ArrayList<Object> printchatmassage() {
        String test = "";
        ArrayList<Object> temp = new ArrayList<>();
        int i;
        int cap = this.getMessages().size();
        if (cap != 0) {
            for (i = 0; i < cap; i++) {
                if (this.getMessages().get(i).getForwarded() == null && this.getMessages().get(i).getReply() == null) {
                    test = this.getMessages().get(i).getSender().getUser_Name() +
                            " : " + this.getMessages().get(i).getText();
                }
                if (this.getMessages().get(i).getForwarded() != null && this.getMessages().get(i).getReply() == null) {
                    test = this.getMessages().get(i).getSender().getUser_Name() + " : " +
                            this.getMessages().get(i).getText() + " forwarded from " +
                            this.getMessages().get(i).getForwarded().getUser_Name();
                }
                if (this.getMessages().get(i).getForwarded() == null && this.getMessages().get(i).getReply() != null) {
                    test = this.getMessages().get(i).getSender().getUser_Name() + " : " +
                            this.getMessages().get(i).getText() + " replied to " +
                            this.getMessages().get(i).getReply().getText();
                }
                temp.add(test);
            }
        }
        return temp;
    }
     */
}