module wfc.wavefunctioncollapse {
    requires javafx.controls;
    requires javafx.fxml;


    opens wfc to javafx.fxml;
    exports wfc;
}