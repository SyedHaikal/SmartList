module com.example.smartlist {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.smartlist to javafx.fxml, com.google.gson;
    exports com.example.smartlist;
}