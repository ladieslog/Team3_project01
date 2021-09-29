package kjh_Manager.Screening;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kjh_Manager.movieInfo.DestinyMovieInfoDTO;
import timeThread.TimeThread;

public class ScreeningAddCheckController implements Initializable{
	private static Parent root;
	private static int movieNum;
	private static String movieName;
	private static String screeningTime;
	private static Timestamp screening;
	
	private static Stage sacStage;
	

	private TableView<ScreeningDTO> tableView;
	
	private TableColumn movieNameColumn;
	
	private TableColumn screeningTimeColumn;
	
	private TableColumn coupleSeat;
	
	private TableColumn soloSeat;
	
	private static DestinyMovieSeatDAO dao = DestinyMovieSeatDAO.getInstance();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	public void add() {
		TimeThread tt = new TimeThread();
		int screeningNum = dao.getScreeningNum(screening) + 1;
		System.out.println(screeningNum);
		
		
		if(screeningNum <= 0 || screeningNum >= 5) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("해당 날짜의 상영 횟수를 넘겼습니다 (최대 4회)");
			alert.show();
			return;
		}
		
		String screeningNumStr = String.valueOf(screeningNum);
		
		for(int i=1; i<=5; i++) {
			char seat1 = (char) (64 + i);
			for(int j=1; j<=6; j++) {
				String seatStr = "";
				seatStr += String.valueOf(seat1);
				seatStr += String.valueOf(j);
				dao.insertScreening(movieNum, screening, seatStr, movieName, screeningNumStr);
			}
		}
		
		tableView.getItems().clear();
		ScreeningListController slc = new ScreeningListController();
		slc.dbScreeningList(tableView, movieNameColumn, screeningTimeColumn, coupleSeat, soloSeat);
		
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
		
		sacStage.close();
		
		
		
		
	}
	
	public void Cancel() {
		TimeThread tt = new TimeThread();
		Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
	}
	
	public void setTable(TableView<ScreeningDTO> tableView, TableColumn movieName, TableColumn screeningTime, TableColumn coupleSeat, TableColumn soloSeat) {
		this.tableView = tableView;
		this.movieNameColumn = movieName;
		this.screeningTimeColumn = screeningTime;
		this.coupleSeat = coupleSeat;
		this.soloSeat = soloSeat;
	}
	
	public void setSacStage(Stage stage) {
		this.sacStage = stage;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void setText(String movieName, String screeningTime, int movieNum) {
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.screeningTime = screeningTime;
		Label mn = (Label) root.lookup("#movieName");
		Label st = (Label) root.lookup("#screeningTime");
		
		mn.setText("영화 제목 : " + movieName);
		st.setText("상영 시간 : " + screeningTime);
	}
	
	public void setScreening(Timestamp screening) {
		this.screening = screening;
	}
	
	
}
