package Movie_KimCret.movie01;

import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import Movie_KimCret.movie02.Controller;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;



public class Controller2 implements Initializable{
	private static Parent root;
	private static int movieNum;
	private static String movieName;
	private static String screeningTime;
	private static Timestamp screening;
	private static DatePicker pick;
	private static Date date;
	private static Stage stage;
 public void setRoot(Parent root) {
	 this.root=root;
 }
 

 public void stop() {
		try {
			LocalDate locDate= pick.getValue();
			date = java.sql.Date.valueOf(locDate);
			stage = new Stage();
			 FXMLLoader loader = 
						new FXMLLoader(getClass().getResource("../movie02/EventMovie1.fxml"));

				Parent root = loader.load();
				Scene scene = new Scene(root);

				Controller ctl = loader.getController();
				ctl.setRoot(root);
				stage = new Stage();
				stage.setScene(scene);
				stage.show();
				
		} catch (Exception e) {
			// TODO: handle exception
		}	
 }
 public void clc02() {
	 stop();
	 stage = (Stage)root.getScene().getWindow();
	 stage.close();
 }


 public void tal() {
		
		try {
			pick =(DatePicker)root.lookup("#clc");

			LocalDate locDate= pick.getValue();
			date = java.sql.Date.valueOf(locDate);
			
			
			 stage = new Stage();
			 FXMLLoader loader = 
						new FXMLLoader(getClass().getResource("../movie02/EventMovie1.fxml"));

				Parent root = loader.load();
				Scene scene = new Scene(root);

				Controller ctl = loader.getController();
				
				ctl.setRoot(root);
				ctl.SetDate(date);
				stage.setScene(scene);
				stage.show();
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
}
 
 

 public void clc01() { 
	 tal();
	 stage = (Stage)root.getScene().getWindow();
	 stage.close();
	 
 }
 
 
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}