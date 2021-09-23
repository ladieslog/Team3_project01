package seatchart.payment;


import java.io.IOException;
import java.net.URL;
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
		db.reservation("test22", 3, "21/08/06");
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void viewPay() {
		MovieName.setText("노트북");
	}
	
	
	public void viewStart() {	//예매할 정보 갱신
 		Thread thread = new Thread() {
 			@Override
 			public void run() {
 				Platform.runLater(()->{
 					viewPay();
 					System.out.println("viewPay완료");
 				});
 				try { Thread.sleep(1000); }
 				catch (InterruptedException e) {
 				
 				}	
 			};
 		};
 		thread.setDaemon(true);
 		thread.start();
 	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
