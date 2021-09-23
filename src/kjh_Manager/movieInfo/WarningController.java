package kjh_Manager.movieInfo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import kjh_Manager.userInfo.DestinyMovieUserDTO;

public class WarningController implements Initializable{
	
	private static String movie;
	private static DestinyMovieInfoDAO dao;
	private static Stage stage;
	private static int movieNumck;
	
	private TableView<DestinyMovieInfoDTO> tv;
	private TableColumn movieNum;
	private TableColumn movieName;
	private TableColumn movieAvg;
	@FXML
	Label movieNameChk;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setTable(TableView<DestinyMovieInfoDTO> tv, TableColumn movieNum, TableColumn movieName, TableColumn movieAvg) {
		this.tv = tv;
		this.movieNum = movieNum;
		this.movieName = movieName;
		this.movieAvg = movieAvg;
	}
	
	public void setMovieNumCK(int movieNumCk) {
		this.movieNumck = movieNumCk;
	}
	
	public void setMovie(String movieName) {
		this.movie = movieName;
		movieNameChk.setText(movie + ")");
	}
	
	public void setDAO(DestinyMovieInfoDAO dao) {
		this.dao = dao;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	
	public void remove() {
		int result = dao.removeMovie(movieNumck);
		// result가 2일시 알럿창 실행
		System.out.println(result);
		if(result == 2) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("현재 영화가 예매 중이므로 삭제가 불가능합니다");
			alert.show();
		}
		tv.getItems().clear();
		MovieListController.dbMovieList(tv, movieNum, movieName, movieAvg);
		stage.close();
	}
	
	public void Cancel() {
		stage.close();
	}
}
