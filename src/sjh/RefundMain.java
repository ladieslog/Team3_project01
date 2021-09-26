package sjh;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RefundMain implements Initializable{
	@FXML private Button refund;
	@FXML private Button gomain;
	@FXML private Label moviename;
	@FXML private Label screeningtime;
	@FXML private Label seat;
	DBClass db = new DBClass();
	
	Parent root;
	public void setRoot(Parent root) {
		this.root= root;
	}
		
	
	public void refund() {
		DBClass.del_DB(BillController.selectUserId, ListMain.selectMovieName);

		Stage window = (Stage)refund.getScene().getWindow(); 
		window.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sjh/BillList.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			ListMain ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("BillList");
			Stage.setScene(scene);
			Stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		alert();
		}
	
	public void alert() {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("환불완료");
		alert.setHeaderText("환불 완료되었습니다.");
		alert.setContentText("결제내역 창으로 이동합니다.");
		alert.show();
	}
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db.readDB2("qwe", ListMain.selectMovieName );
		moviename.setText(MovieDTO.getMovieName());
		screeningtime.setText(MovieDTO.getScreeningTime());
		seat.setText(MovieDTO.getSeat());
	}

	public void gomain() {
		Stage window = (Stage)gomain.getScene().getWindow(); 
		window.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sjh/test3.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Test3 ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("test3");
			Stage.setScene(scene);
			Stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
