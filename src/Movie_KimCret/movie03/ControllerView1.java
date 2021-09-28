package Movie_KimCret.movie03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import Movie_KimCret.movie01.Controller2;
import Movie_KimCret.movieDb.movieInfomation_DTO;
import Movie_KimCret.movieDb.movieSeatDAO;
import Movie_KimCret.movieDb.movieSeat_DTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import saveInfo.movieInfomat;
import sys_SeatChart.SeatChart;


public class ControllerView1 implements Initializable{
	static Parent root;
	static movieInfomation_DTO info;
	private static movieSeatDAO seat= movieSeatDAO.getInstance();
	private static String path;
	private static movieSeat_DTO seat2;
	
	
 
	public void setSeat(movieSeat_DTO seat2) {
		this.seat2= seat2;
	}
	ImageView Image;
	public void setpath(String path) {
		this.path =path;
		File file=new File("a1.png");
		try {
			FileOutputStream fos =new FileOutputStream(file);
			fos.write(info.getImage());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 public void setRoot(Parent root) {
	 this.root=root;
 }
 public void setImage(int i) {
	 if(i==1) {
		 System.out.println(Image);; 
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image(path) );
	 }else if(i==2) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image(path) );
	 }else if(i==3) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image(path) );
	 }else if(i==4) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image(path) );
	 }
	 
 }
 public static boolean flag;
 public void clc01() {
	 //인연
	 String st=seat.getSoloSeat(seat2);
	st=st.substring(0,st.indexOf("/"));
	int in =Integer.parseInt(st);
	if(in==0) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("해당 영화는 매진되었습니다. 죄송합니다.");
		alert.show();
	}else {
		number();
		flag = false;
		SeatChart seatchart = new SeatChart();
		seatchart.start();
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
		
		
		
	}
	
	//System.out.println(st);
 }
 public void clc02() {
	//연인
	 String st2=seat.getCoupleSeat(seat2);
	 st2=st2.substring(0,st2.indexOf("/"));
		int in =Integer.parseInt(st2);
		if(in==0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("해당 영화는 매진되었습니다. 죄송합니다.");
			alert.show();
		}else {
			number();
			//연결 커플
			SeatChart seatchart = new SeatChart();
			seatchart.start();
			Stage window = (Stage)root.getScene().getWindow(); 
			window.close();
			
		}
 }
 
 public void number() {
	 movieInfomat moInfo =new movieInfomat();
	 moInfo.setMovieNum(info.getMovieNum());
	 moInfo.setMovieName(info.getMovieName());
	 moInfo.setScreeningTime(seat2.getScreeningttime());
	
 }

 public void stop() {
		
		try {
			 Stage stage = new Stage();
			 FXMLLoader loader = 
						new FXMLLoader(getClass().getResource("../movie01/EventMovie.fxml"));

				Parent root = loader.load();
				Scene scene = new Scene(root);

				Controller2 ctl = loader.getController();
				ctl.setRoot(root);
				stage.setScene(scene);
				stage.show();
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
}
 public void setInfo(movieInfomation_DTO info) {
	 this.info=info;
	 List();
 }
 public void List() {
	
		 Label cont =(Label)root.lookup("#cont");
	 cont.setText(info.getMovieComent());
 }
 
 

 public void clc03() { 
	 stop();
	 System.out.println(root);
	 Stage stage = (Stage)root.getScene().getWindow();
	 stage.close();
	 
 }
 
 
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}