package movie_cret2;

import java.net.URL;
import java.util.ResourceBundle;

import Movie_KimCret.movie02.Controller;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class Controller2 implements Initializable{
	static Parent root;
	ImageView Image;
 public void setRoot(Parent root) {
	 this.root=root;
 }
 public void setImage(int i) {
	 if(i==1) {
		 System.out.println(Image);; 
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image("/img/a1.png/") );
	 }else if(i==2) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image("/img/a2.jpg/") );
	 }else if(i==3) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image("/img/a3.jpg/") );
	 }else if(i==4) {
		 Image =(ImageView)root.lookup("#images");
		 Image.setImage(new Image("/img/a4.jpg/") );
	 }
	 
 }
 public void btn1() {
	 
 }
 public void btn2() {
	 
 }
 public void img1() {
	 
 }
 public void stop2() {
		
		try {
			 Stage stage = new Stage();
			 FXMLLoader loader = 
						new FXMLLoader(getClass().getResource("../movie_cret/EventTest.fxml"));

				Parent root = loader.load();
				Scene scene = new Scene(root);

				Controller ctl = loader.getController();
				ctl.setRoot(root);
				stage.setScene(scene);
				stage.show();
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
}
 
 

 public void stop() { 
	 stop2();
	 System.out.println(root);
	 Stage stage = (Stage)root.getScene().getWindow();
	 stage.close();
	 
 }
 
 
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}
}