module org.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.login to javafx.fxml;
    opens org.example.login.controller to javafx.fxml;
    opens org.example.login.model;
    exports org.example.login;
}