package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomePageController2 implements Initializable{

	@FXML AnchorPane holderPane;
	
	AnchorPane home;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		createPage();
		
	}
private void setNode(Node node) {
	
	holderPane.getChildren().clear();
	holderPane.getChildren().add((Node) node);
	
	FadeTransition ft = new FadeTransition(Duration.millis(1500));
	ft.setNode(node);
	ft.setFromValue(0.1);
	ft.setToValue(1);
	ft.setCycleCount(1);
	ft.setAutoReverse(false);
	ft.play();
}
	
	private void createPage() {
		
		try {
			home = FXMLLoader.load(getClass().getResource("/FXML/HOME.fxml"));
			setNode(home);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
