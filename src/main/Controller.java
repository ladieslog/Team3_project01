package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import seatchart.seatchart;
 

public class Controller implements Initializable{
	seatchart seatchart;
	Parent root;
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}

 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 	seatchart = new seatchart();
	}
 
 	public void selectCouple() {	// 커플 선택시	
		seatchart.start();
 		//seatchart.selectCouple();
	}
 	public void selectSolo() {	// 솔로 선택시		
 		seatchart.selectSolo();
 	}
}