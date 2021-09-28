package kjh_Manager.Screening;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kjh_Manager.movieInfo.DestinyMovieInfoDAO;
import kjh_Manager.movieInfo.DestinyMovieInfoDTO;

public class ScreeningAddController implements Initializable{
	private static Stage stage;
	private static DestinyMovieInfoDAO dmidao = DestinyMovieInfoDAO.getInstance();
	
	private static DestinyMovieInfoDTO check;
	
	@FXML
	TableView<DestinyMovieInfoDTO> tableView;
	
	@FXML
	TableColumn movieName;
	
	@FXML
	DatePicker year;
	
	@FXML
	TextField hh;
	
	@FXML
	TextField mm;
	
	private TableView<ScreeningDTO> ScreeninTableView;
	
	private TableColumn movieNameColumn;
	
	private TableColumn screeningTimeColumn;
	
	private TableColumn coupleSeat;
	
	private TableColumn soloSeat;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbScreeningList(tableView, movieName);
	}
	
	public void dbScreeningList(TableView<DestinyMovieInfoDTO> tableView, TableColumn movieName) {
		movieName = tableView.getColumns().get(0);
		movieName.setCellValueFactory(new PropertyValueFactory("movieName"));
		
		ArrayList<DestinyMovieInfoDTO> list = dmidao.movieList();
		for(DestinyMovieInfoDTO dto : list) {
			tableView.getItems().add(dto);
		}
	}
	
	public void checked() {
		check = tableView.getSelectionModel().getSelectedItem();
		System.out.println(check.getMovieName());
	}
	
	public void scrreningAdd() {
		LocalDate ld = null;
		Date scrreningDate = null;
		if(check == null) {
			alert("영화를 선택해주세요");
			return;
		}
		try {
			ld = year.getValue();
			System.out.println(ld);
			scrreningDate = java.sql.Date.valueOf(ld);
		} catch (Exception e) {
			alert("달력을 이용해주세요");
			return;
		}
		if(hh.getText().equals("") || mm.getText().equals("")) {
			alert("시간을 입력해주세요");
			return;
		}
		try {
			int check1 = Integer.parseInt(hh.getText());
			int check2 = Integer.parseInt(mm.getText());
		} catch(Exception e) {
			alert("숫자를 입력해주세요");
			return;
		}
		if(Integer.parseInt(hh.getText()) < 0 || Integer.parseInt(hh.getText()) > 23) {
			alert("시간을 맞게 입력해주세요");
			return;
		}
		if(Integer.parseInt(mm.getText()) < 0 || Integer.parseInt(mm.getText()) > 59) {
			alert("시간을 맞게 입력해주세요");
			return;
		}
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		Calendar scrreningCal = Calendar.getInstance();
		scrreningCal.setTime(scrreningDate);
		
		scrreningCal.add(Calendar.HOUR, Integer.parseInt(hh.getText()));
		scrreningCal.add(Calendar.MINUTE, Integer.parseInt(mm.getText()));
		
		Calendar sysCal = Calendar.getInstance();
		
		sysCal.add(Calendar.DATE, 3);
		
		if(sysCal.getTime().after(scrreningCal.getTime())) {
			String checkDate = sdf1.format(sysCal.getTime());
			alert(checkDate + "이후 날짜를 선택해주세요");
			return;
		}
		
		Timestamp screeningStamp = new Timestamp(scrreningCal.getTime().getTime());
		
		int movieNum = check.getMovieNum();
		String movieName = check.getMovieName();
		String scrreningCalStr = sdf1.format(scrreningCal.getTime());
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/Screening/ScreeningAddCheck.fxml"));
			Parent root = loader.load();
			
			Stage newStage = new Stage();
			ScreeningAddCheckController sacc = loader.getController();
			sacc.setRoot(root);
			sacc.setText(movieName, scrreningCalStr, movieNum);
			sacc.setScreening(screeningStamp);
			sacc.setTable(ScreeninTableView, movieNameColumn, screeningTimeColumn, coupleSeat, soloSeat);
			sacc.setSacStage(stage);
			
			Scene scene = new Scene(root);
			newStage.setScene(scene);
			newStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void setTable(TableView<ScreeningDTO> tableView, TableColumn movieName, TableColumn screeningTime, TableColumn coupleSeat, TableColumn soloSeat) {
		this.ScreeninTableView = tableView;
		this.movieNameColumn = movieName;
		this.screeningTimeColumn = screeningTime;
		this.coupleSeat = coupleSeat;
		this.soloSeat = soloSeat;
	}
	
	public void alert(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(message);
		alert.show();
	}
	
	
	public void back() {
		stage.close();
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
