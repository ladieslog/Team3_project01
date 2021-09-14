
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import movie_cret.Controller;

public class Mainclass extends Application{
	@Override
	public void start(Stage arg0) throws Exception {
		Font.loadFont(getClass().getResourceAsStream("../Resources/HMFMMUEX.ttf"), 50);
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("../movie_cret/EventTest.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);

		Controller ctl = loader.getController();
		ctl.setRoot(root);

		arg0.setScene(scene);
		arg0.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
