module org.mromichov.overlordforlanguages {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.mromichov.overlordforlanguages to javafx.fxml;
    exports org.mromichov.overlordforlanguages;
}