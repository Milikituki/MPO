package org.example.login.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.login.model.Trabajador;
import org.example.login.model.Usuario;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TrabajadorController implements Initializable {


    @FXML
    private Button btnAtras;

    @FXML
    private Button btnFichar;

    @FXML
    private Text textUsuario;

    private Usuario usuario;

    private GestorController gestorController;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        textUsuario.setText("Nuevo fichaje para "+usuario.getNombre().toUpperCase());
    }
    public void setGestorController(GestorController gestorController) {
        this.gestorController = gestorController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        btnFichar.setOnAction(e -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.now();
            String fechaHora = fecha.format(dtf);
            try (PrintWriter pw = new PrintWriter(new FileWriter("horas.txt", true))){
                pw.println(usuario.getCorreo()+" - "+fechaHora);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fichaje correcto");
                alert.setHeaderText("Fichaje correcto");
                alert.show();
            } catch (FileNotFoundException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Fichero no encontrado");
                alert.show();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(ex.getMessage());
                alert.show();
            }
        });
        btnAtras.setOnAction(e -> {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/login/login-view.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                LoginController loginController = loader.getController();
                loginController.setGestorController(gestorController);
                Stage stage = (Stage) btnAtras.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

}
