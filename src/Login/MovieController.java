package Login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MovieController implements Initializable {
	static Parent root;
	static MediaPlayer mediaPlayer;
    MediaView mediaView;
    Button btnPlay;
    goBackMain go;
	
	public void setRoot(Parent root) {
		this.root = root;
		setMedia(root, "prom4v.m4v");
	}
	
	public void myPlay() {	// 동영상 시작하기
		mediaPlayer.play();
		
		mediaPlayer.setOnEndOfMedia(()->{ // 동영상 끝나고 다시 처음으로
			mediaPlayer.stop(); 
		});
	}
	
	public void setMedia(Parent root, String mediaName) {
		mediaView = (MediaView)root.lookup("#fxMediaView");
		Media media = new Media( getClass().getResource(mediaName).toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(100.0);
        mediaView.setMediaPlayer(mediaPlayer);
	}
	
	public void reservation() {
		mediaPlayer.stop();
		go.back();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		go = new goBackMain();
	}

}