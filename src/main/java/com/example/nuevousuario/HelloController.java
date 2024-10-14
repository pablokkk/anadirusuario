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
    private TextField emailField;

    @FXML
    private ComboBox<String> countryComboBox;

    @FXML
    private ComboBox<String> platformComboBox;

    @FXML
    private Button confirmButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> emailColumn;

    @FXML
    private TableColumn<User, String> countryColumn;

    @FXML
    private TableColumn<User, String> platformColumn;

    private ObservableList<User> userList;

    public HelloController(TextField emailField) {
        this.emailField = emailField;
    }

    @FXML
    public void inicializar() {
        userList = FXCollections.observableArrayList();
        userTable.setItems(userList);

        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        platformColumn.setCellValueFactory(new PropertyValueFactory<>("platform"));

        countryComboBox.setItems(FXCollections.observableArrayList("USA", "México", "España", "Argentina"));
        platformComboBox.setItems(FXCollections.observableArrayList("Windows", "Mac", "Linux"));

        confirmButton.setOnAction(event -> addUser());
        saveButton.setOnAction(event -> saveData());
        backButton.setOnAction(event -> goBack());
    }

    private void addUser() {
        String email = emailField.getText();
        String country = countryComboBox.getValue();
        String platform = platformComboBox.getValue();

        if (email != null && !email.isEmpty() && country != null && platform != null) {
            User user = new User(email, country, platform);

            userList.add(user);

            emailField.clear();
            countryComboBox.setValue(null);
            platformComboBox.setValue(null);
        } else {
            System.out.println("Por favor, completa todos los campos.");
        }
    }

    private void saveData() {
        System.out.println("Datos guardados.");
    }
    private void goBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
