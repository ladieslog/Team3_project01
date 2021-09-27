package movie_cret4.copy;

import java.net.URL;
import java.util.ResourceBundle;

import Movie_KimCret.movie02.Controller;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Controller4 implements Initializable{
	static Parent root;
 public void setRoot(Parent root) {
	 this.root=root;
 }

 public void clc01() {
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
 
 

 public void clc02() { 
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