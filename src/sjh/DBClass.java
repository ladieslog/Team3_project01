package sjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DBClass {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","team03","3333");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;   
	}
	
	public String[] readDB(String InputId, String MovieName, Timestamp screenTimestamp, String [] data) {
		conn = DBClass();
		System.out.println(InputId + MovieName + screenTimestamp);	// 결제하기
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where id= ? and moviename = ? and screeningtime = ? and reservation = '0'");
			ps.setString(1, InputId);
			ps.setString(2, MovieName);
			ps.setTimestamp(3, screenTimestamp);
			rs = ps.executeQuery(); 
			
			if(rs.next()) {
				MovieDTO dto = new MovieDTO(); 	
				dto.setMovieName(rs.getString("moviename"));
		        data[0] = dto.getMovieName();
		        dto.setSeat(rs.getString("seat"));
		        data[1] = dto.getSeat();
		        dto.setPrice(rs.getInt("price"));
		        data[2] = String.valueOf(dto.getPrice());
		       
		    }     
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static int countNum;
	public MovieDTO readDB1(String InputId, String [] arr) {	// 구매내역
		conn = DBClass();
		MovieDTO dto = null;
		countNum=0;
		try {
			ps = conn.prepareStatement("select moviename from destinymovie_seat where id= ? and reservation = '1'");
			ps.setString(1, InputId);
			rs = ps.executeQuery(); 
			while(rs.next()) {
		          arr[countNum++] = rs.getString("moviename");
		    }   	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public static Timestamp selectedTime;
	public String[] readDB2(String InputId, String MovieName, String[]data) {	//환불용
		conn = DBClass();
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where reservation = '1' and id= ? and moviename = ?");
			ps.setString(1, InputId);
			ps.setString(2, MovieName);
			rs = ps.executeQuery(); 
			
			if(rs.next()) {
			MovieDTO dto = new MovieDTO(); 
		       dto.setMovieName(rs.getString("moviename"));
		       data[0] = dto.getMovieName();	
		       dto.setSeat(rs.getString("seat"));
		       data[1] = dto.getSeat();	
		       selectedTime = rs.getTimestamp("screeningtime");
		    }     
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public int del_DB(String InputId, String MovieName, Timestamp screeningtime) {	//	환불완료 => 결제 내역 정보 삭제
		conn = DBClass();
		int result = 0;
		try {
			ps = conn.prepareStatement("update destinymovie_seat set id = '' ,reservation='0', price = '' where id = ? and moviename = ? and screeningtime = ?");
			ps.setString(1, InputId);
			ps.setString(2, MovieName);
			ps.setTimestamp(3, screeningtime);
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
