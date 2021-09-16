package kjh_test;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		/*
		Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.show();
		*/
		
		Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
        Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
        
        Scene scene = new Scene(root);

        arg0.setScene(scene);
        arg0.show();
	}
}
