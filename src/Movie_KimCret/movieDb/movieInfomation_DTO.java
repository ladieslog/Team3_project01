package Movie_KimCret.movieDb;

public class movieInfomation_DTO {
	private int MovieNum;
	private String MovieName;
	private Double MovieAvg;
	private byte[] Image;
	private String MovieComent;
	public Double getMovieAvg() {
		return MovieAvg;
	}
	public void setMovieAvg(Double movieAvg) {
		MovieAvg = movieAvg;
	}

	public int getMovieNum() {
		return MovieNum;
	}
	public void setMovieNum(int movieNum) {
		MovieNum = movieNum;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	

	public byte[] getImage() {
		return Image;
	}
	public void setImage(byte[] image) {
		Image = image;
	}
	public String getMovieComent() {
		return MovieComent;
	}
	public void setMovieComent(String movieComent) {
		MovieComent = movieComent;
	}

}
