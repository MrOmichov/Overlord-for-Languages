package org.mromichov.overlordforlanguages;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.charset.Charset;

public class HelloController {
    private final ContentEditor contentEditor;
    @FXML
    private VBox container;
    @FXML
    private TextArea input;
    @FXML
    private GridPane gridContainer;

    public HelloController() {
        this.contentEditor = new ContentEditor();
    }

    @FXML
    protected void onAlphabetButtonClick() {
        // как ужасно тут написано, но оно работает
        if (contentEditor.isBottomContainerShown) gridContainer.getChildren().remove(gridContainer.getChildren().remove(3));
        gridContainer.add(contentEditor.addOuterBottomContainer("Alphabet", gridContainer), 0, 2, 2, 1);
        contentEditor.isBottomContainerShown = true;
    }

    @FXML
    protected void onDictionaryButtonClick() {
        // как ужасно тут написано, но оно работает
        if (contentEditor.isBottomContainerShown) gridContainer.getChildren().remove(gridContainer.getChildren().remove(3));
        gridContainer.add(contentEditor.addOuterBottomContainer("Dictionary", gridContainer), 0, 2, 2, 1);
        contentEditor.isBottomContainerShown = true;
    }

    @FXML
    protected void onOpenFileButtonClick() {
        contentEditor.openFile(container);
        contentEditor.rebuild(gridContainer);
    }

    @FXML
    protected void onNewFileButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("newFile.fxml"));

        NewFileWindowController newFileWindowController = new NewFileWindowController();
        fxmlLoader.setController(newFileWindowController);

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("New File");
        stage.setAlwaysOnTop(true);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();

        // TODO
        System.out.println(newFileWindowController.getDirectoryPathname());
    }

    @FXML
    protected void onSaveFileButtonClick() {

    }

    @FXML
    protected void onQuitButtonClick() {

    }

    @FXML
    public void onStart() {
        container.getStyleClass().add("container");
        contentEditor.rebuild(gridContainer);
    }
}