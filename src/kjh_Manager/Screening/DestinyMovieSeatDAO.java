package kjh_Manager.Screening;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DestinyMovieSeatDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DestinyMovieSeatDAO dao = new DestinyMovieSeatDAO();
	
	private DestinyMovieSeatDAO() {
		
	}
	
	public static DestinyMovieSeatDAO getInstance() {
		return dao;
	}
	
	private Connection connect() {
		try {
			// 자바에서 오라클 연결하기 위한 기타 기능들을 쓸 수 있게 라이브러리 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클과 연결된 객체를 가져옴
			con = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private void close(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public ArrayList<ScreeningDTO> getScreening() {
		ArrayList<ScreeningDTO> list = new ArrayList<>();
		con = connect();
		try {
			ps = con.prepareStatement("SELECT DISTINCT movieNum, SCREENINGTIME, movieName FROM destinymovie_seat ORDER BY SCREENINGTIME ASC");
			rs = ps.executeQuery();
			while(rs.next()) {
				ScreeningDTO dto = new ScreeningDTO();
				dto.setMovieNum(rs.getInt(1));
				dto.setScreeningTime(rs.getTimestamp(2));
				dto.setMovieName(rs.getString(3));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public String getCoupleSeat(ScreeningDTO dto) {
		con = connect();
		int sum = 0;
		int reservation = 0;
		String seatSituation= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat WHERE MOVIENUM = ? AND SCREENINGTIME = ? AND (SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningTime());
			rs = ps.executeQuery();
			while(rs.next()) {
				sum++;
			}
			
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat where movieNum=? AND SCREENINGTIME=? AND RESERVATION='0' AND (SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningTime());
			rs = ps.executeQuery();
			while(rs.next()) {
				reservation++;
			}
			
			seatSituation = reservation + "/" + sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seatSituation;
	}
	
	public String getSoloSeat(ScreeningDTO dto) {
		con = connect();
		int sum = 0;
		int reservation = 0;
		String seatSituation= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat WHERE MOVIENUM = ? AND SCREENINGTIME = ? AND NOT(SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningTime());
			rs = ps.executeQuery();
			while(rs.next()) {
				sum++;
			}
			
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat where movieNum=? AND SCREENINGTIME=? AND RESERVATION='0' AND NOT(SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningTime());
			rs = ps.executeQuery();
			while(rs.next()) {
				reservation++;
			}
			
			seatSituation = reservation + "/" + sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seatSituation;
	}
	
	public int getScreeningNum(Timestamp time) {
		con = connect();
		int screeningNum = 0;
		try {
			ps = con.prepareStatement("SELECT MAX(SCREENINGNUM) FROM destinymovie_seat WHERE TO_CHAR(?, 'yyyy/MM/dd') = TO_CHAR(SCREENINGTIME, 'yyyy/MM/dd')");
			ps.setTimestamp(1, time);
			rs = ps.executeQuery();
			if(rs.next()) {
				screeningNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return screeningNum;
	}
	
	public int insertScreening(int movieNum, Timestamp time, String seat, String movieName, String screeningNum) {
		con = connect();
		int result = 0;
		try {
			ps = con.prepareStatement("INSERT INTO destinymovie_seat VALUES(?, ?, ?, '0', null, null, ?, ?)");
			ps.setInt(1, movieNum);
			ps.setTimestamp(2, time);
			ps.setString(3, seat);
			ps.setString(4, movieName);
			ps.setString(5, screeningNum);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteScreening(Timestamp time) {
		con = connect();
		int result = 0;
		try {
			ps = con.prepareStatement("DELETE FROM destinymovie_seat WHERE TO_CHAR(?, 'yyyy/MM/dd HH24:MI') >= TO_CHAR(SCREENINGTIME, 'yyyy/MM/dd HH24:MI')");
			ps.setTimestamp(1, time);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
