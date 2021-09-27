package kjh_Manager.Screening;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreeningListMain {

	
	public void screeningList(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/Screening/ScreeningList.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		ScreeningListController slc = loader.getController();
		slc.setRoot(root);
		
		arg0.setScene(scene);
		arg0.show();
	}

}
