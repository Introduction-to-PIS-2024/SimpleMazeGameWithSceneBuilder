module MazeSceneBuilder {
    exports application;

    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;

    opens application to javafx.fxml; // Open the package to javafx.fxml for reflection
}
