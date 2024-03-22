module com.example.cwfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cwfx to javafx.fxml;
    exports com.example.cwfx;
}