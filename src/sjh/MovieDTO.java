package sjh;

public class MovieDTO {
	   private String id;
	   private int movieNum;
	   private static String screeningTime;
	   private static String seat;
	   private String resrtvation;
	   private String name;
	   private String password;
	   private static String moviename;
	   private static String[] moviename1=new String[4];
	   
	   
	   public String getId() {
	      return id;
	   }
	   public void setId(String id) {
	      this.id = id;
	   }  
	    public static String getMovieName1(int space) {
		return moviename1[space];
	}
	public void setMovieName1(int space,String moviename1) {
		MovieDTO.moviename1[space] = moviename1;
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
			MovieDTO.screeningTime = screeningTime;
		}
		public static String getMovieName() {
			return moviename;
		}
		public void setMovieName(String moviename) {
			MovieDTO.moviename = moviename;
		}
		public static String getSeat() {
			return seat;
		}
		public void setSeat(String seat) {
			MovieDTO.seat = seat;
		}
			public String getResrtvation() {
		      return resrtvation;
	   }
	   public void setResrtvation(String resrtvation) {
	      this.resrtvation = resrtvation;
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