package seatchart.DB;

import java.sql.Date;

public class MovieDTO {
	private String id;
	private String name;
	private String password;
	private int movieNum;
	private Date screeningTime;
	private String seat;
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
	public Date getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(Date screeningTime) {
		this.screeningTime = screeningTime;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getReservation() {
		return reservation;
	}
	
	public void setReservation(int resrtvation) {
		this.reservation = resrtvation;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password ) {
		this.password = password;
		
	}
}
