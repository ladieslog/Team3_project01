package Login.DB;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;



public class LoginDB {
	public Connection conn;
	PreparedStatement ps;
	public LoginDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03","3333");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int insert(LoginDTO dto) { // db에 저장하기
		String sql = 
	"insert into destinymovie_user(name,id,password,gender,tel,birth) values(?,?,?,?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPassword());
			ps.setBoolean(4, dto.getGender());
			ps.setString(5, dto.getTel());
			ps.setString(6, dto.getBirth());
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}
	
	public LoginDTO loginchk(String inputid) {
		String sql = "select * from destinymovie_user where id=?";
		LoginDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, inputid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new LoginDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
}	
	
	
	
	
	
