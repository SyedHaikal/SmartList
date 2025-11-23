module com.example.smartlist {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.smartlist to javafx.fxml;
    exports com.example.smartlist;
}