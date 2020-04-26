package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.DBHandler;
public class SignUpController implements Initializable{

	@FXML
    private AnchorPane parentPane;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXRadioButton male;

    @FXML
    private ToggleGroup genders;

    @FXML
    private JFXRadioButton female;

    @FXML
    private JFXTextField location;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXButton login;

    @FXML
    private ImageView progress;

    @FXML
    private JFXRadioButton other;
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
    byte[] input;
    byte[] keyBytes = "12345678".getBytes();
    byte[] ivBytes = "input123".getBytes();
    SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
    IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
    Cipher cipher;
    byte[] cipherText;
    int ctLength;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		progress.setVisible(false);
		name.setStyle("-fx-text-inner-color: #a0a2ab;");
		password.setStyle("-fx-text-inner-color: #a0a2ab;");
		this.location.setStyle("-fx-text-inner-color: #a0a2ab;");
		
		handler = new DBHandler();
	}

	@FXML
	public void signUp(ActionEvent ael) {
		progress.setVisible(true);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(Duration.seconds(3));
		pt.setOnFinished(e ->{
			System.out.println("Sign Up Successful");
		});
		
		pt.play();
		
		//Saving data
		
		String insert = "INSERT INTO CARSPROJECT(names,password,gender,location)"
				+"VALUES (?,?,?,?)";
		
		connection = handler.getConnection();
		try {
			pst = connection.prepareStatement(insert);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			pst.setString(1, name.getText());
			pst.setString(2, password.getText());
			pst.setString(3,getGender());
			pst.setString(4,location.getText());
			
			pst.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void loginAction(ActionEvent ae2) throws IOException {
		
		signup.getScene().getWindow().hide();
		
		Stage login = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/FXML/Login.fxml"));
		Scene scene = new Scene(root);
		login.setScene(scene);
		login.show();
		login.setResizable(false);
	}
	
	public String getGender() {
		String gen = "";
		
		if(male.isSelected()) {
			gen = "Male";
		}
		else if(female.isSelected()) {
			gen = "Female";
		}
		else if (other.isSelected()) {
			gen = "Other";
		}
		return gen;
	}
}
