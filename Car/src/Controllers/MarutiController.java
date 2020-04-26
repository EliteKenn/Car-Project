package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MarutiController implements Initializable{

	@FXML
    private AnchorPane MarutiAnchor;
	
	@FXML
	private JFXButton back;
	
	AnchorPane CarInfo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void backAction(ActionEvent e) {
		HomePageController.getInstance().createPage(CarInfo, "/FXML/HOME.fxml");
	}
	
	public void setNode(Node node) {
		
		MarutiAnchor.getChildren().add((Node) node);
		
		FadeTransition ft = new FadeTransition(Duration.millis(1500));
		
		ft.setNode(node);
		ft.setFromValue(0.1);
		ft.setToValue(1);
		ft.setCycleCount(1);
		ft.setAutoReverse(false);
		ft.play();
	}
}
