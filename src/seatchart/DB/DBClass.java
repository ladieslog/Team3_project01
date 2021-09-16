package seatchart.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClass {
	public Connection conn;
	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public MovieDTO readDB_User(String InputId) {
		String sql = "select * from destinymovie_user where id= '"+InputId+ "'";
		MovieDTO dto = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {
				dto = new MovieDTO();
				dto.setId(rs.getString("id"));
				System.out.println(dto.getId());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public MovieDTO readDB_Seat(String InputId) {
		String sql = "select * from destinymovie_seat where id= '"+InputId+ "'";
		MovieDTO dto = null;
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
					
			if(rs.next()) {
				dto = new MovieDTO();
				dto.setId(rs.getString("id"));
				System.out.println(dto.getId());
				dto.setMovieNum(rs.getInt("movienum"));
				System.out.println("movienum : " + dto.getMovieNum());
				dto.setSeat(rs.getString("seat"));
				System.out.println("seat : " + dto.getSeat());
				dto.setReservation(rs.getInt("reservation"));
				System.out.println("reservation : " + dto.getReservation());
						
				dto.setId(rs.getString("id"));
				System.out.println(dto.getId());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int insertDB(MovieDTO dto) {
		setData();
		String sql = "insert into (id, movienum, screeningtime, seat, reservation, price) "
				+ "values(?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setInt(2, dto.getMovieNum());
			ps.setDate(3, dto.getScreeningTime());
			ps.setString(4, dto.getSeat());
			ps.setInt(5, dto.getReservation());
			ps.setInt(6, dto.getPrice());
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public void setData() {	// insert 하기 전 데이터 저장
		
	}
}
