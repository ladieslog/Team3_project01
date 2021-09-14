package Login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


	public class LoginMain extends Application {
		public static void main(String[] args) {
			launch(args);
		}
		@Override
		public void start(Stage primaryStage) throws IOException {
			// TODO Auto-generated method stub
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("Main.fxml"));

			Parent root = loader.load();
			Scene scene = new Scene(root);

			LoginController ctl = new LoginController();
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();		
		}
	}

