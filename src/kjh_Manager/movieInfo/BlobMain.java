package kjh_Manager.movieInfo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobMain {
	Connection con;
	
	public BlobMain() {
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe", "team03", "3333");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public FileVO test() {
		FileVO fv = null;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				fv = new FileVO();
				fv.setBlob(rs.getBytes(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fv;
	}
	
	public int insert() {
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO destinymovie_info values(2016, '너의 이름은', '10', ?)");
			File file = new File("C:\\movie.jpg");
			FileInputStream fis = new FileInputStream(file);
			
			ps.setBinaryStream(1, fis, (int)file.length());
			result = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
