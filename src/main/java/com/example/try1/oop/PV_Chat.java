package com.example.try1.oop;

import java.io.Serializable;
import java.util.ArrayList;

public class PV_Chat implements Serializable {

    private User First ;
    private User Second ;
    private ArrayList<Message> Messages = new ArrayList<>();

    private DataBase data ;

    public User getFirst() {
        return First;
    }
    public User getSecond() {
        return Second;
    }
    public ArrayList<Message> getMessages() {
        return Messages;
    }

    public void Add_Message(Message message){
        Messages.add(message);
    }
    public void Delete_Message(Message message){
        Messages.remove(message);
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
    public void Seen_ALl(User user){
        for (Message message : Messages){
            message.Add_Viewers(user);
        }
    }

    public PV_Chat(User first, User second , Message selected,DataBase data) {

        this.First = first;
        this.Second = second;
        this.data = data ;
    }

}
