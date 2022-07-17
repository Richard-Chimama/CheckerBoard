module com.example.checkerboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.checkerboard to javafx.fxml;
    exports com.example.checkerboard;
}