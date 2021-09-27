package kjh_Manager.Screening;

import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.stage.Stage;
import kjh_Manager.movieInfo.DestinyMovieInfoDTO;

public class ScreeningListController implements Initializable{
	
	private static Parent root;
	
	private static DestinyMovieSeatDAO dao = DestinyMovieSeatDAO.getInstance();
	
	@FXML
	private TableView<ScreeningDTO> tableView;
	
	@FXML
	private TableColumn movieName;
	
	@FXML
	private TableColumn screeningTime;
	
	@FXML
	private TableColumn coupleSeat;
	
	@FXML
	private TableColumn soloSeat;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbScreeningList(tableView, movieName, screeningTime, coupleSeat, soloSeat);
	}
	
	public void dbScreeningList(TableView<ScreeningDTO> tableView, TableColumn movieName, TableColumn screeningTime, TableColumn coupleSeat, TableColumn soloSeat) {
		movieName = tableView.getColumns().get(0);
		movieName.setCellValueFactory(new PropertyValueFactory("movieName"));
		
		screeningTime = tableView.getColumns().get(1);
		screeningTime.setCellValueFactory(new PropertyValueFactory("time"));
		
		coupleSeat = tableView.getColumns().get(2);
		coupleSeat.setCellValueFactory(new PropertyValueFactory("coupleSeat"));

		soloSeat = tableView.getColumns().get(3);
		soloSeat.setCellValueFactory(new PropertyValueFactory("soloSeat"));
		
		ArrayList<ScreeningDTO> list = dao.getScreening();
		
		for(ScreeningDTO dto : list) {
			String couple = dao.getCoupleSeat(dto);
			dto.setCoupleSeat(couple);
			
			String solo = dao.getSoloSeat(dto);
			dto.setSoloSeat(solo);
			
			String time = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(dto.getScreeningTime());
			dto.setTime(time);
			//System.out.println(time);
			tableView.getItems().add(dto);
		}
		
		//movieNum = tableView.getColumns().get(0);
		//movieNum.setCellValueFactory(new PropertyValueFactory("movieNum"));
	}
	
	public void screeningAdd() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/Screening/ScreeningAdd.fxml"));
			Parent newRoot = loader.load();
			
			Stage stage = new Stage();
			
			ScreeningAddController sac = loader.getController();
			sac.setStage(stage);
			sac.setTable(tableView, movieName, screeningTime, coupleSeat, soloSeat);
			Scene scene = new Scene(newRoot);
			
			
			stage.setScene(scene);
			
			stage.show();
			
		} catch(Exception e) {
			
		}
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void back() {
		ManagerMain manager = new ManagerMain();
		manager.manager();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
		
	}
}
