package seatchart.DB;

import java.sql.Timestamp;

public class MovieDTO {
	private String id;
	private int movieNum;
	private Timestamp screeningTime;
	private String[] seat = new String[30];
	private int reservation;
	private int price;
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public Timestamp getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(Timestamp screeningTime) {
		this.screeningTime = screeningTime;
	}
	public String getSeat(int i) {
		return seat[i];
	}
	public void setSeat(int i, String seat) {
		this.seat[i] = seat;
	}
	public int getReservation() {
		return reservation;
	}
	public void setReservation(int resrtvation) {
		this.reservation = resrtvation;
	}
}
