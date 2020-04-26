package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController implements Initializable{

	@FXML
	private AnchorPane home;
	
    @FXML
    private JFXButton Maruti;

    @FXML
    private JFXButton hyundai;

    @FXML
    private JFXButton chevrolet;

    @FXML
    private JFXButton tataMotors;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void marutiAction(ActionEvent e) {
		
//		try {
//			loadFXML("/FXML/Maruti.fxml","Maruti");
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
		
		HomePageController.getInstance().createPage(home, "/FXML/Maruti.fxml");
	}
	
	@FXML
    void chevroletAction(ActionEvent event) {
//    	try {
//			loadFXML("/FXML/Chevrolet.fxml","Chevrolet");
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
		
		HomePageController.getInstance().createPage(home, "/FXML/Chevrolet.fxml");
    }

    @FXML
    void hyundaiAction(ActionEvent event) {
//    	try {
//			loadFXML("/FXML/Hyundai.fxml","Hyundai");
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
    	HomePageController.getInstance().createPage(home, "/FXML/Hyundai.fxml");
    }

    @FXML
    void tataMotorsActioin(ActionEvent event) {
//    	try {
//			loadFXML("/FXML/tataMotors.fxml","TataMotors");
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
    	HomePageController.getInstance().createPage(home, "/FXML/TataMotors.fxml");
    }
    
    private void loadFXML(String location, String title) throws IOException {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource(location));
		Stage stage = new Stage(StageStyle.UNDECORATED);
		stage.setScene(new Scene(root));
		stage.setTitle(title);
		stage.setX(491);
		stage.setY(129);
		stage.show();
	}
}
