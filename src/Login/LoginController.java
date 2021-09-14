package Login;

import java.net.URL;
import java.util.ResourceBundle;

import Login.Member.MemberMain;
import Login.User.UserMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	static Parent root;
	UserMain user;
	MemberMain member;
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}

	public void membership() {
		member.mamber();
	}
	
	public void mainScreen() {
		
	}
	
	public void userLogin() {
		user.User();
	}
	
	public void managerLogin() {
		
	}
	
	public void cancle() {
		
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		user = new UserMain();
		member = new MemberMain();
	}

	
}
