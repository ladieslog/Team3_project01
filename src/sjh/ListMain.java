package sjh;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListMain implements Initializable{
	DBClass db = new DBClass();
	@FXML private Button moviename1;
	@FXML private Button moviename2;
	@FXML private Button moviename3;
	@FXML private Button moviename4;
	@FXML private Button mainbtn;
	
	Parent root;
	public void setRoot(Parent root) {
		this.root= root;
	}
	
    public void mainbtn () {
	    Stage window = (Stage)mainbtn.getScene().getWindow(); 
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
        
    public static String selectMovieName;
    public void ClickMovieName(ActionEvent e) {
		selectMovieName = ((Button)e.getTarget()).getText();
		System.out.println("선택 영화 : " + selectMovieName);
		gorefund();
    }
    
    public void gorefund () {
    	Stage window = (Stage)mainbtn.getScene().getWindow(); 
	    window.close();
		try {
			Stage Stage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("/sjh/Refund.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			RefundMain ctl = loader.getController();						
			ctl.setRoot(root);
			Stage.setTitle("Refund");
			Stage.setScene(scene);
			Stage.show();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static boolean refundFlag = false;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String[] movieNameList = new String[4];		
		db.readDB1(BillController.selectUserId, movieNameList);
		
		moviename1.setText(movieNameList[0]);	
		moviename2.setText(movieNameList[1]);
		moviename3.setText(movieNameList[2]);
		moviename4.setText(movieNameList[3]);
		
	}	
}

