package sjh;

public class MovieDTO {
	   private String id;
	   private int movieNum;
	   private String screeningTime;
	   private String seat;
	   private String name;
	   private String moviename;
	   private String[] moviename1=new String[4];
	   
	   
	   public String getId() {
	      return id;
	   }
	   public void setId(String id) {
	      this.id = id;
	   }  
	    public String getMovieName1(int space) {
		return moviename1[space];
	}
	public void setMovieName1(int space,String moviename1) {
		this.moviename1[space] = moviename1;
	}
		public int getMovieNum() {
		return movieNum;
		}
		public void setMovieNum(int movieNum) {
			this.movieNum = movieNum;
		}
		public String getScreeningTime() {
			return screeningTime;
		}
		public void setScreeningTime(String screeningTime) {
			this.screeningTime = screeningTime;
		}
		public String getMovieName() {
			return moviename;
		}
		public void setMovieName(String moviename) {
			this.moviename = moviename;
		}
		public String getSeat() {
			return seat;
		}
		public void setSeat(String seat) {
			this.seat = seat;
		}
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {
		  this.name = name;
	   }
	   
		   
		   
	}