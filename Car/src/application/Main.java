package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage window) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
			Scene scene = new Scene(root,650,430);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setTitle("Car Project");
			window.setScene(scene);
			window.show();
			window.setResizable(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
