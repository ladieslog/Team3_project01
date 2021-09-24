package Login.Manager;

import java.net.URL;
import java.util.ResourceBundle;

import Login.goBackMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ManagerController implements Initializable {

	static Parent root;
	goBackMain back;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void cancle() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void goBack() {
		back.back();
		cancle();
	}
	
	public void memberList() {
		
	}
	
	public void movieManagement() {
		
	}
	
	public void screenManagement() {
		
	}
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back = new goBackMain();
	}
		
}
