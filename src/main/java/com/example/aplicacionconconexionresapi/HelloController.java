package com.example.aplicacionconconexionresapi;

import com.example.aplicacionconconexionresapi.dao.APIClient;
import com.example.aplicacionconconexionresapi.dao.GasolineraDAORest;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        GasolineraDAORest d = new GasolineraDAORest();
        welcomeText.setText("Welcome to JavaFX Application!");
        d.start();
        System.out.println();

    }
}