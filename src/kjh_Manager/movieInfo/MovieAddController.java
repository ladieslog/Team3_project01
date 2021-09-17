package kjh_Manager.movieInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MovieAddController implements Initializable{
	
	private static Stage stage;
	private static Parent root;
	private static File file;

	private static DestinyMovieInfoDAO dao;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void imageAdd() {
		FileChooser fileChooser = new FileChooser();
		file = fileChooser.showOpenDialog(stage);
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageView iv = (ImageView) root.lookup("#movieImage");
		Image image = new Image(fis);
		
		iv.setImage(image);
		
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void movieAdd() {
		TextField movieName = (TextField) root.lookup("#movieName");
		TextField movieAvg = (TextField) root.lookup("#movieAvg");
		
		if(file == null) {
			System.out.println("이미지를 추기해주세요");
			return;
		}
		if(movieName.getText().equals("")) {
			System.out.println("영화 제목을 적어주세요");
			return;
		}
		if(movieAvg.getText().equals("")) {
			System.out.println("영화 평점을 입력해주세요");
			return;
		}
		
		// Double age = 0.0;
		try {
		Double age = Double.parseDouble(movieAvg.getText());
		} catch(Exception e) {
			System.out.println("숫자를 입력해주세요");
			return;
		}
		
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int movieNum = dao.getMovieNum() + 1;
		System.out.println(movieNum);
		System.out.println(fis);
		
		
	}
	
	public void back() {
		stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void setDAO(DestinyMovieInfoDAO dao) {
		this.dao = dao;
	}
	
	
}
