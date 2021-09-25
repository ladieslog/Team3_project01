package seatchart.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

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
		String sql = "select * from destinymovie_user where id= ?";
		MovieDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, InputId);
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
	
	public MovieDTO readDB_Seat(int movieNum, Timestamp screeningtime, String[] arr) {	// 이미 예매완료된 좌석 표시를 위함
		System.out.println("readDB_Seat실행");
		String sql = "select seat from destinymovie_seat where reservation = '1' and movienum = ? and screeningtime = ?";
		MovieDTO dto = null;	
		int i=0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, movieNum);
			ps.setTimestamp(2, screeningtime);
			ResultSet rs = ps.executeQuery(); 
			System.out.println(screeningtime + "-"+ movieNum +"번 영화 조회");
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setSeat(i, rs.getString("seat"));
				System.out.println(dto.getSeat(i));
				arr[i] = dto.getSeat(i);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
		
	}
	
	public MovieDTO readDB_ForPay(String id, int movieNum, Timestamp screeningtime) {	// 결제용 데이터 read
		System.out.println("readDB_ForPay실행");
		String sql = "select * from destinymovie_seat where id = ? and reservation= '0' and movienum = ? and screeningtime = ?";
		MovieDTO dto = null;	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, movieNum);
			ps.setTimestamp(3, screeningtime);
			ResultSet rs = ps.executeQuery(); 
			System.out.println("결제를 위한 데이터 조회");
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setId(rs.getString("id"));
				dto.setSeat(0, rs.getString("seat"));
				dto.setMovieNum(rs.getInt("movienum"));
				dto.setScreeningTime(rs.getTimestamp("screeningtime"));
				dto.setReservation(rs.getInt("reservation"));
				dto.setPrice(rs.getInt("price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int insertDB(String id, int MovieNum, Timestamp screenTimestamp, String SeatNum, int Reservation, int Price, String movieName, String ScreeningNum ) {
		String sql = "insert into destinymovie_seat(id, movienum, screeningtime, seat, reservation, price, moviename, screeningnum) "
				+ "values(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, MovieNum);
			ps.setTimestamp(3, screenTimestamp);
			ps.setString(4, SeatNum);
			ps.setInt(5, Reservation);
			ps.setInt(6, Price);
			ps.setString(7, movieName);
			ps.setString(8, ScreeningNum);

			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int reservation(String id, int movieNum, Timestamp screeningtime) {	//	reservation 1로 업데이트
		String sql = "update destinymovie_seat set reservation='1' where id = ? and movienum = ? and screeningtime = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, movieNum);
			ps.setTimestamp(3, screeningtime);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public int del_Reservation(String id, int movieNum, Timestamp screeningtime) {	//	진행중이던 결제 정보 삭제
		String sql = "delete from destinymovie_seat where id = ? and movienum = ? and screeningtime = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, movieNum);
			ps.setTimestamp(3, screeningtime);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
