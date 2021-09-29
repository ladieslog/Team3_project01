package Movie_KimCret.movieDb;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieInfoDAO{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static movieInfomation_DTO dao = new movieInfomation_DTO();
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
	
	public movieInfomation_DTO movieList(int movieNum) {
		con = connect();
		movieInfomation_DTO dto =null;
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_info WHERE movieNum = ? ");
			ps.setInt(1, movieNum);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new movieInfomation_DTO();
				dto.setMovieNum(rs.getInt(1));
				dto.setMovieName(rs.getString(2));
				dto.setMovieAvg(rs.getDouble(3));
				dto.setImage(rs.getBytes(4));
				dto.setMovieComent(rs.getString(5));
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
		return dto;
	}
}
