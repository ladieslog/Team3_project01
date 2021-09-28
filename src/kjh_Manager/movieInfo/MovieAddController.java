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
	// 이미지 선택
	public void imageAdd() {
		FileChooser fileChooser = new FileChooser(); // 파일선택창
		
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png", "*.jpeg"); // 파일 확장자 필터링
		fileChooser.getExtensionFilters().addAll(imgType);
		
		file = fileChooser.showOpenDialog(stage); // 파일 선택창에서 선택한 파일을 File 객체에 저장
		FileInputStream fis = null; // 
		try {
			fis = new FileInputStream(file); // file를 담아서 fis를 생성
			ImageView iv = (ImageView) root.lookup("#movieImage");
			Image image = new Image(fis); 
			
			iv.setImage(image); // 선택한 이미지를 ImageView에 로드
		} catch (Exception e) {
			System.out.println("파일 선택 안함"); // 파일 선택 안하면 익셉션이 발생함
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
		
		String movieComtent = movieComtentArea.getText(); // 영화 코멘트 
		
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(file); // 이미지를 fis에 저장, db에 이미지를 저장하려면 스트림을 이용해야함
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int movieNum = dao.getMovieNum() + 1; // 제일 높은 영화 번호를 가져와서 + 1;
		DestinyMovieInfoDTO dto = new DestinyMovieInfoDTO();
		
		dto.setMovieNum(movieNum);
		dto.setMovieName(movieName.getText());
		dto.setMovieAvg(age);
		
		int result = dao.insertMovie(dto, fis, movieComtent); // DB에 데이터 삽입
		System.out.println(result);
		tv.getItems().clear();
		MovieListController.dbMovieList(tv, controllerMovieNum, controllerMovieName, controllerMovieAvg);
		stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	// 돌아가기
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
