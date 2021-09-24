package kjh_Manager.userInfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserListController implements Initializable{
	
	private static Parent root;
	
	private static DestinyMovieUserDAO dao = DestinyMovieUserDAO.getInstance(); // DAO
	
	private static DestinyMovieUserDTO checkedDto; // 테이블에서 선택된 데이터
	
	
	
	
	
	@FXML
	private  TableView<DestinyMovieUserDTO> tableView;
	
	@FXML
	private  TableColumn id;
	@FXML
	private  TableColumn pwd;
	@FXML
	private  TableColumn name;
	@FXML
	private  TableColumn gender;
	@FXML
	private  TableColumn tel;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbList(tableView, id, pwd, name, gender, tel);
		
	}
	
	// 테이블뷰 데이터 업로드
	public void dbList(TableView<DestinyMovieUserDTO> tv, TableColumn id, TableColumn pwd, TableColumn name, TableColumn gender, TableColumn tel) {
		TableView<DestinyMovieUserDTO> tvcp = tv;
		TableColumn idcp = id;
		TableColumn pwdcp = id;
		TableColumn namecp = name;
		TableColumn gendercp = gender;
		TableColumn telcp = tel;
		
		
		idcp = tvcp.getColumns().get(0);
		idcp.setCellValueFactory(new PropertyValueFactory("id"));
		
		pwdcp = tvcp.getColumns().get(1);
		pwdcp.setCellValueFactory(new PropertyValueFactory("pwd"));
		
		namecp = tvcp.getColumns().get(2);
		namecp.setCellValueFactory(new PropertyValueFactory("name"));
		
		gendercp = tvcp.getColumns().get(3);
		gendercp.setCellValueFactory(new PropertyValueFactory("gender"));
		
		telcp = tvcp.getColumns().get(4);
		telcp.setCellValueFactory(new PropertyValueFactory("tel"));
		
		ArrayList<DestinyMovieUserDTO> list = dao.selectList();
		
		for(DestinyMovieUserDTO dto : list) {
			if(dto.getGender().equals("0")) {
				dto.setGender("남성");
			} else {
				dto.setGender("여성");
			}
			tvcp.getItems().add(dto);
		}
	}
	
	public void checked(MouseEvent event) {
		checkedDto = tableView.getSelectionModel().getSelectedItem(); // 현재 테이블에서 선택된 데이터
	}
	
	public void userRemove() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/userInfo/Warning.fxml"));
			Parent newRoot = loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(newRoot));
			WarningController wc = loader.getController();
			wc.setDAO(dao);
			String checkId = checkedDto.getId();
			wc.setCheckId(checkId);
			wc.setStage(stage);
			wc.setTable(tableView, id, pwd, name, gender, tel);
			stage.show();
		} catch(Exception e) {
			
		}
		
		
		
	}
	
	
	public void back() {
		System.out.println("돌아가기");
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		
	}
	
	
	
}
