package kjh_Manager.movieInfo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieListMain {

	public void movieList(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/kjh_Manager/movieInfo/MovieList.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		MovieListController mlc = loader.getController();
		mlc.setRoot(root);
		arg0.setScene(scene);
		arg0.show();
	}


}
