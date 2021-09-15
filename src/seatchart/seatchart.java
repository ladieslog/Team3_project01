package seatchart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class seatchart implements Initializable{
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void start() {
		System.out.println("좌석 배치도 보기");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("../seatchart/seatchart.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			seatchart ctl = loader.getController();						
			ctl.setRoot(root);
			primaryStage.setTitle("좌석 배치도");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void selectSeat() {
		Button A1 = (Button)root.lookup("#A1");
		Button B1 = (Button)root.lookup("#B1");
		Button A6 = (Button)root.lookup("#A6");
		
		A1.setOnAction(event -> {
		     if("-fx-background-color: pink".equals(A1.getStyle())){  
		    	 A1.setStyle("-fx-background-color: red");   
		    	 System.out.println("A1좌석 선택됨");
		     }
		     else{
		    	 System.out.println("A1좌석 선택 해제");
		    	 A1.setStyle("-fx-background-color: pink");  
		     }
		});
		
		B1.setOnAction(event -> {
		     if("-fx-background-color: pink".equals(B1.getStyle())){  
		    	 System.out.println("B1좌석 선택됨");
		    	 B1.setStyle("-fx-background-color: red");  	  
		     }
		     else{
		    	 B1.setStyle("-fx-background-color: pink"); 
		    	 System.out.println("B1좌석 선택 해제"); 
		     }
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
