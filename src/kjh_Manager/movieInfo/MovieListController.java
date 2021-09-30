package kjh_Manager.movieInfo;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Login.Manager.ManagerMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import timeThread.TimeThread;

public class MovieListController implements Initializable{
	private static Parent root;
	
	private static DestinyMovieInfoDAO dao = DestinyMovieInfoDAO.getInstance();
	
	// 테이블뷰의 객체들
	@FXML
	private TableView<DestinyMovieInfoDTO> tableView;
	
	@FXML
	private TableColumn movieNum;
	
	@FXML
	private TableColumn movieName;
	
	@FXML
	private TableColumn movieAvg;
	
	private DestinyMovieInfoDTO checkDTO; // 테이블에서 선택한 데이터를 저장할 변수
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		dbMovieList(tableView, movieNum, movieName, movieAvg);
		/*
		movieNum = tableView.getColumns().get(0);
		movieNum.setCellValueFactory(new PropertyValueFactory("movieNum"));
		
		movieName = tableView.getColumns().get(1);
		movieName.setCellValueFactory(new PropertyValueFactory("movieName"));
		
		movieAvg = tableView.getColumns().get(2);
		movieAvg.setCellValueFactory(new PropertyValueFactory("movieAvg"));
		
		ArrayList<DestinyMovieInfoDTO> list = dao.movieList();
		
		
		for(DestinyMovieInfoDTO dto : list) {
			tableView.getItems().add(dto);
		}
		*/
	}
	
	public static void dbMovieList(TableView<DestinyMovieInfoDTO> tableView, TableColumn movieNum, TableColumn movieName, TableColumn movieAvg) {
		movieNum = tableView.getColumns().get(0);
		movieNum.setCellValueFactory(new PropertyValueFactory("movieNum"));
		
		movieName = tableView.getColumns().get(1);
		movieName.setCellValueFactory(new PropertyValueFactory("movieName"));
		
		movieAvg = tableView.getColumns().get(2);
		movieAvg.setCellValueFactory(new PropertyValueFactory("movieAvg"));
		
		ArrayList<DestinyMovieInfoDTO> list = dao.movieList();
		
		
		for(DestinyMovieInfoDTO dto : list) {
			tableView.getItems().add(dto);
		}
	}
	
	public void checked(MouseEvent event) {
		checkDTO = tableView.getSelectionModel().getSelectedItem(); // 테이블에서 선택된 데이터
	}
	
	public void movieRemove() { // 영화 삭제
		TimeThread tt = new TimeThread();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/movieInfo/Warning.fxml"));
			Parent newRoot = loader.load();
			
			Stage stage = new Stage();
			stage.setScene(new Scene(newRoot));
			
			WarningController wc = loader.getController();
			String movieNameck = checkDTO.getMovieName();
			int movieNumck = checkDTO.getMovieNum();
			wc.setMovie(movieNameck);
			wc.setMovieNumCK(movieNumck);
			wc.setDAO(dao);
			wc.setStage(stage);
			wc.setTable(tableView, movieNum, movieName, movieAvg);
			stage.show();
		} catch(Exception e) {
			
		}
	}
	
	
	public void movieAdd() { // 영화 추가
		TimeThread tt = new TimeThread();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/movieInfo/MovieAdd.fxml"));
			Parent newRoot = loader.load();
			
			Stage stage = new Stage();
			stage.setScene(new Scene(newRoot));
			
			MovieAddController mac = loader.getController();
			mac.setRoot(newRoot);
			mac.setDAO(dao);
			mac.setTable(tableView, movieNum, movieName, movieAvg);
			stage.show();
		} catch(Exception e) {
			
		}
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void back() { // 돌아가기
		TimeThread tt = new TimeThread();
		ManagerMain manager = new ManagerMain();
		manager.manager();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
}
