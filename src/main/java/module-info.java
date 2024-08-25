module org.mromichov.overlordforlanguages {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.bootstrapicons;
    requires com.google.gson;

    opens org.mromichov.overlordforlanguages to javafx.fxml, com.google.gson;
    exports org.mromichov.overlordforlanguages;
    exports org.mromichov.overlordforlanguages.odm;
    opens org.mromichov.overlordforlanguages.odm to com.google.gson, javafx.fxml;
}