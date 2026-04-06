package org.example.login.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.login.model.Trabajador;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private Button btnAlta;

    @FXML
    private Button btnBaja;

    @FXML
    private Button btnCambiarPass;

    @FXML
    private Button btnMenuAlta;

    @FXML
    private Button btnMenuBaja;

    @FXML
    private Button btnMenuRegistros;

    @FXML
    private Button btnMenuTrabajadores;

    @FXML
    private Button btnMenuVerDatos;

    @FXML
    private Button btnVerDatos;

    @FXML
    private TableColumn<Trabajador, String> colTrabajadores;

    @FXML
    private TableView<Trabajador> tablaTrabajadores;

    private ObservableList<Trabajador> listaTrabajadores;

    @FXML
    private TextField textAltaApellido;

    @FXML
    private TextField textAltaCorreo;

    @FXML
    private TextField textAltaDNI;

    @FXML
    private TextField textAltaNombre;

    @FXML
    private TextField textAltaPass;

    @FXML
    private TextField textBajaDNI;

    @FXML
    private TextField textDatosDNI;

    @FXML
    private TextArea textRegistros;

    @FXML
    private VBox vboxAlta;

    @FXML
    private VBox vboxBaja;

    @FXML
    private VBox vboxRegistros;

    @FXML
    private VBox vboxTrabajadores;

    @FXML
    private VBox vboxVerDatos;

    @FXML
    private Button btnAtras;

    private GestorController gestorController;

    public void setGestorController(GestorController gestorController) {
        this.gestorController = gestorController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ocultarPaneles();
        clearFields();
        actions();
        initGUI();
    }

    private void initGUI() {
        listaTrabajadores = FXCollections.observableArrayList();
        tablaTrabajadores.setItems(listaTrabajadores);
        colTrabajadores.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    }

    private void clearFields() {
        textAltaNombre.clear();
        textAltaApellido.clear();
        textAltaCorreo.clear();
        textAltaDNI.clear();
        textAltaPass.clear();
    }

    private void actions() {
        btnMenuAlta.setOnAction(e -> {
           ocultarPaneles();
           vboxAlta.setVisible(true);
        });
        btnMenuBaja.setOnAction(e -> {
            ocultarPaneles();
            vboxBaja.setVisible(true);
        });
        btnMenuVerDatos.setOnAction(e -> {
            ocultarPaneles();
            vboxVerDatos.setVisible(true);
        });
        btnMenuTrabajadores.setOnAction(e -> {
            ocultarPaneles();
            vboxTrabajadores.setVisible(true);
            listaTrabajadores.clear();
            listaTrabajadores.addAll(gestorController.verTrabajadores());
        });
        btnMenuRegistros.setOnAction(e -> {
            ocultarPaneles();
            vboxRegistros.setVisible(true);
            textRegistros.setText(gestorController.leerFichero());

        });
        btnAlta.setOnAction(e -> {
            if (gestorController.altaTrabajador(textAltaNombre.getText(), textAltaApellido.getText(), textAltaDNI.getText(), textAltaCorreo.getText(), textAltaPass.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro de alta");
                alert.setHeaderText("Alta correcta");
                alert.show();
                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error en el proceso de alta");
                alert.setContentText("El trabajador ya existe");
                alert.show();
            }
        });
        btnBaja.setOnAction(e -> {
            if (gestorController.bajaTrabajador(textBajaDNI.getText())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro de baja");
                alert.setHeaderText("Baja correcta");
                alert.show();
                clearFields();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error en el proceso de baja");
                alert.setContentText("El trabajador no existe");
                alert.show();
            }
        });
        btnVerDatos.setOnAction(e -> {
            Trabajador trabajador = (Trabajador) gestorController.verDatos(textDatosDNI.getText());
            if (trabajador != null){
                Alert alert =  new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Datos trabajador DNI "+textDatosDNI.getText());
                alert.setHeaderText("Nombre: "+trabajador.getNombre());
                alert.setContentText("Apellido: "+trabajador.getApellido()+
                        "\nDNI: "+trabajador.getDni()+
                        "\nCorreo: "+trabajador.getCorreo()+
                        "\nContraseña: "+trabajador.getPass());
                alert.show();
                clearFields();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("El trabajador no existe");
                alert.show();
            }
        });
        btnCambiarPass.setOnAction(e -> {
            Trabajador trabajadorSeleccionado = (Trabajador) tablaTrabajadores.getSelectionModel().getSelectedItem();
            if (trabajadorSeleccionado != null){
                TextInputDialog textInputDialog = new TextInputDialog();
                textInputDialog.setTitle("Modificar contraseña");
                textInputDialog.setHeaderText("Nueva contraseña");
                textInputDialog.showAndWait().ifPresent(nuevaPass ->
                {
                    if (gestorController.cambiarPassword(trabajadorSeleccionado.getDni(), nuevaPass)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Modificar contraseña");
                        alert.setHeaderText("Contraseña cambiada correctamente");
                    }else  {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("No se pudo modificar la contraseña");
                    }
                });
            } else  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Seleccione un trabajador para modificar su contraseña");
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

    private void ocultarPaneles() {
        vboxAlta.setVisible(false);
        vboxBaja.setVisible(false);
        vboxVerDatos.setVisible(false);
        vboxTrabajadores.setVisible(false);
        vboxRegistros.setVisible(false);

    }

}
