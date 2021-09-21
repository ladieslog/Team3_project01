package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import seatchart.seatchart;
 

public class Controller implements Initializable{
	@FXML private Button Couple;
	@FXML private Button Random;
	
	seatchart seatchart;
	public static boolean flag = false; 	//	커플 : true, solo : false
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 	seatchart = new seatchart();
	}
 
 	public void selectCouple() {	// 커플 선택시	
 		flag = true;
 		Stage window = (Stage)Couple.getScene().getWindow(); 
		window.close();
 		seatchart.start();
	}
 	public void selectSolo() {	// 솔로 선택시		
 		flag = false;
 		Stage window = (Stage)Random.getScene().getWindow(); 
		window.close();
 		seatchart.start();
 	}
}