package kjh_Manager.userInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DestinyMovieUserDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private static DestinyMovieUserDAO dao = new DestinyMovieUserDAO();
	
	private DestinyMovieUserDAO() {
		
	}
	
	public static DestinyMovieUserDAO getInstance() {
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
	
	// DB에 저장된 전체 유저 정보 조회
	public ArrayList<DestinyMovieUserDTO> selectList() {
		con = connect();
		ArrayList<DestinyMovieUserDTO> list = new ArrayList<>();
		try {
			ps = con.prepareStatement("SELECT * FROM destinymovie_user");
			rs = ps.executeQuery();
			while(rs.next()) {
				DestinyMovieUserDTO dto = new DestinyMovieUserDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("password"));
				dto.setGender(rs.getString("gender"));
				dto.setBirth(rs.getTimestamp("birth"));
				dto.setTel(rs.getString("tel"));
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
	
	// 회원 삭제
	public int removeUser(String id) {
		int result = 0;
		con = connect();
		if(id.equals("team03")) {
			return 3;
		}
		try {
			ps = con.prepareStatement("DELETE FROM destinymovie_user WHERE id=?");
			ps.setString(1, id);
			result = ps.executeUpdate();
			ps = con.prepareStatement("UPDATE destinymovie_seat SET RESERVATION = '0', ID = NULL, PRICE = 0 WHERE ID = ?");
			ps.setString(1, id);
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
