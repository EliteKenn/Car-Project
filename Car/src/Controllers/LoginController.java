package Controllers;

import java.sql.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import DBConnection.DBHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {

	
	@FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton login;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton forgotpassword;

    @FXML
    private ImageView progress;
	
    private DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;
    private static LoginController instance;
    
    public LoginController() {
    	instance = this;
    }
    
    public static LoginController getInstance() {
    	return instance;
    }
    
    public String username() {
    	return username.getText();
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		progress.setVisible(false);
		username.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");
		
		handler = new DBHandler();
	}
	
	
//	public void loginAction(ActionEvent e) {
//		
//		progress.setVisible(true);
//		PauseTransition pt = new PauseTransition();
//		pt.setDuration(Duration.seconds(3));
//		pt.setOnFinished(ev ->{
//			
//			System.out.println("Login Successfully");
//			pt.play();
//		});
//	}
	
	@FXML
	void loginAction(ActionEvent event) {
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(ev ->{
			
			
		});
		pt.play();
		
		//retrieve data from database
		
		connection = handler.getConnection();
		String sql = "SELECT * FROM CARSPROJECT WHERE NAMES=? and PASSWORD=?";
		
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1,username.getText());
			pst.setString(2,password.getText());
			
			ResultSet myRs = pst.executeQuery();
			
			int count = 0;
			while(myRs.next()) {
				count = count + 1;
			}
			if(count == 1) {
				login.getScene().getWindow().hide();
				
				Stage home = new Stage();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/FXML/HomePage.fxml"));
					Scene scene = new Scene(root);
					home.setScene(scene);
					home.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Username and Password Is Not Correct");
				alert.show();
				progress.setVisible(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
	@FXML
	public void signUp(ActionEvent e1) throws IOException {
		
		login.getScene().getWindow().hide();
		
		Stage signup = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignUp.fxml"));
		Scene scene = new Scene(root);
		signup.setScene(scene);
		signup.show();
		signup.setResizable(false);
	}

}
