package com.example.try1.Login;

import com.example.try1.oop.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class forwardcont implements Initializable, Serializable {


    private DataBase dataBase;
    private User user;
    private Chatscont chatscont;
    private static Stage stage;
    private Scene scene;
    private Message message;

    public AnchorPane Anchorpane;
    public Button cancel;
    public ChoiceBox<String> choose;
    public TextField searchingbox;
    public ListView<User> List1;
    public ListView<Group_Chat> List2;
    public Label searchtext;
    public Label Text;

    static String[] choice = {"PV chats","Group chats"};
    public String textmssg;
    public ArrayList<User> resultpvchat = new ArrayList<>();
    public ArrayList<Group_Chat> resultgrchat = new ArrayList<>();
    public ArrayList<String> result = new ArrayList<>();
    boolean pvorgr;
    String selectedchat;
    public User selecteduser;
    public Group_Chat selectedgr;


    public void forwardcont(DataBase dataBase, User user, Chatscont chatscont, Scene scene, Message message , Stage stage , boolean Dark_Mod) {
        this.dataBase = dataBase;
        this.user = user;
        this.chatscont = chatscont;
        this.scene = scene;
        this.message = message;
        forwardcont.stage = stage;
        pvorgr = false;
        if (Dark_Mod){
            Anchorpane.setStyle("-fx-background-color: #1A1A1D;");
            cancel.setStyle("-fx-background-color: #6F2232;");
            cancel.setTextFill(Paint.valueOf("WHITE"));
            searchingbox.setStyle("-fx-background-color: #E7717D;");
            searchtext.setTextFill(Paint.valueOf("#950740"));
            Text.setTextFill(Paint.valueOf("#950740"));
            List1.setStyle("-fx-background-color: #E7717D;");
            List2.setStyle("-fx-background-color: #E7717D;");
            choose.setStyle("-fx-background-color: #E7717D;");
        }
        else {

        }
    }

    public void cancelfor () {
        chatscont.Back();
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

    public Chatscont getChatscont() {
        return chatscont;
    }

    public void setChatscont(Chatscont chatscont) {
        this.chatscont = chatscont;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        forwardcont.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ArrayList<User> getResultpvchat() {
        return resultpvchat;
    }

    public void setResultpvchat(ArrayList<User> resultpvchat) {
        this.resultpvchat = resultpvchat;
    }

    public ArrayList<Group_Chat> getResultgrchat() {
        return resultgrchat;
    }

    public void setResultgrchat(ArrayList<Group_Chat> resultgrchat) {
        this.resultgrchat = resultgrchat;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choose.getItems().addAll(choice);
        choose.setValue("PV chats");

        List1.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> pv_chatListView) {
                return new List3();
            }
        });

        List2.setCellFactory(new Callback<ListView<Group_Chat>, ListCell<Group_Chat>>() {
            @Override
            public ListCell<Group_Chat> call(ListView<Group_Chat> group_chatListView) {
                return new List2show();
            }
        });

        List1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user1, User t1) {

                selecteduser = List1.getSelectionModel().getSelectedItem();
                Message temp = null ;

                if (user.checkpvret(selecteduser) != null) {

                    if (message.getImage() != null && message.getForwarded() == null) {
                        temp = new Message(user, message.getText(), null,
                                message.getSender(), message.getImage().getUrl());
                    }
                    if (message.getImage() != null && message.getForwarded() != null) {
                        temp = new Message(user, message.getText(), null,
                                message.getForwarded(), message.getImage().getUrl());
                    }
                    if (message.getImage() == null && message.getForwarded() == null) {
                        temp = new Message(user , message.getText(), null,
                                message.getSender(), null);
                    }
                    if (message.getImage() == null && message.getForwarded() != null) {
                        temp = new Message(user, message.getText(), null,
                                message.getForwarded(), null);
                    }
                    user.checkpvret(selecteduser).getMessages().add(temp);


                } else {
                    user.createpvchat(selecteduser);
                    if (message.getImage() != null && message.getForwarded() == null) {
                        temp = new Message(user, message.getText(), null,
                                message.getSender(), message.getImage().getUrl());
                    }
                    if (message.getImage() != null && message.getForwarded() != null) {
                        temp = new Message(user, message.getText(), null,
                                message.getForwarded(), message.getImage().getUrl());
                    }
                    if (message.getImage() == null && message.getForwarded() == null) {
                        temp = new Message(user , message.getText(), null,
                                message.getSender(), null);
                    }
                    if (message.getImage() == null && message.getForwarded() != null) {
                        temp = new Message(user, message.getText(), null,
                                message.getForwarded(), null);
                    }
                    user.checkpvret(selecteduser).getMessages().add(temp);
                }
                chatscont.back();
            }
        });

        List2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group_Chat>() {
            @Override
            public void changed(ObservableValue<? extends Group_Chat> observableValue, Group_Chat group_chat1, Group_Chat t1) {

                selectedgr = List2.getSelectionModel().getSelectedItem();

                Message temp = null;
                if (message.getImage() != null && message.getForwarded()==null) {
                    temp = new Message(user, message.getText(), null,
                            message.getSender(), message.getImage().getUrl());
                }
                if (message.getImage() != null && message.getForwarded()!=null){
                    temp = new Message(user, message.getText(), null,
                            message.getForwarded(), message.getImage().getUrl());
                }
                if (message.getImage() == null && message.getForwarded()==null) {
                    temp = new Message(user, message.getText(), null,
                            message.getSender(), null);
                }
                if (message.getImage() == null && message.getForwarded()!=null){
                    temp = new Message(user, message.getText(), null,
                            message.getForwarded(),null);
                }
                selectedgr.getMessages().add(temp);
                chatscont.back();
            }
        });

    }

    public void searchbox() {
        textmssg = searchingbox.getText();
        if (!pvorgr) {
            setResultpvchat(user.searchfromfollow(textmssg));
            List1.getItems().clear();
            List1.getItems().addAll(getResultpvchat());
        }
    }

    public void recogchoose () {
        pvorgr = !choose.getValue().equals("PV chats");
        if (!pvorgr) {
            searchingbox.setVisible(true);
            searchtext.setVisible(true);
            List1.setVisible(true);
            List2.setVisible(false);
        }
        else {
            searchtext.setVisible(false);
            searchingbox.setVisible(false);
            List2.setVisible(true);
            List1.setVisible(false);
            List2.getItems().clear();
            List2.getItems().addAll(user.getMy_Group_Chat());
        }
    }


    class List3 extends ListCell<User> {

        HBox hBox = new HBox();
        ImageView imgview = new ImageView();
        Pane pane = new Pane();



        public List3() {
            super();
            hBox.getChildren().addAll(imgview,pane);
            HBox.setHgrow(pane, Priority.ALWAYS);
            imgview.setFitHeight(50);
            imgview.setFitWidth(50);
        }


        @Override
        public void updateItem(User user, boolean empty) {

            super.updateItem( user, empty);

            if (empty || user == null){
                setText(null);
                setGraphic(null);
            }

            else {
                setText(user.getUser_Name());
                imgview.setImage(user.getProfile_Image());
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
