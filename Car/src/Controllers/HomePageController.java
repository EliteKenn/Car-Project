package Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXToolbar;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.stage.Popup;

public class HomePageController implements Initializable {

    @FXML
     AnchorPane holderPane;
    
    AnchorPane home;

    @FXML
    private JFXButton bttnContact;

    @FXML
    private JFXButton bttnAbout;
    
    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXToolbar toolBar;

    @FXML
    private Text welcome;

    @FXML
    private HBox toolBarRight;

    @FXML
    private Label lblMenu;

    @FXML
    private VBox overflowContainer;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnExit;
    
private static HomePageController instance;
	
	public HomePageController()
	{
		instance = this;
	}
	
	public static HomePageController getInstance()
	{
		return instance;
	}
	
	public void setUsername(String user) {
		this.welcome.setText("Welcome, "+user);
	}
	
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		JFXRippler rippler = new JFXRippler(lblMenu);
		rippler.setMaskType(JFXRippler.RipplerMask.RECT);
		toolBarRight.getChildren().add(rippler);
		openMenus();
		createPage(home, "/FXML/HOME.fxml");
		
		setUsername(LoginController.getInstance().username());
	}

	private void openMenus() {
		// TODO Auto-generated method stub
		JFXPopup pop = new JFXPopup();
		pop.setContent(overflowContainer);
		pop.setPopupContainer(anchor);
		pop.setSource(lblMenu);
		
		lblMenu.setOnMouseClicked(e -> {
			pop.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -1, 58);
		});
		
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
	
public void createPage(AnchorPane homeN,String loc) {
		
		try {
			homeN = FXMLLoader.load(getClass().getResource(loc));
			setNode(homeN);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void createPage() {
		// TODO Auto-generated method stub
		
		try {
			home = FXMLLoader.load(getClass().getResource("/FXML/HOME.fxml"));
			setNode(home);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 @FXML
	    void homeBttn(ActionEvent event) {
		 	
	    	createPage();
	    }

	 @FXML
	    void exit(ActionEvent event) {
		 	Platform.exit();
	    }

	   
	    @FXML
	    void logOut(ActionEvent event) {

			btnLogOut.getScene().getWindow().hide();
	    	
			Stage login = new Stage();
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
			
			Scene scene = new Scene(root);
			login.setScene(scene);
			login.show();
			login.setResizable(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    @FXML
	    void MyInfo(ActionEvent event) {

	    	 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Owner: EliteKenn\nGitHub:https://github.com/EliteKenn");
			alert.show();
			alert.setTitle("Contact Info:");
	    	
	    }

	    @FXML
	    void aboutAlert(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("This is just a mini personal 2-tier architecture project project\nThe user sign up for an account to access the dashbaord"
					+ "\nSelects one of the brand, and see what cars are available to view and see the rating of each vehicle."
					+ "\nOnce the Account is made, it is stored in the database so you can access your account by logging in using the same credentials"
					+ "\nLike I said, small personal project, if you want the code, check out my Github by clicking on the About button."
					+ "\nEnjoy!");
			alert.show();
			alert.setTitle("About The Project:");
	    

 
	    }
	
	
    
    
}