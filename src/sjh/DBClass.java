package sjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClass {
	public static Connection conn;
	
	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","team03","3333");
		}catch (Exception e) {
			e.printStackTrace();
		}	   
			
	}
	
	public MovieDTO readDB(String InputId) {
		String sql = "select * from destinymovie_seat where id= '"+InputId+ "' and reservation = '1'";
		MovieDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
		          dto = new MovieDTO();
		          dto.setId(rs.getString("id"));  
		          System.out.println(dto.getId());
		          dto.setScreeningTime(rs.getString("screeningtime"));
		          System.out.println(MovieDTO.getScreeningTime());
		          dto.setSeat(rs.getString("seat"));
		          System.out.println(MovieDTO.getSeat());
		          dto.setMovieName(rs.getString("moviename"));
		          System.out.println(MovieDTO.getMovieName());          
		    }     
		}catch(Exception e) {
			e.printStackTrace();
		}
	return dto;
	}
	public static int countNum;
	public MovieDTO readDB1(String InputId) {
		String sql = "select moviename from destinymovie_seat where id= '"+InputId+ "' and reservation = '1'";
		MovieDTO dto = null;
		countNum=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
		          dto = new MovieDTO();
		          dto.setMovieName1(countNum, rs.getString("moviename"));
		          System.out.println(MovieDTO.getMovieName1(countNum++));    
		          countNum++;
		    }   
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public MovieDTO readDB2(String InputId, String MovieName) {
		String sql = "select * from destinymovie_seat where id= '"+InputId+"' and reservation = '1' and moviename = '"+MovieName+"'";
		MovieDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) {
		          dto = new MovieDTO();
		          dto.setId(rs.getString("id"));  
		          System.out.println(dto.getId());
		          dto.setScreeningTime(rs.getString("screeningtime"));
		          System.out.println(MovieDTO.getScreeningTime());
		          dto.setSeat(rs.getString("seat"));
		          System.out.println(MovieDTO.getSeat());
		          dto.setMovieName(rs.getString("moviename"));
		          System.out.println(MovieDTO.getMovieName()); 
		    }     
		}catch(Exception e) {
			e.printStackTrace();
		}
	return dto;
	}
	
	public static int del_DB(String InputId, String MovieName) {	//	환불완료 => 결제 내역 정보 삭제
		String sql = "delete from destinymovie_seat where id = ? and moviename = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, InputId);
			ps.setString(2, MovieName);
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
