package sjh;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Test3 implements Initializable {
	@FXML private Button test3ch;
	Parent root;
	public void setRoot(Parent root) {
		this.root= root;
	}
	
	
	public void book() {}
	public void list() {
		Stage window = (Stage)test3ch.getScene().getWindow(); 
		window.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sjh/BillList.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			ListMain ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("BillList");
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
