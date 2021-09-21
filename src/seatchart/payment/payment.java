package seatchart.payment;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seatchart.seatchart;
import seatchart.DB.DBClass;

public class payment implements Initializable{
	DBClass db = new DBClass();
	seatchart seatchart;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void start() {
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/seatchart/payment/payment.fxml"));
			 
			Parent root = loader.load();
			Scene scene = new Scene(root);
			payment ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("결제전 정보창");
			Stage.setScene(scene);
			Stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() throws IOException {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/seatchart/seatchart.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			seatchart ctl = loader.getController();						
			ctl.setRoot(root);
		    Stage.setScene(scene);
		    Stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
