package sys_SeatChart;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import Movie_KimCret.movie01.Controller2;
import Movie_KimCret.movie03.ControllerView1;
import saveInfo.movieInfomat;
import saveInfo.UserId;
import sys_SeatChart.DB.SeatChartDBClass;
import sys_SeatChart.Payment.Payment;
import timeThread.TimeThread;


public class SeatChart implements Initializable{
	@FXML private Button A1;
	@FXML private Button A2;
	@FXML private Button A3;
	@FXML private Button A4;
	@FXML private Button A5;
	@FXML private Button A6;
	@FXML private Button B1;
	@FXML private Button B2;
	@FXML private Button B3;
	@FXML private Button B4;
	@FXML private Button B5;
	@FXML private Button B6;
	@FXML private Button C1;
	@FXML private Button C2;
	@FXML private Button C3;
	@FXML private Button C4;
	@FXML private Button C5;
	@FXML private Button C6;
	@FXML private Button D1;
	@FXML private Button D2;
	@FXML private Button D3;
	@FXML private Button D4;
	@FXML private Button D5;
	@FXML private Button D6;
	@FXML private Button E1;
	@FXML private Button E2;
	@FXML private Button E3;
	@FXML private Button E4;
	@FXML private Button E5;
	@FXML private Button E6;
	@FXML private Rectangle Rect;
	@FXML private Rectangle RandomSeat;
	
	SeatChartDBClass db = new SeatChartDBClass();
	Payment payment = new Payment();
	public static Timestamp screenTimestamp;
	String arr[] = new String[30];
	String[] randomSeatNum = {"A2", "A3", "A4", "A5", "B2", "B3", "B4", "B5", "C2", 
			"C3", "C4", "C5", "D2", "D3", "D4", "D5",  "E2", "E3", "E4", "E5",};
	
	Parent root;	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void start() {
		TimeThread tt = new TimeThread();
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sys_SeatChart/SeatChart.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			SeatChart ctl = loader.getController();						
			ctl.setRoot(root);
			primaryStage.setTitle("?????? ?????????");
			primaryStage.setScene(scene);
			primaryStage.show();
			alert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		TimeThread tt = new TimeThread();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/Movie_KimCret/movie01/EventMovie.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Controller2 ctl = loader.getController();						
			ctl.setRoot(root);
		    Stage.setScene(scene);
		    Stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		
	}

	public void CoupleSeatView() {	// ???????????? ?????????, ???????????? ????????????
		Rect.setVisible(true);
		A1.setDisable(false);
		A6.setDisable(false);
		B1.setDisable(false);
		B6.setDisable(false);
		C1.setDisable(false);
		C6.setDisable(false);
		D1.setDisable(false);
		D6.setDisable(false);
		E1.setDisable(false);
		E6.setDisable(false);
	}
	
	public void RandomSeatView() {	// ???????????? ?????????
		Rect.setVisible(false);
	}
	
	public void reservedSeat(String movieName, Timestamp time) {	// ?????? ?????????????????? ?????? ??????
		db.readDB_Seat(movieInfomat.getMovieName(), movieInfomat.getScreeningTime(), arr);
		for(int j=0 ; j<arr.length ; j++) {	
			if(arr[j] != null) {
				if(arr[j].equals("A1")) { A1.setText("X"); A1.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("A2")) { A2.setText("X"); A2.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("A3")) { A3.setText("X"); A3.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("A4")) { A4.setText("X"); A4.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("A5")) { A5.setText("X"); A5.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("A6")) { A6.setText("X"); A6.setStyle("-fx-background-color:gray");} 
				
				if(arr[j].equals("B1")) { B1.setText("X"); B1.setStyle("-fx-background-color:gray");}   
				if(arr[j].equals("B2")) { B2.setText("X"); B2.setStyle("-fx-background-color:gray");}   
				if(arr[j].equals("B3")) { B3.setText("X"); B3.setStyle("-fx-background-color:gray");}   
				if(arr[j].equals("B4")) { B4.setText("X"); B4.setStyle("-fx-background-color:gray");}   
				if(arr[j].equals("B5")) { B5.setText("X"); B5.setStyle("-fx-background-color:gray");}   
				if(arr[j].equals("B6")) { B6.setText("X"); B6.setStyle("-fx-background-color:gray");}  
				
				if(arr[j].equals("C1")) { C1.setText("X"); C1.setStyle("-fx-background-color:gray");}    
				if(arr[j].equals("C2")) { C2.setText("X"); C2.setStyle("-fx-background-color:gray");}    
				if(arr[j].equals("C3")) { C3.setText("X"); C3.setStyle("-fx-background-color:gray");}    
				if(arr[j].equals("C4")) { C4.setText("X"); C4.setStyle("-fx-background-color:gray");}    
				if(arr[j].equals("C5")) { C5.setText("X"); C5.setStyle("-fx-background-color:gray");}    
				if(arr[j].equals("C6")) { C6.setText("X"); C6.setStyle("-fx-background-color:gray");}  
				
				if(arr[j].equals("D1")) { D1.setText("X"); D1.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("D2")) { D2.setText("X"); D2.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("D3")) { D3.setText("X"); D3.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("D4")) { D4.setText("X"); D4.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("D5")) { D5.setText("X"); D5.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("D6")) { D6.setText("X"); D6.setStyle("-fx-background-color:gray");}   
			
				if(arr[j].equals("E1")) { E1.setText("X"); E1.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("E2")) { E2.setText("X"); E2.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("E3")) { E3.setText("X"); E3.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("E4")) { E4.setText("X"); E4.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("E5")) { E5.setText("X"); E5.setStyle("-fx-background-color:gray");} 
				if(arr[j].equals("E6")) { E6.setText("X"); E6.setStyle("-fx-background-color:gray");} 
			}
		}
	}
	
	public void alert() {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("?????? ?????? ??????");
		alert.setHeaderText("?????? ????????? ??????????????? ?????? ??????");
		alert.setContentText("?????? ????????? ?????? ??????\n?????? ????????? ?????? ???????????????");
		alert.show();
	}
		
	public void ClickCoupleSeat(ActionEvent e) {
		String couplechoice = ((Button)e.getTarget()).getText();
		db.updateDB(UserId.getId(), movieInfomat.getScreeningTime() , 
				couplechoice, 40000, movieInfomat.getMovieName());
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
		payment.start();
	}
	
	public void ClickRandomSeat() {
		String seat ;
		while(true) {
			seat = getRandomSeatNum();
			if(!contain(seat)) break;
		}
		db.updateDB(UserId.getId(), movieInfomat.getScreeningTime(),
				seat, 20000, movieInfomat.getMovieName());
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
		payment.start();
	}
	
	public String getRandomSeatNum() {	//	?????? ?????? ??????
		int randNum = (int)(Math.random()*20);
		String randomResult = randomSeatNum[randNum];
		return randomResult;
	}
	
	public boolean contain(String s) {	//	?????? ??????
		boolean isC=false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=null) {
				if(arr[i].equals(s)) {
					isC=true;	
					
					break;
				}
			}
		}
		return isC;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		reservedSeat(movieInfomat.getMovieName(), movieInfomat.getScreeningTime());
		if(ControllerView1.flag==true) CoupleSeatView();
		else  RandomSeatView();
	}
 }
 
