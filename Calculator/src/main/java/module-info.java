module org.calculator.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.calculator.calculator to javafx.fxml;
    exports org.calculator.calculator;
}