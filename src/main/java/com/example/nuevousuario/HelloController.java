package com.example.nuevousuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private TextField correoField;

    @FXML
    private ComboBox<String> PaisComboBox;

    @FXML
    private ComboBox<String> plataformaComboBox;

    @FXML
    private Button confirmarButton;

    @FXML
    private Button guardarButton;

    @FXML
    private Button volverButton;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> correoColumn;

    @FXML
    private TableColumn<User, String> paisColumn;

    @FXML
    private TableColumn<User, String> plataformaColumn;

    private ObservableList<User> userList;
    private TableColumn<Object, Object> paisColumnColumn;

    @FXML
    public void inicializar() {
        userList = FXCollections.observableArrayList();
        userTable.setItems(userList);

        correoColumn.setCellValueFactory(new PropertyValueFactory<>("correo"));
        paisColumnColumn.setCellValueFactory(new PropertyValueFactory<>("Pais"));
        plataformaColumn.setCellValueFactory(new PropertyValueFactory<>("plataforma"));

        paisColumnColumn.setText(FXCollections.observableArrayList( "España", "Argentina", "Italia", "Francia").toString());
        plataformaComboBox.setItems(FXCollections.observableArrayList("Escritorio", "Móvil", "Desconocido"));

        confirmarButton.setOnAction(event -> addUser());
        guardarButton.setOnAction(event -> saveData());
        volverButton.setOnAction(event -> goBack());
    }

    private void addUser() {
        String email = correoField.getText();
        String country = PaisComboBox.getValue();
        String platform = plataformaComboBox.getValue();

        if (email != null && !email.isEmpty() && country != null && platform != null) {
            var user = new User(email, country, platform);

            userList.add(user);

            correoField.clear();
            paisColumn.setStyle(null);
            plataformaComboBox.setStyle(null);
        } else {
            System.out.println("Completa todos los campos.");
        }
    }

    private void saveData() {
        System.out.println("se han guardado los datos.");
    }
    private void goBack() {
        Stage stage = (Stage) volverButton.getScene().getWindow();
        stage.close();
    }
}
