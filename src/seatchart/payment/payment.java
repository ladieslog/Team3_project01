package seatchart.payment;


import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Controller;
import seatchart.seatchart;
import seatchart.DB.DBClass;
import seatchart.DB.MovieDTO;

public class payment extends Thread implements Initializable{
	@FXML private Label MovieName;
	@FXML private Label ScreenTime;
	@FXML private Label SeatNum;
	@FXML private Label Price;
	
	MovieDTO dto = null;
	DBClass db = new DBClass();
	seatchart seatchart;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void start() {
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/seatchart/payment/payment.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			payment ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("결제전 정보창");
			Stage.setScene(scene);
			Stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void exit() throws IOException {
		db.del_Reservation("test22", 3, "21/08/06"); // 결제 하지 않고 이전 화면으로 돌아갈 경우
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/seatchart/seatchart.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			seatchart ctl = loader.getController();						
			ctl.setRoot(root);
		    Stage.setScene(scene);
		    Stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Pay() {
		System.out.println("결제창으로 이동");
		db.reservation("test22", 3, "21/08/06 13:00");
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void viewPay() {
		//DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		//Date date = dto.getScreeningTime();        
		//String dateToStr = dateFormat.format(date);
		//MovieName.setText(String.valueOf(dto.getMovieNum()));
		//ScreenTime.setText("test");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		viewPay();
	}
}