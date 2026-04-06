package org.example.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.login.model.Admin;
import org.example.login.model.Trabajador;
import org.example.login.model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private Label labelPass;

    @FXML
    private Label labelUsuario;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField textUsuario;

    private GestorController gestorController;

    private TrabajadorController trabajadorController;

    public void setGestorController(GestorController gestorController) {
        this.gestorController = gestorController;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(gestorController==null){
            gestorController = new GestorController();
        }
        actions();
    }

    private void actions() {
        btnLogin.setOnAction(event -> {
            Usuario usuario = gestorController.verificarLogin(textUsuario.getText(), pass.getText());
           if (usuario instanceof Admin){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/login/admin-view.fxml"));
               Scene scene;
               try {
                   scene = new Scene(loader.load());
                   AdminController adminController = loader.getController();
                   adminController.setGestorController(gestorController);
                   Stage stage = (Stage) btnLogin.getScene().getWindow();
                   stage.setScene(scene);
               } catch (IOException e) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText(e.getMessage());
               }

           } else if (usuario instanceof Trabajador) {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/login/trabajador-view.fxml"));
               Scene scene;
               try {
                   scene = new Scene(loader.load());
                   TrabajadorController trabajadorController = loader.getController();
                   trabajadorController.setUsuario(usuario);
                   trabajadorController.setGestorController(gestorController);
                   Stage stage = (Stage) btnLogin.getScene().getWindow();
                   stage.setScene(scene);
               } catch (IOException e) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error");
                   alert.setHeaderText(e.getMessage());
               }

           } else  {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error");
               alert.setHeaderText("Usuario no encontrado");
               alert.show();
           }

        });
    }
}

