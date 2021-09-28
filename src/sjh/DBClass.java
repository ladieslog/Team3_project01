package sjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClass {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public Connection  DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","team03","3333");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;   
			
	}
	
	public MovieDTO readDB(String InputId) {
		conn = DBClass();
		MovieDTO dto = null;
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where id= '"+InputId+ "' and reservation = '1'");
			rs = ps.executeQuery(); 
			if(rs.next()) {
		          dto = new MovieDTO();
		          dto.setId(rs.getString("id"));  
		          System.out.println(dto.getId());
		          dto.setScreeningTime(rs.getString("screeningtime"));
		          System.out.println(dto.getScreeningTime());
		          dto.setSeat(rs.getString("seat"));
		          System.out.println(dto.getSeat());
		          dto.setMovieName(rs.getString("moviename"));
		          System.out.println(dto.getMovieName());          
		    }     
		}catch(Exception e) {
			e.printStackTrace();
		}
	return dto;
	}
	public static int countNum;
	public MovieDTO readDB1(String InputId, String [] arr) {
		conn = DBClass();
		MovieDTO dto = null;
		countNum=0;
		try {
			ps = conn.prepareStatement("select moviename from destinymovie_seat where id= '"+InputId+ "' and reservation = '1'");
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
		          //dto = new MovieDTO();
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
	
	public MovieDTO readDB2(String InputId, String MovieName) {
		conn = DBClass();
		MovieDTO dto = null;
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where id= '"+InputId+"' and reservation = '1' and moviename = '"+MovieName+"'");
			rs = ps.executeQuery(); 
			if(rs.next()) {
		          dto = new MovieDTO();
		          dto.setId(rs.getString("id"));  
		          System.out.println(dto.getId());
		          dto.setScreeningTime(rs.getString("screeningtime"));
		          System.out.println(dto.getScreeningTime());
		          dto.setSeat(rs.getString("seat"));
		          System.out.println(dto.getSeat());
		          dto.setMovieName(rs.getString("moviename"));
		          System.out.println(dto.getMovieName()); 
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
	
	public int del_DB(String InputId, String MovieName) {	//	환불완료 => 결제 내역 정보 삭제
		conn = DBClass();
		int result = 0;
		try {
			ps = conn.prepareStatement("delete from destinymovie_seat where id = ? and moviename = ?");
			ps.setString(1, InputId);
			ps.setString(2, MovieName);
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
