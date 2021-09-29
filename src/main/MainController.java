package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sjh.BillMain;

public class MainController implements Initializable{
	BillMain BillMain;
	@FXML private Button gobtn;

	Parent root;
	   public void setRoot(Parent root) {
	       this.root=root;    
	   }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		BillMain = new BillMain();	
	}
	
	public void goseatbtn() {    
		Stage window = (Stage)gobtn.getScene().getWindow(); 
		window.close();
		BillMain.start();
	}
	
}
