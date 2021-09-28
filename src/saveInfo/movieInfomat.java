package saveInfo;

import java.sql.Timestamp;

public class movieInfomat {
	private static String movieName;
	private static int movieNum;
	public static String getMovieName() {
		return movieName;
	}
	public static void setMovieName(String movieName) {
		movieInfomat.movieName = movieName;
	}
	public static int getMovieNum() {
		return movieNum;
	}
	public static void setMovieNum(int movieNum) {
		movieInfomat.movieNum = movieNum;
	}
	public static Timestamp getScreeningTime() {
		return screeningTime;
	}
	public static void setScreeningTime(Timestamp screeningTime) {
		movieInfomat.screeningTime = screeningTime;
	}
	private static Timestamp screeningTime;
}
