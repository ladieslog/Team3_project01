package Login.Member;

import java.net.URL;
import java.util.ResourceBundle;

import Login.goBackMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MemberController implements Initializable{
		
	static Parent root;
	goBackMain back;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void back() {
		back.back();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back = new goBackMain();
	}
}
