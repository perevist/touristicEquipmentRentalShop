package com.projectIO.touristicEquipmentRentalShop.gui;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class ScreenManager {
    private HashMap<String, Pane> screenMap;
    private Scene mainScene;

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

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void addScreen(String name, Pane pane) {
        screenMap.put(name, pane);
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        Pane pane = screenMap.get(name);
        mainScene.setRoot(screenMap.get(name));
    }
}
