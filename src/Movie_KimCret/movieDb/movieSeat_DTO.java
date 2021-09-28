package Movie_KimCret.movieDb;

import java.sql.Timestamp;

public class movieSeat_DTO {
	private int MovieNum;
	private Timestamp Screeningttime;
	private String Seat;
	private String Reservattion;
	private String Id;
	private int Price;
	private String ScreeningNum;
	private String MovieName;

	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public String getScreeningNum() {
		return ScreeningNum;
	}
	public void setScreeningNum(String screeningNum) {
		ScreeningNum = screeningNum;
	}
	public int getMovieNum() {
		return MovieNum;
	}
	public void setMovieNum(int movieNum) {
		MovieNum = movieNum;
	}
	public Timestamp getScreeningttime() {
		return Screeningttime;
	}
	public void setScreeningttime(Timestamp screeningttime) {
		Screeningttime = screeningttime;
	}
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String seat) {
		Seat = seat;
	}
	public String getReservattion() {
		return Reservattion;
	}
	public void setReservattion(String reservattion) {
		Reservattion = reservattion;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
}
