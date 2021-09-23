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
		System.out.println("readDB_User실행");
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
	
	public MovieDTO readDB_Seat(int movieNum, String screeningtime, String[] arr) {	// 이미 예매완료된 좌석 표시를 위함
		System.out.println("readDB_Seat실행");
		String sql = "select seat from destinymovie_seat where reservation=1 and movienum = "+movieNum+ "and screeningtime = '"+screeningtime+"'";
		MovieDTO dto = null;	
		int i=0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			System.out.println(screeningtime + "-"+ movieNum +"번 영화 조회");
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setSeat(i, rs.getString("seat"));
				arr[i] = dto.getSeat(i);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public MovieDTO readDB_ForPay(String id, int movieNum, String screeningtime) {	// 결제용 데이터 read
		System.out.println("readDB_Seat실행");
		String sql = "select seat from destinymovie_seat where id = '"+id+"' and reservation= 0 and movienum = "+movieNum+ "and screeningtime = '"+screeningtime+"'";
		MovieDTO dto = null;	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			System.out.println("결제를 위한 데이터 조회");
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setId(rs.getString("id"));
				dto.setSeat(0, rs.getString("seat"));
				dto.setMovieNum(rs.getInt("movienum"));
				dto.setScreeningTime(rs.getDate("screeningtime"));
				dto.setReservation(rs.getInt("reservation"));
				dto.setPrice(rs.getInt("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int insertDB(String id, int MovieNum, String ScreeningTime, String SeatNum, int Reservation, int Price) {
		String sql = "insert into destinymovie_seat(id, movienum, screeningtime, seat, reservation, price) "
				+ "values(?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, MovieNum);
			ps.setString(3, ScreeningTime);
			ps.setString(4, SeatNum);
			ps.setInt(5, Reservation);
			ps.setInt(6, Price);
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int reservation(String id, int movieNum, String screeningtime) {	//	reservation 1로 업데이트
		String sql = "update destinymovie_seat set reservation=1 where id = '"+id+"' and movienum = "+movieNum+ "and screeningtime = '"+screeningtime+"'";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int del_Reservation(String id, int movieNum, String screeningtime) {	//	진행중이던 결제 정보 삭제
		String sql = "delete from destinymovie_seat where id = '"+id+"' and movienum = "+movieNum+ "and screeningtime = '"+screeningtime+"'";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
