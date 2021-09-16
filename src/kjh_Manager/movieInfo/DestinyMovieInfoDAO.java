package kjh_Manager.movieInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DestinyMovieInfoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DestinyMovieInfoDAO dao = new DestinyMovieInfoDAO();
	
	private DestinyMovieInfoDAO() {
		
	}
	
	public static DestinyMovieInfoDAO getInstance() {
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
	
	public ArrayList<DestinyMovieInfoDTO> movieList() {
		con = connect();
		ArrayList<DestinyMovieInfoDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_info ORDER BY movieNum ASC");
			rs = ps.executeQuery();
			while(rs.next()) {
				DestinyMovieInfoDTO dto = new DestinyMovieInfoDTO();
				dto.setMovieNum(rs.getInt(1));
				dto.setMovieName(rs.getString(2));
				dto.setMovieAvg(rs.getDouble(3));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int removeMovie(int movieNum) {
		con = connect();
		int result = 0;
		try {
			ps = con.prepareStatement("DELETE FROM destinymovie_info WHERE movieNum = ?");
			ps.setInt(1, movieNum);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
