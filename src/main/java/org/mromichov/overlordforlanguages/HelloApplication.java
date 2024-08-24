
package org.mromichov.overlordforlanguages;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

//    private VBox createContent() {
//        VBox vbox = new VBox();
//        GridPane gp = new GridPane();
//
//        // grid settings
//        ColumnConstraints column = new ColumnConstraints();
//        column.setPercentWidth(50);
//        gp.getColumnConstraints().add(column);
//        gp.getColumnConstraints().add(column);
//
//        RowConstraints row20 = new RowConstraints();
//        RowConstraints row60 = new RowConstraints();
//        row20.setPercentHeight(20);
//        row60.setPercentHeight(60);
//        gp.getRowConstraints().add(row20);
//        gp.getRowConstraints().add(row20);
//        gp.getRowConstraints().add(row60);
//
//        gp.setHgap(15);
//        gp.setPadding(new Insets(15));
//
//        // TextArea input
//        TextArea input = new TextArea("Hello World!");
//        input.setWrapText(true);
//
//        // Button alphabetButton
//        Button alphabetButton = new Button("Alphabet");
//        alphabetButton.setId("alphabetButton");
//        alphabetButton.setOnAction(event -> {
//            String text = alphabetButton.getText().equals("Hello world!") ? "Alphabet" : "Hello world!";
//            alphabetButton.setText(text);
//        });
//        GridPane.setHalignment(alphabetButton, HPos.CENTER);
//        GridPane.setValignment(alphabetButton, VPos.TOP);
//        alphabetButton.setMaxWidth(Double.MAX_VALUE);
//        GridPane.setHgrow(alphabetButton, Priority.ALWAYS);
//
//        // Button dictionaryButton
//        Button dictionaryButton = new Button("Dictionary");
//        dictionaryButton.setId("dictionaryButton");
//        GridPane.setHalignment(dictionaryButton, HPos.CENTER);
//        GridPane.setValignment(dictionaryButton, VPos.TOP);
//        dictionaryButton.setMaxWidth(Double.MAX_VALUE);
//        GridPane.setHgrow(dictionaryButton, Priority.ALWAYS);
//
//        FlowPane fp = new FlowPane();
//        Label label = new Label("Hello world!");
//        Label label1 = new Label("Hello world!");
//        Label label2 = new Label("Hello world!");
//        fp.getChildren().addAll(label, label1, label2);
//
//        // add elements to grid
//        gp.add(input, 0, 0, 1, 2);
//        gp.add(alphabetButton, 1, 0);
//        gp.add(dictionaryButton, 1, 1);
//        gp.add(fp, 0, 2, 2, 1);
//
//        VBox.setVgrow(gp, Priority.ALWAYS);
//        vbox.getChildren().add(gp);
//        return vbox;
//    }
}