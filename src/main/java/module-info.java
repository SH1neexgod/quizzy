module com.application.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.application.application to javafx.fxml;
    exports com.application.application;
}