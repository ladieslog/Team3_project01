package Login.User;

import java.net.URL;
import java.util.ResourceBundle;

import Login.LoginMain;
import Login.goBackMain;
import Movie_KimCret.movie01.Mainclass;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import saveInfo.UserId;
import sjh.BillMain;

public class UserController implements Initializable {
	Mainclass movie1 =new Mainclass();
	static Parent root;
	goBackMain back;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void cancle() {
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
	
	public void goBack() {
		back.back();
		cancle();
	}
	
	public void movieReservation() {
		movie1.playon();
		cancle();
	}
	
	public void moviePurchase() {
		cancle();
		BillMain BillMain = new BillMain();
		BillMain.list();
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back = new goBackMain();
	}
}