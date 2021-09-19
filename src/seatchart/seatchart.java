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
import seatchart.DB.DBClass;

public class seatchart implements Initializable{
	@FXML private Button A1;
	@FXML private Button A6;
	@FXML private Button B1;
	@FXML private Button B6;
	@FXML private Button C1;
	@FXML private Button C6;
	@FXML private Button D1;
	@FXML private Button D6;
	@FXML private Button E1;
	@FXML private Button E6;
	@FXML private Rectangle Rect;
	@FXML private Rectangle RandomSeat;
	
	DBClass db = new DBClass();
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void selectCouple() {	// 커플 선택시
		
		
		reservedSeat(2, "21/08/06");
		RandomSeatView();
	}
	
	public void selectSolo() {	// 솔로 선택시
		start();
		//RandomSeatView();
		//reservedSeat(2, "21/08/06");
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
	

	//String couplechoice = ((Button)event.getTarget()).getText();
			//System.out.println(couplechoice);
	
	
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
		A1.setDisable(true);
		A6.setDisable(true);
		B1.setDisable(true);
		B6.setDisable(true);
		C1.setDisable(true);
		C6.setDisable(true);
		D1.setDisable(true);
		D6.setDisable(true);
		E1.setDisable(true);
		E6.setDisable(true);
	}
	
	public void reservedSeat(int movieNum, String time) {	// 이미 예매되어있는 좌석 표시
		String arr[] = new String[30];
		db.readDB_Seat(movieNum, time, arr);
		System.out.println("readDB_Seat 완료");
		for(int j=0 ; j<arr.length ; j++) {
			if(arr[j] != null) {
				System.out.println(arr[j]);
				if(arr[j].equals("A1")) A1.setStyle("-fx-background-color:black");   
				if(arr[j].equals("A6")) A6.setStyle("-fx-background-color:black");   
				if(arr[j].equals("B1")) B1.setStyle("-fx-background-color:black");   
				if(arr[j].equals("B6")) B6.setStyle("-fx-background-color:black");   
				if(arr[j].equals("C1")) C1.setStyle("-fx-background-color:black");   
				if(arr[j].equals("C6")) C6.setStyle("-fx-background-color:black");   
				if(arr[j].equals("D1")) D1.setStyle("-fx-background-color:black");   
				if(arr[j].equals("D6")) D6.setStyle("-fx-background-color:black");   
				if(arr[j].equals("E1")) E1.setStyle("-fx-background-color:black");   
				if(arr[j].equals("E6")) E6.setStyle("-fx-background-color:black");   

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
		
	}
}