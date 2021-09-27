package kjh_Manager.userInfo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class WarningController implements Initializable{
	
	private static DestinyMovieUserDAO dao;
	private static String checkId;
	private static Stage stage;
	private static UserListController con = new UserListController();
	
	private TableView<DestinyMovieUserDTO> tv;
	private TableColumn id;
	private TableColumn pwd;
	private TableColumn name;
	private TableColumn gender;
	private TableColumn tel;
	@FXML
	Label userId;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void setDAO(DestinyMovieUserDAO DAO) {
		this.dao = DAO;
	}
	
	public void setCheckId(String checkId) {
		this.checkId = checkId;
		userId.setText(checkId + ")"); // 테이블에서 선택한 영화제목
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void remove() {
		int result = dao.removeUser(checkId);
		System.out.println(result);
		tv.getItems().clear();
		con.dbList(tv, id, pwd, name, gender, tel);
		stage.close();
		
	}
	
	public void Cancel() {
		stage.close();
	}
	
	public void setTable(TableView<DestinyMovieUserDTO> tv, TableColumn id, TableColumn pwd, TableColumn name, TableColumn gender, TableColumn tel) {
		this.tv = tv;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
	}
	
	
	

}
