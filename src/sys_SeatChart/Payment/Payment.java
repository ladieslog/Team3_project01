package sys_SeatChart.Payment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import sys_SeatChart.SeatChart;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import saveInfo.movieInfomat;
import saveInfo.UserId;
import sys_SeatChart.DB.SeatChartDBClass;
import sys_SeatChart.DB.SeatChartDTO;
import sjh.BillMain;

public class Payment implements Initializable{
	@FXML private Label MovieName;
	@FXML private Label ScreenTime;
	@FXML private Label SeatNum;
	@FXML private Label Price;
	@FXML private ImageView MoviePoster;
	
	SeatChartDBClass db;
	String arr[] = new String[3];
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void start() {
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sys_SeatChart/Payment/Payment.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Payment ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("결제전 정보창");
			Stage.setScene(scene);
			Stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() throws IOException {
		db.reset_Reservation(UserId.getId(), movieInfomat.getMovieName(), movieInfomat.getScreeningTime()); // 결제 하지 않고 이전 화면으로 돌아갈 경우
		
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sys_SeatChart/SeatChart.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SeatChart ctl = loader.getController();						
			ctl.setRoot(root);
		    Stage.setScene(scene);
		    Stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void Pay() {
		BillMain BillMain = new BillMain();
		BillMain.start();	
		db.reservation(UserId.getId(), movieInfomat.getMovieName(), movieInfomat.getScreeningTime());
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new SeatChartDBClass();
		arr = db.readDB_ForPay(UserId.getId(),movieInfomat.getMovieName(),movieInfomat.getScreeningTime(),arr);
				
		MovieName.setText(arr[0]);
		SeatNum.setText("좌석 번호 : "+ arr[1]);
		SimpleDateFormat form= new SimpleDateFormat("MM/dd HH:mm");
		String screeningTime=form.format(movieInfomat.getScreeningTime());
		ScreenTime.setText(screeningTime);
		Price.setText("가격 : "+ arr[2]);
		
		SeatChartDTO dtoPoster = db.readDB_Poster(MovieName.getText());
		File file = new File("src/img/a1.png");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(dtoPoster.getImage());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Image image = new Image(file.toURI().toString());
		MoviePoster.setImage(image);
	}
}


