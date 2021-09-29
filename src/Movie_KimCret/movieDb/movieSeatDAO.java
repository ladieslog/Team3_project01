package Movie_KimCret.movieDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class movieSeatDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static movieSeatDAO dao = new movieSeatDAO();
	
	private movieSeatDAO() {
		
	}
	
	public static movieSeatDAO getInstance() {
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
	public ArrayList<movieSeat_DTO> getScreening() {
		ArrayList<movieSeat_DTO> list = new ArrayList<>();
		con = connect();
		try {
			ps = con.prepareStatement("SELECT DISTINCT MOVIENUM, SCREENINGTIME, M FROM destinymovie_seat ORDER BY SCREENINGTIME ASC");
			rs = ps.executeQuery();
			while(rs.next()) {
				movieSeat_DTO dto = new movieSeat_DTO();
				dto.setMovieNum(rs.getInt(1));
				dto.setScreeningttime(rs.getTimestamp(2));
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
	
	public String getCoupleSeat(movieSeat_DTO dto) {
		con = connect();
		int sum = 0;
		int reservation = 0;
		String seatSituation= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat WHERE MOVIENUM = ? AND SCREENINGTIME = ? AND (SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningttime());
			rs = ps.executeQuery();
			while(rs.next()) {
				sum++;
			}
			
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat where movieNum=? AND SCREENINGTIME=? AND RESERVATION='0' AND (SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningttime());
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
	
	public String getSoloSeat(movieSeat_DTO dto) {
		con = connect();
		int sum = 0;
		int reservation = 0;
		String seatSituation= null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat WHERE MOVIENUM = ? AND SCREENINGTIME = ? AND NOT(SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningttime());
			rs = ps.executeQuery();
			while(rs.next()) {
				sum++;
			}
			
			ps = con.prepareStatement("SELECT * FROM destinymovie_seat where movieNum=? AND SCREENINGTIME=? AND RESERVATION='0' AND NOT(SEAT LIKE '%1' OR SEAT LIKE '%6')");
			ps.setInt(1, dto.getMovieNum());
			ps.setTimestamp(2, dto.getScreeningttime());
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
	public ArrayList<movieSeat_DTO> seat(Timestamp time){
		con = connect();
		ArrayList<movieSeat_DTO> arr=new ArrayList<movieSeat_DTO>();
		try {
			ps= con.prepareStatement("SELECT DISTINCT MovieNum, SCREENINGTIME FROM destinymovie_seat WHERE TO_CHAR(?, 'yyyy/MM/dd') = TO_CHAR(SCREENINGTIME, 'yyyy/MM/dd') ORDER BY SCREENINGTIME ASC");
			ps.setTimestamp(1, time);
			rs= ps.executeQuery();
				while(rs.next()) {
				
				movieSeat_DTO seatDto = new movieSeat_DTO();
				seatDto.setMovieNum(rs.getInt(1));
				seatDto.setScreeningttime(rs.getTimestamp(2));
				arr.add(seatDto);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr;
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
	
}
