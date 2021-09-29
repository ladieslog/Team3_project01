package Login.Alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertClass {
	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("");					
		alert.setContentText(msg);
		alert.show();
	}
}
