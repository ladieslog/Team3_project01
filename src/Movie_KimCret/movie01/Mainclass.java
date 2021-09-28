package Movie_KimCret.movie01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Mainclass extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		Font.loadFont(getClass().getResourceAsStream("../Resources/HMFMMUEX.ttf"), 50);
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("EventMovie.fxml"));

		Parent root = loader.load();
		
		Scene scene = new Scene(root);

		Controller2 ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
