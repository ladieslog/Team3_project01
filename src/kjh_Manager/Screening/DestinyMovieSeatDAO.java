package kjh_Manager.Screening;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			ps = con.prepareStatement("SELECT DISTINCT movieNum, SCREENINGTIME, movieName FROM destinymovie_seat");
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
	
	public String getSeatSituation(ScreeningDTO dto) {
		con = connect();
		int sum = 0;
		int reservation = 0;
		String seatSituation= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat WHERE MOVIENUM = ? AND SCREENINGTIME = ?");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningTime());
			rs = ps.executeQuery();
			while(rs.next()) {
				sum++;
			}
			
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat where movieNum=? AND SCREENINGTIME=? AND RESERVATION='1'");
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
}
