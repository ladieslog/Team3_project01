package kjh_test;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Image roses = new Image(getClass().getResourceAsStream("test.png"));
		ImageView iv = new ImageView(roses);
		FlowPane fp = new FlowPane();
		fp.getChildren().add(iv);
		Scene scene = new Scene(fp);
		arg0.setScene(scene);
		arg0.show();
	}
}
