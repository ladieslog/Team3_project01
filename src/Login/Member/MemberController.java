package Login.Member;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import Login.goBackMain;
import Login.Alert.AlertClass;
import Login.DB.LoginDB;
import Login.DB.LoginDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MemberController implements Initializable{
		
	static Parent root;
	goBackMain back;
	public LoginDB loginDb;
	AlertClass al;
	
	public void setRoot(Parent root) {
		this.root = root;
		TextField fxId = (TextField)root.lookup("#fxId");
		fxId.requestFocus();
	}
	
	public void back() {	// 돌아가기 버튼
		back.back();
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();
	}
	
	public boolean getGender() {
		RadioButton fxMan = (RadioButton)root.lookup("#fxMan");
		if( fxMan.isSelected() ) return false;
		else return true;
	}
	private String getId() {
		TextField fxId = (TextField)root.lookup("#fxId");
		return fxId.getText();
	}
	private String getPassword() {
		TextField fxPassword = (TextField)root.lookup("#fxPassword");
		return fxPassword.getText();
	}
	private String getName() {
		TextField fxName = (TextField)root.lookup("#fxName");
		return fxName.getText();
	}
	private String getBirth() {
		TextField fxBirth = (TextField)root.lookup("#fxBirth");
		return fxBirth.getText();
	}
	private String getTel() {
		TextField fxTel = (TextField)root.lookup("#fxTel");
		return fxTel.getText();
	}
	
	public void membership() {		// 회원가입 정보 db저장 후 메인창으로 가기
		// 아이디 = fxId, 비밀번호 = fxPassword, 이름 = fxName, 생년 = fxBirth
		// 성별 = 토글 = gender 남 - fxMan, 여 - fxWoman / 연락처 = fxTel
		LoginDTO dto = new LoginDTO();
	//	String msg= null;
		
	//	check();
		TextField fxId = (TextField)root.lookup("#fxId");
		TextField fxPassword = (TextField)root.lookup("#fxPassword");
		TextField fxName = (TextField)root.lookup("#fxName");
		TextField fxBirth = (TextField)root.lookup("#fxBirth");
		TextField fxTel = (TextField)root.lookup("#fxTel");
		RadioButton fxMan = (RadioButton)root.lookup("#fxMan");
		RadioButton fxWoman = (RadioButton)root.lookup("#fxWoman");
		String msg= null;
	//	loginDb.loginchk(getId());
		if(fxId.getText().isEmpty()){
			msg = "ID를 입력하세요";
			fxId.requestFocus();
		/*	if(fxId.getText().equals(loginDb.loginchk(getId()) {
				msg = "중복된 ID입니다";
				fxId.requestFocus();
			}*/
		}else if(fxPassword.getText().isEmpty()) {
			msg = "Password를 입력하세요";
			fxPassword.requestFocus();
		}else if(fxName.getText().isEmpty()) {
			msg = "이름을 입력하세요";
			fxName.requestFocus();
		}else if(fxBirth.getText().isEmpty()) {
			msg = "생년월일을 입력하세요";
			fxBirth.requestFocus();
		}else if (!fxMan.isSelected() && !fxWoman.isSelected() ){
			msg = "성별을 선택하세요";
		}
		else if(fxTel.getText().isEmpty()) {
			msg = "연락처를 입력하세요";
			fxTel.requestFocus();
		}else {
			dto.setId(getId());
			dto.setPassword(getPassword());
			dto.setName(getName());
			dto.setGender(getGender());
			dto.setTel(getTel());
			dto.setBirth(getBirth());		
			loginDb.insert(dto);
			back();  
			msg="회원가입 성공";
		}
		al.alert(msg);
		
	/*	dto.setId(getId());
		dto.setPassword(getPassword());
		dto.setName(getName());
		dto.setBirth(getBirth());
		dto.setTel(getTel());
		dto.setGender(getGender());
		loginDb.insert(dto);
		back();  
		msg="회원가입 성공";
		al.alert(msg);*/
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		back = new goBackMain();
		loginDb = new LoginDB();
		al = new AlertClass();
	}
}
