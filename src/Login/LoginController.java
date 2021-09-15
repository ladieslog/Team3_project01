package Login;

import java.net.URL;
import java.util.ResourceBundle;

import Login.Manager.ManagerMain;
import Login.Member.MemberMain;
import Login.User.UserMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class LoginController implements Initializable {

	static Parent root;
	UserMain user;
	MemberMain member;
	ManagerMain manager;
	// 화면 옮길때마다 화면 꺼지고 돌아가기에서 다시 돌아와야함
	// 폰트   MoeumT R
	public void setRoot(Parent root) {
	 	this.root=root;	 
 	}

	public void membership() {		// 회원가입 창
		member.mamber();
		// 아이디 = fxId, 비밀번호 = fxPwd, 이름 = fxName, 생년 = fxBirth
		// 성별 = 토글 = gender 남 - fxMan, 여 - fxWoman / 연락처 = fxPhone
		cancle();
	}
	
	
	public void mainScreen() {		// db연결 후 id 비교해서 if문 이용
		user.User();
		cancle();
	}
	
	
	public void userLogin() {		// user 로그인 완료 후 뜨는 창
		user.User();
	}
	
	
	public void managerLogin() {	// 관리자 로그인 완료 후 뜨는 창
		manager.manager();
		cancle();
	}
	
	
	
	public void cancle() {
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		user = new UserMain();
		member = new MemberMain();
		manager = new ManagerMain();
	}
	
}