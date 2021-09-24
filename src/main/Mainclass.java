package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Mainclass extends Application{
	
	public void start(Stage Stage) throws Exception{
		 
		Font.loadFont(getClass().getResourceAsStream("../Resources/HMFMMUEX.ttf"), 50);
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);

        Stage.setScene(scene);
        Stage.show();
    }
 
    public static void main(String[] args) {
    	System.out.println("3조 프로젝트 시작");
    	launch(args);
    }

}