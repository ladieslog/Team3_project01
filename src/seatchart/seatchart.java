package seatchart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import seatchart.DB.DBClass;

public class seatchart implements Initializable{
	DBClass db = new DBClass();
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@FXML private Button B1;
	
	public void start() {
		db.readDB_User("IU");	// 현재 로그인 중인 계정 연결해야함
		
		System.out.println("좌석 배치도 보기");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../seatchart/seatchart.fxml"));
			
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
		//B1.setVisible(false);
	}
	
	public void selectCoupleSeat(ActionEvent event) {
		String couplechoice = ((Button)event.getTarget()).getText();
		System.out.println(couplechoice);
		
		/*
		Button A1 = (Button)root.lookup("#A1");
		Button B1 = (Button)root.lookup("#B1");
		
		A1.setOnAction(event -> {
		    A1.setStyle("-fx-background-color: red");   
		    System.out.println("A1좌석 선택됨");
		});
		
		B1.setOnAction(event -> {     
			System.out.println("B1좌석 선택됨");
			B1.setStyle("-fx-background-color: red");  	  
		});*/
	}
	
	public void selectRandomSeat() {
		System.out.println("랜덤 좌석 배정 시작");
		
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
