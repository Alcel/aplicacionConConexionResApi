module com.example.aplicacionconconexionresapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;
    requires java.sql;
    requires retrofit2;
    requires retrofit2.converter.gson;



    opens com.example.aplicacionconconexionresapi to javafx.fxml;
    exports com.example.aplicacionconconexionresapi;
}