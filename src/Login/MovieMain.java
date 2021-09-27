package Login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import timeThread.TimeThread;

public class MovieMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws IOException {
		TimeThread time = new TimeThread();
		Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
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