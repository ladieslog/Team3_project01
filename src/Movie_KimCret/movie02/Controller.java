package Movie_KimCret.movie02;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Movie_KimCret.movie01.Controller2;
import Movie_KimCret.movie03.ControllerView1;
import Movie_KimCret.movieDb.MovieInfoDAO;
import Movie_KimCret.movieDb.movieInfomation_DTO;
import Movie_KimCret.movieDb.movieSeatDAO;
import Movie_KimCret.movieDb.movieSeat_DTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class Controller implements Initializable{
	private static Parent root;	
	private static Date date;
	private static movieSeatDAO dao = movieSeatDAO.getInstance();
	private static MovieInfoDAO dao2 = new MovieInfoDAO();
	private TableView<movieSeatDAO> tableView;	
	private TableColumn movieName;
	private TableColumn screeningTime;
	private TableColumn coupleSeat;
	private TableColumn soloSeat;	
	private static Stage sacStage;	
	private static Timestamp time;
	private ArrayList<movieInfomation_DTO> llc= new ArrayList<movieInfomation_DTO>();
	private static String path;
	ImageView Image;
	private static ArrayList<movieSeat_DTO> seat;
	
	
	public void SetDate(Date date) {
		this.date=date;
		DBList();
	}
	public void SetDate2(ArrayList<movieSeat_DTO> seat) {
		this.seat=seat;
	}
	public void DBList() {
		//time =new Timestamp(date.getTime());		
		
		//ArrayList<movieSeat_DTO> seat = dao.seat(time);
		//System.out.println(llc);
		
			int i=0;
			for(movieSeat_DTO dto:seat) {
				i++;
				 Image =(ImageView)root.lookup("#img"+i);
				 Label week =(Label)root.lookup("#week"+i);
				 Label time =(Label)root.lookup("#time"+i);
				 Label title =(Label)root.lookup("#title"+i);
				 Label solo=(Label)root.lookup("#solo"+i);
				 Label couple =(Label)root.lookup("#couple"+i);
				 Label score =(Label)root.lookup("#score"+i);
				 SimpleDateFormat sim1= new SimpleDateFormat("MM/dd");
				 SimpleDateFormat sim2= new SimpleDateFormat("HH:mm");
				 String st1=sim1.format(new Date(dto.getScreeningttime().getTime()));
				 String st2=sim2.format(new Date(dto.getScreeningttime().getTime()));
				 
				 
				 
				 
				String couple2=dao.getCoupleSeat(dto);
				String solo2 = dao.getSoloSeat(dto);
				movieInfomation_DTO info=dao2.movieList(dto.getMovieNum());
				//System.out.println(info.getMovieName());
				File file =new File("a1.png");
				llc.add(info);
				// System.out.println(llc.get(i-1).getMovieName());
				
				
				
				try {
					FileOutputStream fos=new FileOutputStream(file);
					fos.write(info.getImage());
					fos.close();
					//System.out.println(file.toURI().toString());
					path=file.toURI().toString();
					Image.setImage(new Image(file.toURI().toString()) );
					
					
					week.setText(st1);
					time.setText(st2);
					title.setText(info.getMovieName());
					solo.setText(solo2);
					couple.setText(couple2);
					score.setText(String.valueOf(info.getMovieAvg()));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} 
			
		}
		
		
		//img1 img2 img3 img4  title1 title2 title3 title4 
		//solo1 solo2 solo3 solo4 couple1 couple2 couple3 couple4
		//score1 score2 score3 score4
		//time1 time2 time3 time4 week1 week2 week3 week4
		
		
	//}
		
	public void setRoot(Parent root) {
	 this.root=root;
	}
	public void img1() {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../movie03/EventMovie2.fxml"));
		Parent newRoot = null;
		Scene scene = null;
		try {
			newRoot = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scene = new Scene(newRoot);
		ControllerView1 con2=loader.getController();
		con2.setRoot(newRoot);
		con2.setInfo(llc.get(0));
		con2.setSeat(seat.get(0));
		System.out.println(llc.get(0).getMovieName());
		con2.setpath(path);
		
		con2.setImage(1);
		
		
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		
 }
 public void img2() {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../movie03/EventMovie2.fxml"));
		Parent newRoot = null;
		Scene scene = null;
		try {
			newRoot = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scene = new Scene(newRoot);
		ControllerView1 con2=loader.getController();
		con2.setRoot(newRoot);
		con2.setInfo(llc.get(1));
		con2.setSeat(seat.get(1));
		System.out.println(llc.get(1).getMovieName());
		
		con2.setpath(path);
		con2.setImage(2);
		
		
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
}
 public void img3() {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../movie03/EventMovie2.fxml"));
		Parent newRoot = null;
		Scene scene = null;
		try {
			newRoot = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scene = new Scene(newRoot);
		ControllerView1 con2=loader.getController();
		con2.setRoot(newRoot);
		con2.setInfo(llc.get(2));
		con2.setSeat(seat.get(2));
		System.out.println(llc.get(2).getMovieName());
		con2.setpath(path);
		con2.setImage(3);
		
		
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
}
 public void img4() {
	 
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../movie03/EventMovie2.fxml"));
		Parent newRoot = null;
		Scene scene = null;
		try {
			newRoot = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scene = new Scene(newRoot);
		ControllerView1 con2=loader.getController();
		con2.setRoot(newRoot);
		con2.setInfo(llc.get(3));
		con2.setSeat(seat.get(3));
		System.out.println(llc.get(3).getMovieName());
		con2.setpath(path);
		con2.setImage(4);
		
		
		
		Stage stage = (Stage)root.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
}
 public void stop() { 
	 stop2();
	 System.out.println(root);
	 Stage stage = (Stage)root.getScene().getWindow();
	 stage.close();
	 
 }
 
 public void stop2() {
		
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
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
	
}
}