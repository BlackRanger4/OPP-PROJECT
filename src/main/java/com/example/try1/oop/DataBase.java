package com.example.try1.oop;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<User> All_User = new ArrayList<>();
    private ArrayList<Group_Chat> All_Group_Chat = new ArrayList<>();
    private ArrayList<PV_Chat>All_Privet_Chat = new ArrayList<>();
    private ArrayList<Post> All_Post = new ArrayList<>();


    public boolean User_finder(String User_Name){

        int Size = All_User.size();

        for (int i=0 ; i< Size ;i++){

            if (User_Name.equals(All_User.get(i).getUser_Name())){
                return true;
            }
        }

        return false ;
    }
    public User User_finder_U(String User_Name){

        int Size = All_User.size();

        for (int i=0 ; i< Size ;i++){

            if (User_Name.equals(All_User.get(i).getUser_Name())){
                return All_User.get(i);
            }
        }

        return null;
    }
    public void Add_User_to_datas(User user){

        All_User.add(user);
    }
    public ArrayList<User> User_Search(String name){
        int Size = All_User.size();
        ArrayList<User> users = new ArrayList<>();
        for (int i =0 ; i<Size ; i ++){
            if (All_User.get(i).getUser_Name().contains(name)){
                users.add(All_User.get(i));
            }
        }
        return users;
    }

    public void Add_post(Post post){
        All_Post.add(post);
    }
    public void Delete_post(Post post){
        All_Post.remove(post);
    }

    public void Add_PV_Chat(PV_Chat privete_chat){
        All_Privet_Chat.add(privete_chat);
    }
    public void Delete_PV_Chat(PV_Chat privete_chat){
        All_Privet_Chat.remove(privete_chat);
    }

    public void Add_Group_Chat(Group_Chat group_chat){
        All_Group_Chat.add(group_chat);
    }
    public void Delete_Group_Chat(Group_Chat group_chat){
        All_Group_Chat.remove(group_chat);
    }
    public boolean Group_finder(String id) {
        int Size = All_Group_Chat.size();
        for (int i = 0; i < Size; i++) {
            if (id.equals(All_Group_Chat.get(i).getGroupName())) {
                return true;
            }
        }
        return false;
    }



}
