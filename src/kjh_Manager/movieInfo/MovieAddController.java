package kjh_Manager.movieInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MovieAddController implements Initializable{
	
	private static Stage stage;
	private static Parent root;
	private static File file;

	private static DestinyMovieInfoDAO dao;
	
	private TableView<DestinyMovieInfoDTO> tv;
	private TableColumn controllerMovieNum;
	private TableColumn controllerMovieName;
	private TableColumn controllerMovieAvg;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void imageAdd() {
		FileChooser fileChooser = new FileChooser();
		
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png", "*.jpeg");
		fileChooser.getExtensionFilters().addAll(imgType);
		
		file = fileChooser.showOpenDialog(stage);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			ImageView iv = (ImageView) root.lookup("#movieImage");
			Image image = new Image(fis);
			
			iv.setImage(image);
		} catch (Exception e) {
			System.out.println("파일 선택 안함");
		}
	
		try {
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	public void movieAdd() {
		TextField movieName = (TextField) root.lookup("#movieName");
		TextField movieAvg = (TextField) root.lookup("#movieAvg");
		TextArea movieComtentArea = (TextArea) root.lookup("#movieComent");
		
		if(file == null) {
			alertShow("이미지를 추기해주세요");
			return;
		}
		if(movieName.getText().equals("")) {
			alertShow("영화 제목을 입력해주세요");
			return;
		}
		if(movieAvg.getText().equals("")) {
			alertShow("영화 평점을 입력해주세요");
			return;
		}
		
		Double age = 0.0;
		try {
		age = Double.parseDouble(movieAvg.getText());
		} catch(Exception e) {
			alertShow("숫자를 입력해 주세요");
			return;
		}
		
		String movieComtent = movieComtentArea.getText();
		
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int movieNum = dao.getMovieNum() + 1;
		DestinyMovieInfoDTO dto = new DestinyMovieInfoDTO();
		
		dto.setMovieNum(movieNum);
		dto.setMovieName(movieName.getText());
		dto.setMovieAvg(age);
		
		int result = dao.insertMovie(dto, fis, movieComtent);
		System.out.println(result);
		tv.getItems().clear();
		MovieListController.dbMovieList(tv, controllerMovieNum, controllerMovieName, controllerMovieAvg);
		stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void back() {
		stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void alertShow(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(message);
		alert.show();
	}
	
	public void setTable(TableView<DestinyMovieInfoDTO> tv, TableColumn movieNum, TableColumn movieName, TableColumn movieAvg) {
		this.tv = tv;
		this.controllerMovieNum = movieNum;
		this.controllerMovieName = movieName;
		this.controllerMovieAvg = movieAvg;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void setDAO(DestinyMovieInfoDAO dao) {
		this.dao = dao;
	}
	
	
}
