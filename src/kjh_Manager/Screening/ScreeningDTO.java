package kjh_Manager.Screening;

import java.sql.Timestamp;

public class ScreeningDTO {
	private int movieNum;
	private String movieName;
	private Timestamp screeningTime;
	private String time;
	private String coupleSeat;
	private String soloSeat;
	
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Timestamp getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(Timestamp screeningTime) {
		this.screeningTime = screeningTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCoupleSeat() {
		return coupleSeat;
	}
	public void setCoupleSeat(String coupleSeat) {
		this.coupleSeat = coupleSeat;
	}
	public String getSoloSeat() {
		return soloSeat;
	}
	public void setSoloSeat(String soloSeat) {
		this.soloSeat = soloSeat;
	}
	
	
	
}
