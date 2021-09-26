package main;

import java.net.URL;
import java.util.ResourceBundle;

import sys_SeatChart.SeatChart;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
 

public class Controller implements Initializable{
	@FXML private Button Couple;
	@FXML private Button Random;
	SeatChart SeatChart;
	public static boolean flag = false; 	//	커플 : true, solo : false
	public static String selectedScreeningTime, selectedUser, selectedMovieName, selectedScreeningNum;
	public static int selectedMovieNum;
	Parent root;	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 SeatChart = new SeatChart();
	 	selectedScreeningTime = "2021/09/29 08:20";
	 	selectedUser = "abc";
 		selectedMovieName = "어바웃 타임";
 		selectedScreeningNum = "2";
 		selectedMovieNum = 2;
	}
 
 	public void selectCouple() {	// 커플 선택시	
 		flag = true;
 		Stage window = (Stage)Couple.getScene().getWindow(); 
		window.close();
		SeatChart.start();
	}
 	
 	public void selectSolo() {	// 솔로 선택시		
 		flag = false;
 		Stage window = (Stage)Random.getScene().getWindow();
		window.close();
		SeatChart.start();
 	}
}