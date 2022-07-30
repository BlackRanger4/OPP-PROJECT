package com.example.try1.oop;

import java.util.ArrayList;

public class PV_Chat {

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



    public PV_Chat(User first, User second , Message selected,DataBase data) {

        this.First = first;
        this.Second = second;
        this.data = data ;
    }

}
