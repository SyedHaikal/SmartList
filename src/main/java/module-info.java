module com.example.smartlist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.smartlist to javafx.fxml;
    exports com.example.smartlist;
}