package sys_SeatChart.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SeatChartDBClass {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private Connection SeatChartDBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public SeatChartDTO readDB_Seat(String movieName, Timestamp screeningtime, String[] arr) {	// 이미 예매완료된 좌석 표시를 위함
		conn = SeatChartDBClass();
		SeatChartDTO dto = null;	
		int i=0;
		try {
			ps = conn.prepareStatement("select seat from destinymovie_seat where reservation = '1' and moviename = ? and screeningtime = ?");
			ps.setString(1, movieName);
			ps.setTimestamp(2, screeningtime);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				dto = new SeatChartDTO();
				dto.setSeat(i, rs.getString("seat"));
				arr[i] = dto.getSeat(i++);	
			}
		}catch(SQLException e) {
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
	
	public SeatChartDTO readDB_ForPay(String id, String movieName, Timestamp screenTimestamp, String seat, int price) {	// 결제용 데이터 read
		conn = SeatChartDBClass();
		SeatChartDTO dto = null;	
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where id = ? and reservation= '0' and moviename = ? and screeningtime = ?");
			ps.setString(1, id);
			ps.setString(2, movieName);
			ps.setTimestamp(3, screenTimestamp);
			rs = ps.executeQuery(); 
			
			if(rs.next()) {
				dto = new SeatChartDTO();
				dto.setId(rs.getString("id"));
				dto.setMovieName(rs.getString("moviename"));
				dto.setScreeningTime(rs.getString("screeningtime"));
				dto.setSeat(0, rs.getString("seat"));
				dto.setPrice(rs.getInt("price"));
				
				seat = dto.getSeat(0);
				price = dto.getPrice();
				
			}
		}catch(SQLException e) {
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
	
	public SeatChartDTO readDB_Poster(String movieName) {
		conn = SeatChartDBClass();
		SeatChartDTO dto = null;	
		try {
			ps = conn.prepareStatement("select image from destinymovie_info where moviename = ?");
			ps.setString(1, movieName);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				dto = new SeatChartDTO();
				dto.setImage(rs.getBytes(1));
			}
		}catch(SQLException e) {
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
	
	public int updateDB(String id, Timestamp screenTimestamp, String SeatNum, int Price, String movieName ) {
		conn = SeatChartDBClass();
		String sql = "update destinymovie_seat set id = ?, price = ? where seat = ? and screeningtime = ? and moviename = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, Price);
			ps.setString(3, SeatNum);
			ps.setTimestamp(4, screenTimestamp);
			ps.setString(5, movieName);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int reservation(String id, String movieName, Timestamp screeningtime) {	//	reservation 1로 업데이트
		conn = SeatChartDBClass();
		int result = 0;
		try {
			ps = conn.prepareStatement("update destinymovie_seat set reservation='1' where id = ? and moviename = ? and screeningtime = ?");
			ps.setString(1, id);
			ps.setString(2, movieName);
			ps.setTimestamp(3, screeningtime);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int del_Reservation(String id, int movieNum, Timestamp screeningtime) {	//	진행중이던 결제 정보 삭제
		conn = SeatChartDBClass();
		int result = 0;
		try {
			ps = conn.prepareStatement("delete from destinymovie_seat where id = ? and movienum = ? and screeningtime = ?");
			ps.setString(1, id);
			ps.setInt(2, movieNum);
			ps.setTimestamp(3, screeningtime);
			ps.executeUpdate();	
		}catch(Exception e){
			e.printStackTrace();
		} finally {
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
