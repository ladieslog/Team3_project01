package Login.Manager;

import Login.User.UserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerMain {
	public void manager() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login/ManagerLogin.fxml"));
			Parent root = loader.load();
			
			ManagerController mc = new ManagerController();
			mc.setRoot(root);
			
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}



