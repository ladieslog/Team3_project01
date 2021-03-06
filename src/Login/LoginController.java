package Login;

import java.net.URL;
import java.util.ResourceBundle;


import Login.DB.LoginDTO;
import Login.Manager.ManagerMain;
import Login.Member.MemberMain;
import Login.User.UserMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import saveInfo.UserId;
import sjh.ListMain;
import timeThread.TimeThread;

public class LoginController implements Initializable {
	static Parent root;
	UserMain user;
	MemberMain member;
	ManagerMain manager;
	Login.DB.LoginDB db;
	Login.Alert.AlertClass al;
	MovieBack movie;
	UserId userId;
	// 화면 옮길때마다 화면 꺼지고 돌아가기에서 다시 돌아와야함
	// 폰트   MoeumT R
	public void setRoot(Parent root) {
	 	this.root=root;	 
	 	TextField id = (TextField)root.lookup("#inId");
	 	id.requestFocus();
 	}

	public void membership() {		// 회원가입 창
		TimeThread tt = new TimeThread();
		member.mamber();
		cancle();
	}
	
	public void mainScreen() {		// db연결 후 id 비교해서 if문 이용
		TextField id = (TextField)root.lookup("#inId");
		PasswordField pwd = (PasswordField)root.lookup("#inPassword");
		
		LoginDTO dto = db.loginchk( id.getText() );
		String msg =null;
		
		if(dto == null) {
			msg = "해당 아이디는 존재하지 않습니다";
			id.requestFocus();
		}else if(id.getText().equals("team03")) {
			if(pwd.getText().equals("3333")) {
				TimeThread tt = new TimeThread();
				msg = "관리자 로그인 성공";
				manager.manager();
				cancle();
			}
			else {
				msg = "비밀번호가 틀렸습니다";
				pwd.requestFocus();
			}
		}
		else if(dto.getId().equals(id.getText())){
			if(dto.getPassword().equals(pwd.getText())) {
				TimeThread tt = new TimeThread();
				msg  = "로그인 성공";
				UserId.setId(dto.getId());
				System.out.println(UserId.getId());
				user.User();
				cancle();
			}else {
				msg = "비밀번호가 틀렸습니다";
				pwd.requestFocus();
			}	
		}
		al.alert(msg);
	}	
/*	
	public void id() {
		UserId id = new UserId();
		System.out.println(db.loginchk(id.getText()));
	}
	*/
	
	
	public void userLogin() {		// user 로그인 완료 후 뜨는 창
		ListMain ListMain = new ListMain();
		ListMain.gorefund();
	}
	
	/*public void managerLogin() {	// 관리자 로그인 완료 후 뜨는 창
		manager.manager();
		cancle();
	}*/
	
	public void backMovie() {
		TimeThread tt = new TimeThread();
		movie.movieBack();
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
		db = new Login.DB.LoginDB();
		al = new Login.Alert.AlertClass();
		movie = new MovieBack();
		userId = new UserId();
	}
	
	
}