package Login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

	public class LoginMain extends Application {
		public static void main(String[] args) {
			launch(args);
		}
		
		public void start(Stage primaryStage) throws IOException {
			// TODO Auto-generated method stub
			Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			LoginController ctl = new LoginController();
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();	
			
		}
	}