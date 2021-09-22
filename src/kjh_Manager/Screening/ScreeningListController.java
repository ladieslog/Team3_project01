package kjh_Manager.Screening;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private TableColumn seat;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dbScreeningList(tableView, movieName, screeningTime, seat);
	}
	
	public void dbScreeningList(TableView<ScreeningDTO> tableView, TableColumn movieName, TableColumn screeningTime, TableColumn Seat) {
		movieName = tableView.getColumns().get(0);
		movieName.setCellValueFactory(new PropertyValueFactory("movieName"));
		
		screeningTime = tableView.getColumns().get(1);
		screeningTime.setCellValueFactory(new PropertyValueFactory("time"));
		
		seat = tableView.getColumns().get(2);
		seat.setCellValueFactory(new PropertyValueFactory("seat"));
		
		ArrayList<ScreeningDTO> list = dao.getScreening();
		
		for(ScreeningDTO dto : list) {
			String seatSituation = dao.getSeatSituation(dto);
			//System.out.println(seatSituation);
			dto.setSeat(seatSituation);
			String time = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(dto.getScreeningTime());
			dto.setTime(time);
			System.out.println(time);
			tableView.getItems().add(dto);
		}
		
		//movieNum = tableView.getColumns().get(0);
		//movieNum.setCellValueFactory(new PropertyValueFactory("movieNum"));
	}
	
	public void screeningAdd() {
		
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
}
