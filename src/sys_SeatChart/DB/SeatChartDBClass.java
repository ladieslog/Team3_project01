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
	
	public SeatChartDTO readDB_ForPay(String id, String movieName, Timestamp screenTimestamp) {	// 결제용 데이터 read
		conn = SeatChartDBClass();
		SeatChartDTO dto = null;	
		try {
			ps = conn.prepareStatement("select * from destinymovie_seat where id = ? and reservation= '0' and moviename = ? and screeningtime = ?");
			ps.setString(1, id);
			ps.setString(2, movieName);
			ps.setTimestamp(3, screenTimestamp);
			rs = ps.executeQuery(); 
			
			while(rs.next()) {
				dto = new SeatChartDTO();
				dto.setId(rs.getString("id"));
				dto.setSeat(0, rs.getString("seat"));
				dto.setMovieName(rs.getString("moviename"));
				dto.setMovieNum(rs.getInt("movienum"));
				dto.setScreeningTime(rs.getString("screeningtime"));
				dto.setReservation(rs.getInt("reservation"));
				dto.setPrice(rs.getInt("price"));
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
	
	public int insertDB(String id, int MovieNum, Timestamp screenTimestamp, String SeatNum, int Reservation, int Price, String movieName, String ScreeningNum ) {
		conn = SeatChartDBClass();
		String sql = "insert into destinymovie_seat(id, movienum, screeningtime, seat, reservation, price, moviename, screeningnum) "
				+ "values(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, MovieNum);
			ps.setTimestamp(3, screenTimestamp);
			ps.setString(4, SeatNum);
			ps.setInt(5, Reservation);
			ps.setInt(6, Price);
			ps.setString(7, movieName);
			ps.setString(8, ScreeningNum);
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
			ps = conn.prepareStatement("update destinymovie_seat set reservation='1' where id = ? and movienum = ? and screeningtime = ?");
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
