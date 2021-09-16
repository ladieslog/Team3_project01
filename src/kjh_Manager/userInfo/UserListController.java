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
	private static AnchorPane spap;
	
	private static DestinyMovieUserDAO dao = DestinyMovieUserDAO.getInstance();
	
	private static DestinyMovieUserDTO checkedDto;
	
	
	
	
	
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
		id = tableView.getColumns().get(0);
		id.setCellValueFactory(new PropertyValueFactory("id"));
		
		pwd = tableView.getColumns().get(1);
		pwd.setCellValueFactory(new PropertyValueFactory("pwd"));
		
		name = tableView.getColumns().get(2);
		name.setCellValueFactory(new PropertyValueFactory("name"));
		
		gender = tableView.getColumns().get(3);
		gender.setCellValueFactory(new PropertyValueFactory("gender"));
		
		tel = tableView.getColumns().get(4);
		tel.setCellValueFactory(new PropertyValueFactory("tel"));
		
		ArrayList<DestinyMovieUserDTO> list = dao.selectList();
		
		for(DestinyMovieUserDTO dto : list) {
			if(dto.getGender().equals("0")) {
				dto.setGender("남성");
			} else {
				dto.setGender("여성");
			}
			tableView.getItems().add(dto);
		}
		
		/*
		
		
		DTO dto = new DTO();
		dto.setId("wnsgh9978");
		dto.setPwd("1234");
		dto.setName("김준호");
		dto.setGender("중성");
		dto.setTel("010-5609-2044");
		
		tableView.getItems().add(dto);
		*/
	}
	
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
		checkedDto = tableView.getSelectionModel().getSelectedItem();
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
		// ScrollPane sp = (ScrollPane) root.lookup("#sp");
		// System.out.println(sp);
		
		
		/*
		TableView table = new TableView();
		table.resize(223, 323);
		
		spap.getChildren().add(table);
		*/
		
		//sp_ap.getChildren().add(label);
	}
	
	
	
}
