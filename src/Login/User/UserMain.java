package Login.User;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UserMain {
	public void User() {
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/Login/UserLogin.fxml"));
			Parent root = loader.load();
			
			UserController uc = new UserController();
			uc.setRoot(root);
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

