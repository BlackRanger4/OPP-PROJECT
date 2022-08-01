package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Chatscont implements Initializable {

    public ListView<String> List;
    public ListView<Message> Listchat;
    public ChoiceBox<String> porg;
    public Button send;
    public TextArea mssgtext;

    private DataBase dataBase;
    private User user;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;

    private ArrayList<PV_Chat> pv_chats;
    private ArrayList<Group_Chat> group_chats;
    private ArrayList<Integer> NumOf_noSee = new ArrayList<>();
    private final String[] pvorgroup = { "pv chats" , "group chats"};
    private ArrayList<String> pvchatsname;
    private ArrayList<String> groupchatsname;
    private PV_Chat selectedpv;
    private Group_Chat selectedgr;


    public String choice;
    public String selectedchat;
    public int indexof;
    boolean pvorgr;
    public String textmssg;


    public void Sort_Pv_Chats_with_time(){

        quickSort(pv_chats,0,pv_chats.size()-1);
        NumOf_noSee.clear();
        for (PV_Chat pv_chat : pv_chats) {
            NumOf_noSee.add(pv_chat.How_many_Message_not_see(user));
        }
    }
    public void swap(ArrayList<PV_Chat> PV, int i, int j) {

        PV_Chat temp = PV.get(i);
        PV.set(i,PV.get(j)) ;
        PV.set(j,temp);
    }
    public int partition(ArrayList<PV_Chat> PV, int low, int high) {

        PV_Chat pivot = PV.get(high);

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (PV.get(j).getLast_Message().IsAfter(pivot.getLast_Message()))
            {
                i++;
                swap(PV, i, j);
            }
        }
        swap(PV, i + 1, high);
        return (i + 1);
    }
    public void quickSort(ArrayList<PV_Chat> PV, int low, int high) {
        if (low < high)
        {
            int pi = partition(PV, low, high);
            quickSort(PV, low, pi - 1);
            quickSort(PV, pi + 1, high);
        }
    }

    public void Sort_Group_Chats_with_time(){


        quickSorT(group_chats,0,group_chats.size()-1);
        NumOf_noSee.clear();
        for (Group_Chat group_chat : group_chats) {
            NumOf_noSee.add(group_chat.How_many_Message_not_see(user));
        }
    }
    public void swaP(ArrayList<Group_Chat> PV, int i, int j) {

        Group_Chat temp = PV.get(i);
        PV.set(i,PV.get(j)) ;
        PV.set(j,temp);

    }
    public int partitioN(ArrayList<Group_Chat> PV, int low, int high) {

        Group_Chat pivot = PV.get(high);

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (PV.get(j).getLast_Message().IsAfter(pivot.getLast_Message()))
            {
                i++;
                swaP(PV, i, j);
            }
        }
        swaP(PV, i + 1, high);
        return (i + 1);
    }
    public void quickSorT(ArrayList<Group_Chat> PV, int low, int high) {
        if (low < high)
        {
            int pi = partitioN(PV, low, high);
            quickSorT(PV, low, pi - 1);
            quickSorT(PV, pi + 1, high);
        }
    }


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
        Sort_Pv_Chats_with_time();
        int i;
        int cap = pv_chats.size();
        if (cap != 0) {
            for (i = 0; i < cap; i++) {
                if (user.getMy_Privete_Chat().get(i).getSecond().getUser_Name().equals(user.getUser_Name())) {
                    if (NumOf_noSee.get(i)>0) {
                        pvchatsname.add(pv_chats.get(i).getFirst().getUser_Name() + "(" + NumOf_noSee.get(i) + ")");
                    }
                    else {
                        pvchatsname.add(pv_chats.get(i).getFirst().getUser_Name());
                    }
                } else {
                    if (NumOf_noSee.get(i)>0) {
                    pvchatsname.add(pv_chats.get(i).getSecond().getUser_Name()+"("+NumOf_noSee.get(i)+")");
                    }
                    else {
                        pvchatsname.add(pv_chats.get(i).getFirst().getUser_Name());
                    }
                }
            }
        }
    }

    public void extgroupchats() {
        groupchatsname.clear();
        Sort_Group_Chats_with_time();
        int i;
        int cap = group_chats.size();
        if (cap != 0) {
            for (i = 0; i < cap; i++) {
                if (NumOf_noSee.get(i)>0) {
                    groupchatsname.add(group_chats.get(i).getGroupName() + "(" + NumOf_noSee.get(i) + ")");
                }
                else {
                    groupchatsname.add(group_chats.get(i).getGroupName());
                }

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

    public void createnewgr() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newgroupchat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        newgroupchatcont newgroupchatcont = fxmlLoader.getController();
        newgroupchatcont.newgroupchatcont(dataBase,user,this,scene,stage);
    }

    public void sendmassage () {
        textmssg = mssgtext.getText();
        Message temp = new Message(user,textmssg,null,null,null);
        if (!pvorgr) {
            selectedpv.getMessages().add(temp);
            Listchat.getItems().clear();
            Listchat.getItems().addAll(selectedpv.getMessages());
            mssgtext.setText("");
        }
        else {
            selectedgr.getMessages().add(temp);
            Listchat.getItems().clear();
            Listchat.getItems().addAll(selectedgr.getMessages());
            mssgtext.setText("");
        }
    }
    public void Add_Fig(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File","*.*"));
        File file = fileChooser.showOpenDialog(null);

        if ( file != null) {
            try {
                Image image = new Image(file.toURI().toString());
                Message message = new Message(user,null,null,null,file.toURI().toString());
                if (!pvorgr) {
                    selectedpv.getMessages().add(message);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedpv.getMessages());
                    mssgtext.setText("");
                }
                else {
                    selectedgr.getMessages().add(message);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedgr.getMessages());
                    mssgtext.setText("");
                }
            }
            catch (Exception e){}
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Listchat.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>() {
            @Override
            public ListCell<Message> call(ListView<Message> messageListView) {
                return new chatshow();
            }
        });

        porg.setItems(FXCollections.observableList(Arrays.stream(pvorgroup).toList()));

        getList().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                selectedchat = getList().getSelectionModel().getSelectedItem();
                if (!pvorgr){
                    indexof = pvchatsname.indexOf(selectedchat);
                    selectedpv = pv_chats.get(indexof);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedpv.getMessages());
                }
                else {
                    indexof = groupchatsname.indexOf(selectedchat);
                    selectedgr = group_chats.get(indexof);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedgr.getMessages());
                }
            }
        });

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


    public ListView<String> getList() {
        return List;
    }

    public void setList(ListView<String> list) {
        List = list;
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

    class chatshow extends ListCell<Message> {
        HBox hbox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();
        Label label = new Label();

        public chatshow() {
            super();
            hbox.getChildren().addAll(imgview,label,pane);
            HBox.setHgrow(pane, Priority.ALWAYS);
        }

        @Override
        public void updateItem(Message mssg , boolean empty) {
            super.updateItem(mssg, empty);
            if (mssg == null) {
                setGraphic(null);
            }
            else {
                if (mssg.getImage() == null && mssg.getText() == null) {
                    setText(null);
                    setGraphic(null);
                } else if (mssg.getText() != null && mssg.getImage() == null) {
                    label.setText(mssg.getText());
                    setGraphic(hbox);
                } else if (mssg.getText() == null && mssg.getImage() != null) {
                    imgview.setImage(mssg.getImage());
                    double cons = (mssg.getImage().getHeight()/mssg.getImage().getWidth());
                    imgview.setFitWidth(300);
                    imgview.setFitHeight(300*cons);
                    setGraphic(hbox);
                } else {
                    label.setText(mssg.getText());
                    imgview.setImage(mssg.getImage());
                    double cons = (mssg.getImage().getHeight()/mssg.getImage().getWidth());
                    imgview.setFitWidth(300);
                    imgview.setFitHeight(300*cons);
                    setGraphic(hbox);
                }
            }
        }

    }

}
