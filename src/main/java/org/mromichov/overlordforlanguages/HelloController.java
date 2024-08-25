package org.mromichov.overlordforlanguages;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HelloController {
    private final ContentEditor contentEditor;
    @FXML
    private VBox container;
    @FXML
    private TextArea input;
    @FXML
    private GridPane gridContainer;
    @FXML
    private Button alphabetButton;

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
        contentEditor.rebuild(input, gridContainer);
    }

    @FXML
    public void onStart() {
        input.setText("AAA");
        container.getStyleClass().add("container");
    }
}