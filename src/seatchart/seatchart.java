package seatchart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import main.Controller;
import seatchart.DB.DBClass;
import seatchart.payment.payment;


public class seatchart implements Initializable{
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
	
	DBClass db = new DBClass();
	payment payment = new payment();
	String arr[] = new String[30];
	String[] randomSeatNum = {"A2", "A3", "A4", "A5", "B2", "B3", "B4", "B5", "C2", "C3", "C4", "C5",
			"D2", "D3", "D4", "D5",  "E2", "E3", "E4", "E5",};
	Stage window;
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void start() {
		db.readDB_User("sjh");	// 현재 로그인 중인 계정 연결해야함
		System.out.println("좌석 배치도 보기");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/seatchart/seatchart.fxml"));
			 
			Parent root = loader.load();
			Scene scene = new Scene(root);
			seatchart ctl = loader.getController();						
			ctl.setRoot(root);
			primaryStage.setTitle("좌석 배치도");
			primaryStage.setScene(scene);
			primaryStage.show();
			alert();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/main/Main.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Controller ctl = loader.getController();						
			ctl.setRoot(root);
		    Stage.setScene(scene);
		    Stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CoupleSeatView() {	// 커플좌석 활성화, 랜덤좌석 비활성화
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
	
	public void RandomSeatView() {	// 커플좌석 비활성화, 랜덤좌석 활성화
		Rect.setVisible(false);
	}
	
	public void reservedSeat(int movieNum, String time) {	// 이미 예매되어있는 좌석 표시
		
		db.readDB_Seat(movieNum, time, arr);
		System.out.println("readDB_Seat 완료");
		for(int j=0 ; j<arr.length ; j++) {	// 간소화 필요
			if(arr[j] != null) {
				System.out.println(arr[j]);
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
		alert.setTitle("알려드립니다.");
		alert.setHeaderText("연인 좌석과 인연좌석의 자리 배정,");
		alert.setContentText("연인 좌석은 지정 배정\n인연 좌석은 랜덤 배정됩니다");	
		alert.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkseatbtn.setOnAction(event->handleBtnStart(event));
	}
	
	public void ClickRandomSeat() {
		getRandomSeatNum();
		Stage window = (Stage)RandomSeat.getScene().getWindow(); 
		window.close();
		payment.start();
	}
	
	public void ClickCoupleSeat(ActionEvent e) {
		String couplechoice = ((Button)e.getTarget()).getText();
		System.out.println(couplechoice);
		Stage window = (Stage)RandomSeat.getScene().getWindow(); 
		window.close();
		payment.start();
	}
	
	public void getRandomSeatNum() {	//	랜덤 좌석 생성
		int randNum = (int)(Math.random()*20);
		System.out.println("랜덤 결과 : " + randomSeatNum[randNum]);
		String result = randomSeatNum[randNum];
		System.out.println(result);
		if(contain(result)){
			System.out.println("중복 발견!!");
			getRandomSeatNum();
		}
		else {
			System.out.println("중복 없음");
			
		}
	}
	
	public boolean contain(String s) {	//	중복 확인
		boolean isC=false;
		System.out.println("contain 시작");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=null) {
				System.out.println(arr[i]);
				if(arr[i].equals(s)) {
					isC=true;	
					break;
				}
			}
		}
		return isC;
	}
		
	@FXML private Button checkseatbtn;
	
		
	public void handleBtnStart(ActionEvent e) {	//좌석 갱신
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted()) {break;}
					Platform.runLater(()->{
						checkseatbtn.setText("갱신중..");
						reservedSeat(2, "21/08/06");
						if(Controller.flag==true) CoupleSeatView();
						else  RandomSeatView();
					});
					try { Thread.sleep(3000); }
					catch (InterruptedException e) {
						System.out.println("인터럽트 발생");
						break;
					}
				}	
			};
		};
		thread.setDaemon(true);
		thread.start();
	}
}

