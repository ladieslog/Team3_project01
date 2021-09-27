package Login.Manager;

import java.net.URL;
import java.util.ResourceBundle;

import Login.goBackMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import kjh_Manager.Screening.ScreeningListMain;
import kjh_Manager.movieInfo.MovieListMain;
import kjh_Manager.userInfo.UserListMain;

public class ManagerController implements Initializable {

	static Parent root;
	goBackMain back;
	MovieListMain movieList;
	ScreeningListMain screen;
	UserListMain user;
	static Stage stage;
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	public void cancle() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void goBack() {
		back.back();
		cancle();
	}
	
	public void memberList() throws Exception {
		user.userList(stage);
	}
	
	public void movieManagement() throws Exception {
		movieList.movieList(stage);
	}
	
	public void screenManagement() throws Exception {
		screen.screeningList(stage);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back = new goBackMain();
		movieList = new MovieListMain();
		screen = new ScreeningListMain();
		user = new UserListMain();
	}
		
}
