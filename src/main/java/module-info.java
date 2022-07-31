module com.example.try1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.commons.lang3;


    opens com.example.try1 to javafx.fxml;
    exports com.example.try1;
    exports com.example.try1.Login;
    exports com.example.try1.oop;
    opens com.example.try1.Login to javafx.fxml;
}