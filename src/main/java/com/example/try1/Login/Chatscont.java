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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
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
import java.util.concurrent.TimeUnit;

public class Chatscont implements Initializable {

    public ListView<PV_Chat> List1;
    public ListView<Group_Chat> List2;
    public ListView<Message> Listchat;
    public ChoiceBox<String> porg;
    public Button send;
    public TextArea mssgtext;
    public Button editbutton;
    public Button cancelreply;
    public Text replymassage;
    public Rectangle rect;
    public AnchorPane Anchorpane;
    public javafx.scene.control.Button Button;
    public javafx.scene.control.Button Button1;
    public javafx.scene.control.Button newpv;
    public javafx.scene.control.Button newgroup;
    public Button settbutton;
    public Label error;
    public Button delerror;

    public void Chatscont(DataBase dataBase, User user, FirstMenu firstMenu, Scene scene , Stage stage , boolean Dark_Mod) {
        Chatscont.stage = stage;
        this.dataBase = dataBase;
        this.user = user;
        this.firstMenu = firstMenu;
        this.scene = scene;
        editbutton.setVisible(false);
        popdown();
        errorpopdown();
        reflists();
        List2.setVisible(false);
        List1.setVisible(true);
        mssgtext.setWrapText(true);

        this.pv_chats = user.getMy_Privete_Chat();
        this.group_chats = user.getMy_Group_Chat();

        replyrun = false;
        this.Dark_Mod = Dark_Mod;

        Listchat.getStylesheets().add(String.valueOf(getClass().getResource("chatstyle.css")));
        List1.getStylesheets().add(String.valueOf(getClass().getResource("chatstyle.css")));
        List2.getStylesheets().add(String.valueOf(getClass().getResource("chatstyle.css")));
        mssgtext.getStylesheets().add(String.valueOf(getClass().getResource("chatstyle.css")));




        if (Dark_Mod) {
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            Button.setStyle("-fx-background-color: #6F2232;");
            Button.setTextFill(Paint.valueOf("WHITE"));
            Button1.setStyle("-fx-background-color: #6F2232;");
            Button1.setTextFill(Paint.valueOf("WHITE"));
            send.setStyle("-fx-background-color: #6F2232;");
            send.setTextFill(Paint.valueOf("WHITE"));
            editbutton.setStyle("-fx-background-color: #6F2232;");
            editbutton.setTextFill(Paint.valueOf("WHITE"));
            cancelreply.setStyle("-fx-background-color: #6F2232;");
            cancelreply.setTextFill(Paint.valueOf("WHITE"));
            newpv.setStyle("-fx-background-color: #6F2232;");
            newpv.setTextFill(Paint.valueOf("WHITE"));
            newgroup.setStyle("-fx-background-color: #6F2232;");
            newgroup.setTextFill(Paint.valueOf("WHITE"));
            Listchat.setStyle("-fx-background-color: #E7717D;");
            List1.setStyle("-fx-background-color: #E9E9EB ;\n" +
                    "-fx-background-radius: 5; \n " +
                    "-fx-border-radius: 5; \n" +
                    "-fx-border-color: #ffffff;");
            List2.setStyle("-fx-background-color: #E9E9EB;");
            porg.setStyle("-fx-background-color: #E7717D;");
            mssgtext.setStyle("-fx-background-color: #950740;");
            replymassage.setStyle("-fx-background-color: #950740;");
            settbutton.setStyle("-fx-background-color: transparent; \n");
        }
        else {
            Anchorpane.setStyle("-fx-background-color: #EEE2DC;");
            Button.setStyle("-fx-background-color: #EDC7B7;");
            Button.setTextFill(Paint.valueOf("#AC3B61"));
            Button1.setStyle("-fx-background-color: #EDC7B7;");
            Button1.setTextFill(Paint.valueOf("#AC3B61"));
            send.setStyle("-fx-background-color: #EDC7B7;");
            send.setTextFill(Paint.valueOf("#AC3B61"));
            editbutton.setStyle("-fx-background-color: #EDC7B7;");
            editbutton.setTextFill(Paint.valueOf("#AC3B61"));
            cancelreply.setStyle("-fx-background-color: #EDC7B7;");
            cancelreply.setTextFill(Paint.valueOf("#AC3B61"));
            newpv.setStyle("-fx-background-color: #EDC7B7;");
            newpv.setTextFill(Paint.valueOf("#AC3B61"));
            newgroup.setStyle("-fx-background-color: #EDC7B7;");
            newgroup.setTextFill(Paint.valueOf("#AC3B61"));
            Listchat.setStyle("-fx-background-color: #E7717D;");
            List1.setStyle("-fx-background-color: #E7717D;");
            List2.setStyle("-fx-background-color: #E7717D;");
            porg.setStyle("-fx-background-color: #E7717D;");
            mssgtext.setStyle("-fx-background-color: #950740;");
            replymassage.setStyle("-fx-background-color: #950740;");
        }

    }


    private DataBase dataBase;
    private User user;
    private FirstMenu firstMenu;
    private static Stage stage;
    private Scene scene;
    private boolean Dark_Mod;

    private ArrayList<PV_Chat> pv_chats ;
    private ArrayList<Group_Chat> group_chats ;
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

    final String replypart = "Reply to : ";
    final String forwardedpart = " ( Forwarded from ";

    public void Sort_Pv_Chats_with_time(){

        quickSort(pv_chats,0,pv_chats.size()-1);

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

    public void errorpopup (String x){
        error.setText(x);
        delerror.setVisible(true);
    }

    public void errorpopdown () {
        error.setText("");
        delerror.setVisible(false);
    }

    public void choose () {
        if (porg.getValue().equals("pv chats")){
            pvorgr = false;
            List1.getItems().clear();
            Sort_Pv_Chats_with_time();
            List1.getItems().addAll(pv_chats);
            List1.setVisible(true);
            List2.setVisible(false);
            Listchat.getItems().clear();
        }
        else {
            pvorgr = true;
            List2.getItems().clear();
            Sort_Group_Chats_with_time();
            List2.getItems().addAll(group_chats);
            List2.setVisible(true);
            List1.setVisible(false);
            Listchat.getItems().clear();
        }
    }


    public void Sort_Group_Chats_with_time(){

        quickSorT(group_chats,0,group_chats.size()-1);

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


    public void gotosetting () throws IOException {
        if (pvorgr) {
            if (user == selectedgr.getAdmin()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminview.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 600);
                stage.setScene(scene);
                adminviewcont adminviewcont = fxmlLoader.getController();
                adminviewcont.adminviewcont(dataBase, user, scene, Dark_Mod, selectedgr, this, stage);
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("memberview.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 600);
                stage.setScene(scene);
                memberviewcont memberviewcont = fxmlLoader.getController();
                memberviewcont.memberviewcont(dataBase, user, scene, Dark_Mod, selectedgr, this, stage);
            }
        }
    }





    public void createnewpv() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newpvchat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        newpvchatcont newpvchatcont = fxmlLoader.getController();
        newpvchatcont.newpvchatcont(dataBase,user,this,scene,stage,Dark_Mod);
    }

    public void createnewgr() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newgroupchat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),900,600);
        stage.setScene(scene);
        newgroupchatcont newgroupchatcont = fxmlLoader.getController();
        newgroupchatcont.newgroupchatcont(dataBase,user,this,scene,stage,Dark_Mod);
    }

    public void sendmassage () {

        if (pvorgr && selectedgr.getBanned().contains(user)){
            errorpopup("You are banned");
            textmssg = "";
            mssgtext.setText("");
            return;
        }
        if (replyrun) {
            textmssg = mssgtext.getText();
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

        if (pvorgr && selectedgr.getBanned().contains(user)){
            errorpopup("You are banned");
            textmssg = "";
            mssgtext.setText("");
            return;
        }

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
        forwardcont.forwardcont(dataBase,user,this,scene,x,stage,Dark_Mod);
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        edit.setText("Edit/Caption");
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (user == getSelmessage().getSender()) {
                    edit(Listchat.getSelectionModel().getSelectedItem());
                }
                else {
                    errorpopup("You can only edit your own messages!");
                }
                if (getSelmessage().getForwarded() != null){
                    errorpopup("You can't edit a forwarded message!");
                }
            }
        });

        delete.setText("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (user == getSelmessage().getSender()) {
                    delete(Listchat.getSelectionModel().getSelectedItem());
                }
                else {
                    errorpopup("You can only delete you own messages!");
                }
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
                if (selectedpv != null) {
                    Listchat.getItems().addAll(selectedpv.getMessages());
                    selectedpv.Seen_ALl(user);
                }

            }
        });

        List2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group_Chat>() {
            @Override
            public void changed(ObservableValue<? extends Group_Chat> observableValue, Group_Chat group_chat, Group_Chat t1) {
                selectedgr = List2.getSelectionModel().getSelectedItem();
                Listchat.getItems().clear();
                if (selectedgr != null) {
                    Listchat.getItems().addAll(selectedgr.getMessages());
                    selectedgr.Seen_ALl(user);
                }
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

    VBox vbox2 = new VBox();
    VBox vbox3 = new VBox();
    VBox vbox1 = new VBox();
    HBox hBox = new HBox();
    Label replyto = new Label();
    ImageView imgview = new ImageView();
    Label text = new Label();
    Label sender = new Label();
    Label time = new Label();
    HBox timeshow = new HBox();
    Pane pane = new Pane();
    Pane pane1 = new Pane();
    Circle circle = new Circle(15);



    public chatshow() {
        super();
        VBox.setVgrow(pane,Priority.ALWAYS);
        timeshow.getChildren().add(time);
        time.setStyle("-fx-font-size: 10");
        time.setTextFill(Color.rgb(237,199,183));
        vbox2.getChildren().addAll(sender,imgview,text,pane,timeshow);
        vbox2.setMaxWidth(300);
        vbox3.getChildren().addAll(replyto);
        vbox1.getChildren().addAll(circle);
        text.setTextFill(Color.WHITE);
        sender.setStyle("-fx-font-weight: bold");
        sender.setTextFill(Color.WHITE);
        HBox.setHgrow(pane1,Priority.ALWAYS);
        hBox.setSpacing(5);
        replyto.setTextFill(Color.WHITE);
        this.getStylesheets().add(String.valueOf(getClass().getResource("chatstyle.css")));
    }


    @Override
    public void updateItem(Message mssg , boolean empty) {

        super.updateItem(mssg, empty);

        text.setText(null);
        sender.setText(null);
        imgview.setImage(null);
        replyto.setText(null);
        time.setText(null);
        setGraphic(null);

        replyto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Listchat.getSelectionModel().select(mssg.getReply());
            }
        });

       if (!empty && mssg != null) {
            text.setText(mssg.getText());
            text.setWrapText(true);
            circle.setFill(new ImagePattern(mssg.getSender().getProfile_Image()));
            if (mssg.getForwarded() == null) {
                sender.setText(mssg.getSender().getUser_Name());
            }
            else {
                sender.setText(mssg.getSender().getUser_Name() + forwardedpart
                        + mssg.getForwarded().getUser_Name() + " )" );
            }


            if (mssg.getReply() != null) {

                if (mssg.getText() == null){
                    replyto.setText("| " + replypart + "IMAGE" + " |");
                }
                else {
                    if (mssg.getReply().getText().length() > 10) {
                        replyto.setText("| " + replypart + mssg.getReply().getText().substring(0, 10) + "..." + " |");
                    } else {
                        replyto.setText("| " + replypart + mssg.getReply().getText() + " |");
                    }
                }
            }


            imgview.setImage(mssg.getImage());
            if (mssg.getImage() != null) {
                double cons = (mssg.getImage().getHeight() / mssg.getImage().getWidth());
                imgview.setFitWidth(300);
                imgview.setFitHeight(300.0 * cons);
            }
            else {
                imgview.setFitWidth(0);
                imgview.setFitHeight(0);
            }

            if (getUser() != mssg.getSender()) {
                hBox.getChildren().clear();
                hBox.getChildren().addAll(pane1,vbox3,vbox2,vbox1);
                vbox1.setAlignment(Pos.BASELINE_CENTER);
                vbox3.setAlignment(Pos.CENTER_LEFT);
                timeshow.setAlignment(Pos.CENTER_LEFT);
                vbox2.setStyle("-fx-background-color: #6F2232;\n"+
                        "-fx-border-color: #6F2232 ;\n" +
                        "-fx-border-style: solid;\n " +
                        "-fx-background-radius: 5; \n" +
                        "-fx-border-radius: 5; \n " +
                        "-fx-border-width: 5" );
            }
            else {
                hBox.getChildren().clear();
                hBox.getChildren().addAll(vbox1,vbox2,vbox3,pane1);
                timeshow.setAlignment(Pos.CENTER_LEFT);
                timeshow.setAlignment(Pos.CENTER_RIGHT);
                //vbox.setBackground(new Background(new BackgroundFill(Color.ORANGE , CornerRadii.EMPTY, Insets.EMPTY)));
                vbox2.setStyle("-fx-background-color: #C3073F ;\n"+
                              "-fx-border-color: #C3073F ;\n" +
                              "-fx-border-style: solid;\n " +
                              "-fx-background-radius: 5; \n" +
                              "-fx-border-radius: 5; \n " +
                              "-fx-border-width: 5" );
            }

            time.setText(mssg.getCreat_time_our().toString().substring(0,5));

            setGraphic(hBox);
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
            this.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        }


        @Override
        public void updateItem(PV_Chat pv , boolean empty) {

            super.updateItem(pv, empty);

            if (empty || pv == null){
                setText(null);
                setGraphic(null);
            }

            else {
                if (pv.How_many_Message_not_see(user)!=0) {
                    setText(user.oppuser(pv).getUser_Name() + "(" + pv.How_many_Message_not_see(user) + ")");
                }
                else {
                    setText(user.oppuser(pv).getUser_Name());
                }
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
            this.setStyle("-fx-background-color: transparent;");
        }


        @Override
        public void updateItem(Group_Chat gr, boolean empty) {

            super.updateItem(gr, empty);

            if (empty || gr == null){
                setText(null);
                imgview.setImage(null);
                setGraphic(null);
            }

            else {
                if (gr.How_many_Message_not_see(user)!=0) {
                    setText(gr.getGroupName() + "(" + gr.How_many_Message_not_see(user) + ")");
                }
                else {
                    setText(gr.getGroupName());
                }
                imgview.setImage(gr.getImage());
                setGraphic(hBox);
            }

        }
    }

    public void reflists(){
        List1.getItems().clear();
        List1.getItems().addAll(user.getMy_Privete_Chat());
        List2.getItems().clear();
        List2.getItems().addAll(user.getMy_Group_Chat());
    }

}
