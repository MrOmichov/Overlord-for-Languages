package org.mromichov.overlordforlanguages;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button alphabetButton;
    @FXML
    private Button dictionaryButton;
    @FXML
    private FlowPane bottomContainer;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onAlphabetButtonClick() {
        String text = alphabetButton.getText().equals("Hello world!") ? "Alphabet" : "Hello world!";
        alphabetButton.setText(text);
    }
}