package kjh_Manager.userInfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserListMain {

	
	public void userList(Stage arg0) throws Exception {
		Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/userInfo/UserList.fxml"));
		Parent root = loader.load();
		
		UserListController ulc = loader.getController();
		ulc.setRoot(root);
		
		Scene scene = new Scene(root);
		
		arg0.setScene(scene);
		arg0.show();
		

	}

}
