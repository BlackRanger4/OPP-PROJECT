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



    public PV_Chat(User first, User second , Message selected,DataBase data) {

        this.First = first;
        this.Second = second;
        this.data = data ;
    }

    public ArrayList<String> printchatmassage() {
        String test = "";
        ArrayList<String> temp = new ArrayList<>();
        int i;
        int cap = this.getMessages().size();
        if (cap == 0){
            System.out.println(" no message exist ");
        }
        else {
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

}
