package org.mromichov.overlordforlanguages;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class NewFileWindowController {
    @FXML
    private VBox container;
    @FXML
    private Button create;
    @FXML
    private Button cancel;

    private String directoryPathname;

    @FXML
    protected void onChooseDirectoryButtonClick() {
        DirectoryChooser chooser = new DirectoryChooser();
        directoryPathname = chooser.showDialog(container.getScene().getWindow()).getAbsolutePath();
    }

    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }


    public String getDirectoryPathname() {
        return directoryPathname;
    }
}
