package com.projectIO.touristicEquipmentRentalShop.gui.helpers;

import javafx.stage.Stage;

import java.util.HashMap;

public class ScreenManager {
    private HashMap<String, AppScreen> screenMap;
    private Stage stage;

    private static ScreenManager instance;

    public static ScreenManager getInstance() {
        if(instance == null) {
            instance = new ScreenManager();
        }
        return instance;
    }

    private ScreenManager() {
        screenMap = new HashMap<>();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addScreen(String name, AppScreen appScreen) {
        screenMap.put(name, appScreen);
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        AppScreen appScreen = screenMap.get(name);
        appScreen.getMainController().updateDataInView();
        stage.setScene(appScreen.getScene());
    }
}
