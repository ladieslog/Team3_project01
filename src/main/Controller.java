package main;

import java.net.URL;
import java.util.ResourceBundle;
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
 
 	public void goseatbtn() {	// 버튼 클릭시 좌석배치도로 이동	
		seatchart.start();			
	}

}