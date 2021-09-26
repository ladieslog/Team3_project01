package sjh;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BillController implements Initializable{
	@FXML private Button checkbtn;
	@FXML private Button test3ch;
	@FXML private Label moviename;
	@FXML private Label screeningtime;
	@FXML private Label seat;
	DBClass db = new DBClass();

	Parent root;
	public void setRoot(Parent root) {
		this.root= root;
	}
	
	public void check() {
		Stage window = (Stage)checkbtn.getScene().getWindow(); 
		window.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sjh/test3.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Test3 ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("Test3");
			Stage.setScene(scene);
			Stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String selectUserId;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		selectUserId = "qwe";
		db.readDB(selectUserId);
		moviename.setText(MovieDTO.getMovieName());
		screeningtime.setText(MovieDTO.getScreeningTime());
		seat.setText(MovieDTO.getSeat());
	}
	
	
}
	
	

	

