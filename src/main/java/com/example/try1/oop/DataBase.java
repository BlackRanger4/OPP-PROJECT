package com.example.try1.oop;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;


import org.apache.commons.lang3.*;

public class DataBase implements Serializable {

    private ArrayList<User> All_User = new ArrayList<>();
    private ArrayList<Group_Chat> All_Group_Chat = new ArrayList<>();
    private ArrayList<PV_Chat>All_Privet_Chat = new ArrayList<>();
    private ArrayList<Post> All_Post = new ArrayList<>();


    static final String DElETE_BEFORE_SAVE = "DELETE FROM java_objects";

    static final String WRITE_OBJECT_SQL = "INSERT INTO java_objects(id , name, object_value) VALUES (1, ?, ?)";

    static final String READ_OBJECT_SQL = "SELECT object_value FROM java_objects WHERE id = 1";


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
        if (!name.equals("")) {
            for (int i = 0; i < Size; i++) {
                if (All_User.get(i).getUser_Name().contains(name) && All_User.get(i).getUser_Name().indexOf(name) == 0) {
                    users.add(All_User.get(i));
                }
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

    public Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/daz";
        String username = "root";
        String password = "1363344552Sad";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public void savedata(Connection conn) throws SQLException {
        String className = this.getClass().getName();
        PreparedStatement pstmt1 = conn.prepareStatement(DElETE_BEFORE_SAVE);
        PreparedStatement pstmt = conn.prepareStatement(WRITE_OBJECT_SQL);

        byte[] temp = SerializationUtils.serialize(this);
        pstmt1.executeUpdate();

        // set input parameters
        pstmt.setString(1, className);
        pstmt.setObject(2, temp);
        pstmt.executeUpdate();

        pstmt.close();
        System.out.println("You saved data");
    }

    public DataBase loaddata(Connection conn) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
        try {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Object object = SerializationUtils.deserialize((byte[])rs.getObject(1));
            rs.close();
            pstmt.close();
            System.out.println("data loaded");
            return (DataBase) object;
        }
        catch (SQLException exception) {
            return null;
        }
    }

    public boolean checkdata(Connection conn) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
        try {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException exception) {
            return false;
        }
    }




}
