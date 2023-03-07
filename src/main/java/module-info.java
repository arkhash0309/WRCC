module com.example.coursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arkhash.coursework to javafx.fxml;
    exports com.arkhash.coursework;
}