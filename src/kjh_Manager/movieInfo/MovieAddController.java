package kjh_Manager.movieInfo;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MovieAddController implements Initializable{
	
	private static Stage stage;
	private static Parent root;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void imageAdd() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(stage);

	}
	
	public void movieAdd() {
		
	}
	
	public void back() {
		stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
}
