package sys_SeatChart.DB;

public class SeatChartDTO {
	private String id;
	private int movieNum;
	private static String movieName;
	private static String screeningTime;
	private static String[] seat = new String[30];
	private int reservation;
	private static int price;
	
	public static int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		SeatChartDTO.price = price;
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
	public static String getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(String screeningTime) {
		SeatChartDTO.screeningTime = screeningTime;
	}
	public static String getSeat(int i) {
		return seat[i];
	}
	public void setSeat(int i, String seat) {
		SeatChartDTO.seat[i] = seat;
	}
	public int getReservation() {
		return reservation;
	}
	public void setReservation(int resrtvation) {
		this.reservation = resrtvation;
	}
	public static String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		SeatChartDTO.movieName = movieName;
	}
}
