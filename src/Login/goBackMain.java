package Login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class goBackMain {
	public void back() {
		try {
			
			Stage stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("MainScreen.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			LoginController ctl = new LoginController();
			ctl.setRoot(root);
			
			stage.setScene(scene);
			stage.show();	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
