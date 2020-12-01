package com.projectIO.touristicEquipmentRentalShop.gui.controllers;

import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectLoginException;
import com.projectIO.touristicEquipmentRentalShop.exceptions.IncorrectPasswordException;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.AlertWindow;
import com.projectIO.touristicEquipmentRentalShop.gui.helpers.ScreenManager;
import com.projectIO.touristicEquipmentRentalShop.model.UserType;
import com.projectIO.touristicEquipmentRentalShop.services.implementations.LoginServiceImpl;
import com.projectIO.touristicEquipmentRentalShop.services.interfaces.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements MainController, Initializable {

    private LoginService loginService;

    public LoginFormController() {
        loginService = new LoginServiceImpl();
    }

    @FXML
    private GridPane rootPane;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private BackgroundImage myBI= new BackgroundImage(new Image("/img/loginPageImg.jpg",1200,
            800,false,true), BackgroundRepeat.REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    @FXML
    void backToWelcomePage(ActionEvent event) {
        ScreenManager.getInstance().activate("welcomePage");
    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane.setBackground(new Background(myBI));
        UserType[] userTypes = UserType.values();
        List<String> options = new ArrayList<>();

        for (int i = 1; i < userTypes.length; i++) {
            options.add(userTypes[i].getName());
        }

        choiceBox.getItems().setAll(options);
    }

    @Override
    public void updateDataInView() {
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        if (!checkAreAllFieldsFilledIn()) {
            AlertWindow.showAlert(rootPane, "Błąd", "Proszę uzupełnić wszystkie pola");
            return;
        }

        try {
            loadDataFromFormAndLoginUser();
        } catch (IncorrectLoginException | IncorrectPasswordException exception) {
            AlertWindow.showAlert(rootPane, "Błąd", exception.getMessage());
            return;
        }

        AlertWindow.showAlert(rootPane, "Pomyślne logowanie", "Zalogowano do systemu");

        loadNewScene();
    }

    private boolean checkAreAllFieldsFilledIn() {
        if (loginField.getText().isEmpty() || passwordField.getText().isEmpty() || choiceBox.getValue() == null)
            return false;
        else
            return true;
    }

    private void loadDataFromFormAndLoginUser() {
        String login = loginField.getText();
        String password = passwordField.getText();
        UserType selectedUserType = getSelectedUserTypeFromChoiceBox();

        loginService.loginUser(login, password, selectedUserType);
    }

    private UserType getSelectedUserTypeFromChoiceBox() {
        String userTypeName = choiceBox.getValue();
        UserType[] allUserTypes = UserType.values();

        for (UserType userType : allUserTypes) {
            if (userType.getName().equals(userTypeName))
                return userType;
        }
        return null;
    }

    private void loadNewScene() throws IOException {
        UserType selectedUserType = getSelectedUserTypeFromChoiceBox();
        switch (selectedUserType) {
            case CUSTOMER:
                ScreenManager.getInstance().activate("customerPage");
                break;
            case EMPLOYEE:
                ScreenManager.getInstance().activate("employeePage");
                break;
            case ADMINISTRATOR:
                ScreenManager.getInstance().activate("administratorPage");
                break;
        }
    }
}