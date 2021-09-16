package kjh_Manager.userInfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserListMain extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Font.loadFont(getClass().getResourceAsStream("/Resources/HMFMMUEX.ttf"), 50);
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/userInfo/UserList.fxml"));
		Parent root = loader.load();
		
		UserListController ulc = loader.getController();
		ulc.setRoot(root);
		
		Scene scene = new Scene(root);
		
		arg0.setScene(scene);
		arg0.show();
		
		
		/*
		AnchorPane ap = new AnchorPane();
		
		Scene scene = new Scene(ap, 300, 500);
		ScrollPane sp = new ScrollPane();
		sp.setMinSize(225, 325);
		
		AnchorPane spap = new AnchorPane();
		
		spap.setMinSize(225, 325);
		
		sp.getChildrenUnmodifiable().add(spap);
		
		ap.setLeftAnchor(sp, 30.0);
		ap.setTopAnchor(sp, 20.0);
		ap.getChildren().add(sp);
		
		arg0.setScene(scene);
		arg0.show();
		*/
	}

}
