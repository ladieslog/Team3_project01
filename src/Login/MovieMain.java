package Login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class MovieMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("movie.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		MovieController ctl = loader.getController();
		ctl.setRoot(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}
	
}