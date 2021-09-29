package sys_SeatChart.DB;

public class SeatChartDTO {
	private String id;
	private int movieNum;
	private String movieName;
	private String screeningTime;
	private String[] seat = new String[30];
	private int reservation;
	private int price;
	private byte[] image ;
	
	public  int getPrice() {
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
	public  String getScreeningTime() {
		return screeningTime;
	}
	public void setScreeningTime(String screeningTime) {
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
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
