package sjh;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import saveInfo.UserId;
import saveInfo.movieInfomat;
import Login.User.UserMain;

public class BillController implements Initializable{
	@FXML private Button checkbtn;
	@FXML private Button test3ch;
	@FXML private Label moviename;
	@FXML private Label screeningtime;
	@FXML private Label seat;
	@FXML private Label price;
	DBClass db;
	String data[] = new String[3];
	
	Parent root;
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void check() {
		
		UserMain UserMain = new UserMain();
		UserMain.User(); 
		payment_Alert();
		Stage window = (Stage)root.getScene().getWindow(); 
		window.close();
		
		
	}
	
	public void payment_Alert() {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("결제완료");
		alert.setHeaderText("결제가 완료되었습니다.");
		alert.setContentText("메인 창으로 이동합니다.");
		alert.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();		
		data = db.readDB(UserId.getId(), movieInfomat.getMovieName(), movieInfomat.getScreeningTime(), data);
		
		moviename.setText(data[0]);
		SimpleDateFormat form= new SimpleDateFormat("MM/dd HH:mm");
		String screeningTime=form.format(movieInfomat.getScreeningTime());
		screeningtime.setText(screeningTime);
		seat.setText("좌석 번호 : " + data[1]);
		price.setText("결제 금액 : " + data[2]);
	}
}