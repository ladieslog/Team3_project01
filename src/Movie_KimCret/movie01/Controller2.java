package Movie_KimCret.movie01;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Login.User.UserController;
import Login.User.UserMain;
import Movie_KimCret.movie02.Controller;
import Movie_KimCret.movieDb.movieSeatDAO;
import Movie_KimCret.movieDb.movieSeat_DTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import timeThread.TimeThread;



public class Controller2 implements Initializable{
	private static Parent root;
	private static int movieNum;
	private static String movieName;
	private static String screeningTime;
	private static Timestamp screening;
	//private static DatePicker pick;
	private static Date date;
	private static Stage stage;
 public void setRoot(Parent root) {
	 this.root=root;
 }
 

 public void stop() {
		try {
			DatePicker pick =(DatePicker)root.lookup("#clc");
			
			LocalDate locDate= pick.getValue();
			date = java.sql.Date.valueOf(locDate);
			
			
			
			/*
			stage = new Stage();
			 FXMLLoader loader = 
						new FXMLLoader(getClass().getResource("/Login/UserLogin.fxml"));

				Parent root = loader.load();
				Scene scene = new Scene(root);

				UserController ctl = loader.getController();
				ctl.setRoot(root);
				stage = new Stage();
				stage.setScene(scene);
				stage.show();*/
				
		} catch (Exception e) {
			// TODO: handle exception
		}	
 }
 public void clc02() {
	 TimeThread tt = new TimeThread();
	 stop();
	 
	 stage = (Stage)root.getScene().getWindow();
	 stage.close();
	 UserMain usMa =new UserMain();
		usMa.User();
 }


 public void tal() {
		
		try {
			DatePicker pick =null;
			pick =(DatePicker)root.lookup("#clc");
			
			LocalDate locDate= null;
			locDate=pick.getValue();
			System.out.println(locDate);
			date = java.sql.Date.valueOf(locDate);
			
			Timestamp time =new Timestamp(date.getTime());		
			movieSeatDAO dao = movieSeatDAO.getInstance();
			ArrayList<movieSeat_DTO> seat = dao.seat(time);
			if(seat.size()==0) {
				
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("해당 날짜에 영화가 없습니다. ");
				alert.show();
			}else {
				 stage = new Stage();
				 FXMLLoader loader = 
							new FXMLLoader(getClass().getResource("../movie02/EventMovie1.fxml"));

					Parent root = loader.load();
					Scene scene = new Scene(root);

					Controller ctl = loader.getController();
					
					ctl.setRoot(root);
					ctl.SetDate2(seat);
					ctl.SetDate(date);
				
					stage.setScene(scene);
					stage.show();
					closed();
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}		
}
 
 

 public void clc01() { 
	 TimeThread tt = new TimeThread();
	 tal();
 }
 public void closed() {
	 stage = (Stage)root.getScene().getWindow();
		stage.close();
 }
 
 
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}