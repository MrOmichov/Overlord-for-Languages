package org.mromichov.overlordforlanguages;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.Collection;


public class ContentEditor {
    public boolean isBottomContainerShown;
    @FXML
    public VBox addOuterBottomContainer(String bottomContainerName, GridPane gridContainer) {
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

        Label alphabetText = new Label(name);
        GridPane.setValignment(alphabetText, VPos.TOP);

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

        gp.add(alphabetText, 0, 0);
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

    private void addDictionary(FlowPane fp) {
    }

    @FXML
    private void addAlphabet(FlowPane fp) {
        for (int i = 0; i < 33; i++) {
            Button letter = new Button("Ж");
            letter.getStyleClass().add("letter");
            fp.getChildren().add(letter);
        }
    }

    @FXML
    public void addFileChooser(VBox vbox) {
        FileChooser fileChooser = new FileChooser();
    }

    @FXML
    public void rebuild(TextArea input, GridPane gridContainer) {
        input.setText("New value");
        Node bottomContainer = find(gridContainer.getChildren(), "bottomContainer");
        if (bottomContainer == null) return;
        gridContainer.getChildren().remove(bottomContainer);
        isBottomContainerShown = false;
    }

    private Node find(Collection<Node> children, String id) {
        for (Node child : children) {
            if (child.getId().equals(id)) return child;
        }
        return null;
    }

}
