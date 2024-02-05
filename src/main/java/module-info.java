module com.lcontvir_jaguerher.proyect_pilot {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.lcontvir_jaguerher.proyect_pilot to javafx.fxml;
    exports com.lcontvir_jaguerher.proyect_pilot;
}