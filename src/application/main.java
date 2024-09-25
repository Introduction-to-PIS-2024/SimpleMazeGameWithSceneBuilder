package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("mazeLayout.fxml"));
		primaryStage.setTitle("Simple Maze with SceneBuilder");
		primaryStage.setScene(new Scene(root, 800, 1000));
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}