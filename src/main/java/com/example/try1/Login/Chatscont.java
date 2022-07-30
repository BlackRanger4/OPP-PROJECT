package com.example.try1.Login;

import com.example.try1.oop.DataBase;
import com.example.try1.oop.Group_Chat;
import com.example.try1.oop.PV_Chat;
import com.example.try1.oop.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Chatscont implements Initializable {

    public ListView<String> List;
    public ListView<String> Listchat;
    public ChoiceBox<String> porg;

    private DataBase dataBase;
    private User user;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;

    private ArrayList<PV_Chat> pv_chats;
    private ArrayList<Group_Chat> group_chats;
    private final String[] pvorgroup = { "pv chats" , "group chats"};
    private ArrayList<String> pvchatsname;
    private ArrayList<String> groupchatsname;
    private PV_Chat selectedpv;
    private Group_Chat selectedgr;


    public String choice;
    public String selectedchat;
    public int indexof;
    boolean pvorgr;

    public void Chatscont(DataBase dataBase, User user, FirstMenu firstMenu, Scene scene , Stage stage) {
        Chatscont.stage = stage;
        this.dataBase = dataBase;
        this.user = user;
        this.firstMenu = firstMenu;
        this.scene = scene;
        this.pv_chats = user.getMy_Privete_Chat();
        this.group_chats = user.getMy_Group_Chat();
        this.pvchatsname = new ArrayList<>();
        this.groupchatsname = new ArrayList<>();
    }

    public void extpvchats() {
        pvchatsname.clear();
        int i;
        int cap = pv_chats.size();
        if (cap != 0) {
            for (i = 0; i < cap; i++) {
                if (!user.getMy_Privete_Chat().get(i).getSecond().getUser_Name().equals(user.getUser_Name())) {
                    pvchatsname.add(pv_chats.get(i).getFirst().getUser_Name());
                } else {
                    pvchatsname.add(pv_chats.get(i).getSecond().getUser_Name());
                }
            }
        }
    }

    public void extgroupchats() {
        groupchatsname.clear();
        int i;
        int cap = group_chats.size();
        if (cap != 0) {
            for (i = 0; i < cap; i++) {
                groupchatsname.add(group_chats.get(i).getGroupName());
            }
        }
    }

    public void Back(MouseEvent mouseEvent) {
        firstMenu.Back();
    }
    public void back(){
        stage.setScene(scene);
    }

    public void choose() {
        choice = porg.getValue();
        if (choice.equals("pv chats")){
            extpvchats();
            getList().setItems(FXCollections.observableList(pvchatsname));
            pvorgr = false;
        }
        else {
            extgroupchats();
            getList().setItems(FXCollections.observableList(groupchatsname));
            pvorgr = true;
        }
    }

    public void createnewpv() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newpvchat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        newpvchatcont newpvchatcont = fxmlLoader.getController();
        newpvchatcont.newpvchatcont(dataBase,user,this,scene,stage);
    }

    public void createnewgr() {

    }

    public PV_Chat getSelectedpv() {
        return selectedpv;
    }

    public void setSelectedpv(PV_Chat selectedpv) {
        this.selectedpv = selectedpv;
    }

    public Group_Chat getSelectedgr() {
        return selectedgr;
    }

    public void setSelectedgr(Group_Chat selectedgr) {
        this.selectedgr = selectedgr;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        porg.setItems(FXCollections.observableList(Arrays.stream(pvorgroup).toList()));

        getList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                selectedchat = getList().getSelectionModel().getSelectedItem();
                if (!pvorgr){
                    indexof = pvchatsname.indexOf(selectedchat);
                    selectedpv = pv_chats.get(indexof);
                    Listchat.setItems(FXCollections.observableList(selectedpv.printchatmassage()));
                }
                else {
                    indexof = group_chats.indexOf(selectedchat);
                    selectedgr = group_chats.get(indexof);
                    Listchat.setItems(FXCollections.observableList(selectedgr.printchatmassage()));
                }

            }
        });

    }









    public ListView<String> getList() {
        return List;
    }

    public void setList(ListView<String> list) {
        List = list;
    }

    public ListView<String> getListchat() {
        return Listchat;
    }

    public void setListchat(ListView<String> listchat) {
        Listchat = listchat;
    }

    public ChoiceBox<String> getPorg() {
        return porg;
    }

    public void setPorg(ChoiceBox<String> porg) {
        this.porg = porg;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FirstMenu getFirstMenu() {
        return firstMenu;
    }

    public void setFirstMenu(FirstMenu firstMenu) {
        this.firstMenu = firstMenu;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Chatscont.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<PV_Chat> getPv_chats() {
        return pv_chats;
    }

    public void setPv_chats(ArrayList<PV_Chat> pv_chats) {
        this.pv_chats = pv_chats;
    }

    public ArrayList<Group_Chat> getGroup_chats() {
        return group_chats;
    }

    public void setGroup_chats(ArrayList<Group_Chat> group_chats) {
        this.group_chats = group_chats;
    }
}
