package sjh;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import Login.User.UserMain;
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
import saveInfo.UserId;

public class RefundMain implements Initializable{
	@FXML private Button refund;
	@FXML private Button gomain;
	@FXML private Label moviename;
	@FXML private Label screeningtime;
	@FXML private Label seat;
	DBClass db = new DBClass();
	String data[] = new String[3];

	Parent root;
	public void setRoot(Parent root) {
		this.root= root;
	}
		
	public void refund() {
		db.del_DB(UserId.getId(), ListMain.selectMovieName, DBClass.selectedTime);
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
			Stage window = (Stage)refund.getScene().getWindow(); 
			window.close();
			refund_Alert();
		}
	
	public void refund_Alert() {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("환불완료");
		alert.setHeaderText("환불 완료되었습니다.");
		alert.setContentText("구매내역 창으로 이동합니다.");
		alert.show();
	}

	public void gomain() {
		UserMain UserMain = new UserMain();
		UserMain.User(); 
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
	}
	public static String screeningTime;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	//환불창 데이터
		db = new DBClass();	
		
		data = db.readDB2(UserId.getId(), ListMain.selectMovieName, data);
		SimpleDateFormat form= new SimpleDateFormat("MM/dd HH:mm");
		screeningTime=form.format(DBClass.selectedTime);
		
		moviename.setText(data[0]);
		seat.setText("좌석 번호 : "+ data[1]);
		screeningtime.setText(screeningTime);
	
	}
}
