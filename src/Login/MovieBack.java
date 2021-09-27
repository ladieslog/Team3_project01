package Login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MovieBack {
	public void movieBack() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("movie.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			MovieController mtl = new MovieController();
			mtl.setRoot(root);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
