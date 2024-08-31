package org.mromichov.overlordforlanguages;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import org.kordamp.ikonli.javafx.FontIcon;
import org.mromichov.overlordforlanguages.odm.FileWork;
import org.mromichov.overlordforlanguages.odm.Language;

import java.io.File;
import java.io.IOException;
import java.util.Collection;


public class ContentEditor {
    private String headerBottomContainer;
    public boolean isBottomContainerShown;

    private final FileWork fileWorker;
    private Language language;

    public ContentEditor() {
        this.fileWorker = new FileWork();
        if (!fileWorker.isSettingsFileExists()) fileWorker.createSettingsFile();
        language = fileWorker.getLanguage();
    }

    @FXML
    public VBox addOuterBottomContainer(String bottomContainerName, GridPane gridContainer) {
        headerBottomContainer = bottomContainerName;
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        vbox.setId("bottomContainer");
        vbox.getStyleClass().add("outer-bottom-container");
        vbox.getChildren().addAll(addUpperPanel(bottomContainerName, gridContainer), addInnerBottomContainer(bottomContainerName));
        return vbox;
    }

    @FXML
    private GridPane addUpperPanel(String name, GridPane gridContainer) {
        // upper panel settings
        GridPane gp = new GridPane();
        gp.getStyleClass().add("upper-panel-bottom-container");
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(50);
        gp.getColumnConstraints().add(column);
        gp.getColumnConstraints().add(column);

        Label header = new Label(name);
        header.setId("headerBottomContainer");
        GridPane.setValignment(header, VPos.TOP);

        // close button
        Button closeButton = new Button();
        GridPane.setHalignment(closeButton, HPos.RIGHT);
        closeButton.getStyleClass().add("letter");
        FontIcon closeIcon = new FontIcon("bi-x-circle");
        closeIcon.setIconColor(Color.WHITE);
        closeIcon.setIconSize(20);
        closeButton.setGraphic(closeIcon);

        // как ужасно тут написано, но оно работает
        closeButton.setOnAction(event -> {
            // удаляет элемент gridContainer, который является VBox (bottomContainer)
            gridContainer.getChildren().remove(gridContainer.getChildren().lastIndexOf(gp.getParent()));
            isBottomContainerShown = false;
        });

        gp.add(header, 0, 0);
        gp.add(closeButton, 1, 0);
        return gp;
    }

    @FXML
    private ScrollPane addInnerBottomContainer(String bottomContainerName) {
        FlowPane fp = new FlowPane();
        fp.getStyleClass().add("inner-flow-bottom-container");
        fp.setHgap(15);
        fp.setVgap(15);

        if (bottomContainerName.equals("Alphabet")) addAlphabet(fp);
        else if (bottomContainerName.equals("Dictionary")) addDictionary(fp);
        ScrollPane sp = new ScrollPane(fp);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.getStyleClass().add("inner-scroll-bottom-container");
        sp.fitToHeightProperty().set(true);
        sp.fitToWidthProperty().set(true);

        return sp;
    }

    @FXML // TODO
    private void addDictionary(FlowPane fp) {
        if (language == null || language.dictionary.isEmpty()) return;
    }

    @FXML
    private void addAlphabet(FlowPane fp) {
        if (language == null || language.letters.isEmpty()) return;
        for (String letterName : language.letters.keySet()) {
            Button letterButton = new Button(letterName);
            letterButton.getStyleClass().add("letter");
            fp.getChildren().add(letterButton);
        }
    }

    @FXML
    public void newFile() {

    }

    @FXML
    public void openFile(VBox container) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(container.getScene().getWindow());
        if (selectedFile == null) return;
        language = fileWorker.getLanguage(selectedFile);
    }

    @FXML // TODO rebuild input
    public void rebuild(GridPane gridContainer) {
        Node bottomContainer = find(gridContainer.getChildren(), "bottomContainer");
        if (bottomContainer == null) return;

        gridContainer.getChildren().remove(bottomContainer);
        gridContainer.add(addOuterBottomContainer(headerBottomContainer, gridContainer), 0, 2, 2, 1);
    }

    private Node find(Collection<Node> children, String id) {
        for (Node child : children) {
            if (child.getId().equals(id)) return child;
        }
        return null;
    }
}
