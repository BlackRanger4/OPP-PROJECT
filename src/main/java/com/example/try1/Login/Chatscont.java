package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Chatscont implements Initializable {

    public Label PV_GROUP_NAME;
    public ListView<PV_Chat> List1;
    public ListView<Group_Chat> List2;
    public ListView<Message> Listchat;
    public ChoiceBox<String> porg;
    public Button send;
    public TextArea mssgtext;
    public ImageView PV_GROUP_image;
    public Button editbutton;
    public Button cancelreply;
    public Text replymassage;
    public Rectangle rect;
    public AnchorPane Anchorpane;


    private DataBase dataBase;
    private User user;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;

    private ArrayList<PV_Chat> pv_chats;
    private ArrayList<Group_Chat> group_chats;
    private ArrayList<Integer> NumOf_noSee = new ArrayList<>();
    private final String[] pvorgroup = { "pv chats" , "group chats"};
    private PV_Chat selectedpv;
    private Group_Chat selectedgr;


    public String choice;
    public int indexof;
    boolean pvorgr;
    boolean replyrun;
    public String textmssg;
    public Message selmessage;

    ContextMenu contextMenu = new ContextMenu();
    MenuItem edit = new MenuItem();
    MenuItem delete = new MenuItem();
    MenuItem reply = new MenuItem();
    MenuItem forward = new MenuItem();


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

    public void popup () {
        rect.setVisible(true);
        cancelreply.setVisible(true);
        replymassage.setVisible(true);
    }

    public void popdown () {
        rect.setVisible(false);
        cancelreply.setVisible(false);
        replymassage.setVisible(false);
    }

    public void choose () {
        if (porg.getValue().equals("pv chats")){
            pvorgr = false;
            List1.setVisible(true);
            List2.setVisible(false);
        }
        else {
            pvorgr = true;
            List2.setVisible(true);
            List1.setVisible(false);
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


    public void Chatscont(DataBase dataBase, User user, FirstMenu firstMenu, Scene scene , Stage stage , boolean Dark_Mod) {
        Chatscont.stage = stage;
        this.dataBase = dataBase;
        this.user = user;
        this.firstMenu = firstMenu;
        this.scene = scene;
        editbutton.setVisible(false);
        popdown();
        replyrun = false;
        this.Dark_Mod = Dark_Mod;
        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #767676;");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #ffffff;");
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

        if (replyrun) {
            textmssg = textmssg + mssgtext.getText();
            if (!textmssg.equals("")) {
                Message temp = new Message(user, textmssg, selmessage, null, null);
                if (!pvorgr) {
                    selectedpv.getMessages().add(temp);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedpv.getMessages());
                    mssgtext.setText("");
                } else {
                    selectedgr.getMessages().add(temp);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedgr.getMessages());
                    mssgtext.setText("");
                }
            }
            popdown();
            setSelmessage(null);
            replyrun = false;
        }
        else {
            textmssg = mssgtext.getText();
            if (!textmssg.equals("")) {
                Message temp = new Message(user, textmssg, null, null, null);
                if (!pvorgr) {
                    selectedpv.getMessages().add(temp);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedpv.getMessages());
                    mssgtext.setText("");
                } else {
                    selectedgr.getMessages().add(temp);
                    Listchat.getItems().clear();
                    Listchat.getItems().addAll(selectedgr.getMessages());
                    mssgtext.setText("");
                }
            }
        }



    }

    public void Add_Fig(MouseEvent mouseEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*.*"));
        File file = fileChooser.showOpenDialog(null);

        if (!replyrun) {

            if (file != null) {
                try {
                    Image image = new Image(file.toURI().toString());
                    Message message = new Message(user, mssgtext.getText(), null, null, file.toURI().toString());
                    if (!pvorgr) {
                        selectedpv.getMessages().add(message);
                        Listchat.getItems().clear();
                        Listchat.getItems().addAll(selectedpv.getMessages());
                        mssgtext.setText("");
                    } else {
                        selectedgr.getMessages().add(message);
                        Listchat.getItems().clear();
                        Listchat.getItems().addAll(selectedgr.getMessages());
                        mssgtext.setText("");
                    }
                    textmssg = "";
                } catch (Exception ignored) {}
            }
        }
        else {
            if (file != null) {
                try {
                    Image image = new Image(file.toURI().toString());
                    Message message = new Message(user, textmssg , selmessage, null, file.toURI().toString());
                    if (!pvorgr) {
                        selectedpv.getMessages().add(message);
                        Listchat.getItems().clear();
                        Listchat.getItems().addAll(selectedpv.getMessages());
                        mssgtext.setText("");
                    } else {
                        selectedgr.getMessages().add(message);
                        Listchat.getItems().clear();
                        Listchat.getItems().addAll(selectedgr.getMessages());
                        mssgtext.setText("");
                    }
                    textmssg = "";
                    setSelmessage(null);
                    popdown();


                } catch (Exception ignored) {}
            }
        }
    }

    public void edit(Message x){
        mssgtext.setText(x.getText());
        send.setVisible(false);
        editbutton.setVisible(true);
    }

    public void editsend(){
        Message x = getSelmessage();
        textmssg = mssgtext.getText();
        x.setText(textmssg);
        Listchat.refresh();
        editbutton.setVisible(false);
        send.setVisible(true);
        mssgtext.setText("");
    }

    public void delete(Message x){
        if (!pvorgr){
            selectedpv.getMessages().remove(x);
        }
        else {
            selectedgr.getMessages().remove(x);
        }
        Listchat.getItems().remove(x);
    }

    public void replyselect (Message x){
        String temp;
        if (x.getText().length() > 10) {
            temp = "| Reply to : ";
            temp = temp + x.getText().substring(0, 10);
            temp = temp + "...";
            replymassage.setText(temp);
        }
        else {
            temp = "| Reply to : ";
            temp = temp + x.getText();
            replymassage.setText(temp);
        }
        textmssg = temp + "\n";
        popup();
        replyrun = true;
    }

    public void cancelreply() {
        Listchat.getSelectionModel().clearSelection();
        popdown();
        replyrun = false;
    }

    public void forwardmssg (Message x) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("forward.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        forwardcont forwardcont = fxmlLoader.getController();
        forwardcont.forwardcont(dataBase,user,this,scene,x,stage);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List1.getItems().clear();
        List2.getItems().clear();
        try {
            Sort_Group_Chats_with_time();
            Sort_Pv_Chats_with_time();
            List1.getItems().addAll(user.getMy_Privete_Chat());
            List2.getItems().addAll(user.getMy_Group_Chat());
        }
        catch (NullPointerException ignored){};
        edit.setText("Edit/Caption");
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                edit(Listchat.getSelectionModel().getSelectedItem());
            }
        });

        delete.setText("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                delete(Listchat.getSelectionModel().getSelectedItem());
            }
        });
        reply.setText("Reply");
        reply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                replyselect(Listchat.getSelectionModel().getSelectedItem());
            }
        });

        forward.setText("Forward");
        forward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    forwardmssg(Listchat.getSelectionModel().getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        contextMenu.getItems().addAll(edit,delete,reply,forward);

        Listchat.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>() {
            @Override
            public ListCell<Message> call(ListView<Message> messageListView) {
                return new chatshow();
            }
        });

        List1.setCellFactory(new Callback<ListView<PV_Chat>, ListCell<PV_Chat>>() {
            @Override
            public ListCell<PV_Chat> call(ListView<PV_Chat> pv_chatListView) {
                return new List1show();
            }
        });

        List2.setCellFactory(new Callback<ListView<Group_Chat>, ListCell<Group_Chat>>() {
            @Override
            public ListCell<Group_Chat> call(ListView<Group_Chat> group_chatListView) {
                return new List2show();
            }
        });


        porg.setItems(FXCollections.observableList(Arrays.stream(pvorgroup).toList()));

        List1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PV_Chat>() {
            @Override
            public void changed(ObservableValue<? extends PV_Chat> observableValue, PV_Chat pv_chat, PV_Chat t1) {

                selectedpv = List1.getSelectionModel().getSelectedItem();
                Listchat.getItems().clear();
                Listchat.getItems().addAll(selectedpv.getMessages());

            }
        });

        List2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group_Chat>() {
            @Override
            public void changed(ObservableValue<? extends Group_Chat> observableValue, Group_Chat group_chat, Group_Chat t1) {
                selectedgr = List2.getSelectionModel().getSelectedItem();
                Listchat.getItems().clear();
                Listchat.getItems().addAll(selectedgr.getMessages());
            }
        });

        Listchat.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Message>() {

            @Override
            public void changed(ObservableValue<? extends Message> observableValue, Message message, Message t1) {

                setSelmessage(Listchat.getSelectionModel().getSelectedItem());

                Listchat.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
                    @Override
                    public void handle(ContextMenuEvent event) {
                        contextMenu.show(Listchat.getScene().getWindow(),event.getScreenX(),event.getScreenY());
                        Listchat.getSelectionModel().getSelectedIndices().clear();
                    }
                });
            }
        });
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



    public Message getSelmessage() {
        return selmessage;
    }

    public void setSelmessage(Message selmessage) {
        this.selmessage = selmessage;
    }

    public void Back() {
        firstMenu.Back();
    }

    public void back() {
        stage.setScene(scene);
    }

    class chatshow extends ListCell<Message> {

    VBox vbox = new VBox();
    ImageView imgview = new ImageView();
    Label label = new Label();
    Pane pane = new Pane();



    public chatshow() {
        super();
        VBox.setVgrow(pane,Priority.ALWAYS);
        vbox.getChildren().addAll(imgview,label,pane);
    }


    @Override
    public void updateItem(Message mssg , boolean empty) {

        super.updateItem(mssg, empty);

        label.setText(null);
        imgview.setImage(null);
        setText(null);
        setGraphic(null);

       if (!empty && mssg != null) {
            setText(null);
            label.setText(mssg.getText());
            imgview.setImage(mssg.getImage());
            if (mssg.getImage() != null) {
                double cons = (mssg.getImage().getHeight() / mssg.getImage().getWidth());
                imgview.setFitWidth(300);
                imgview.setFitHeight(300.0 * cons);
            }
            setGraphic(vbox);
       }
    }
}

    class List1show extends ListCell<PV_Chat> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List1show() {
            super();
            hBox.getChildren().addAll(imgview,pane);
            HBox.setHgrow(pane,Priority.ALWAYS);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
        }


        @Override
        public void updateItem(PV_Chat pv , boolean empty) {

            super.updateItem(pv, empty);

            if (empty || pv == null){
                setText(null);
                setGraphic(null);
            }

            else {
                setText(user.oppuser(pv).getUser_Name());
                imgview.setImage(user.oppuser(pv).getProfile_Image());
                setGraphic(hBox);
            }

        }
    }

    class List2show extends ListCell<Group_Chat> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List2show() {
            super();
            hBox.getChildren().addAll(imgview,pane);
            HBox.setHgrow(pane,Priority.ALWAYS);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
        }


        @Override
        public void updateItem(Group_Chat gr, boolean empty) {

            super.updateItem(gr, empty);

            if (empty || gr == null){
                setText(null);
                setGraphic(null);
            }

            else {
                setText(gr.getGroupName());
                imgview.setImage(gr.getImage());
                setGraphic(hBox);
            }

        }
    }
}
