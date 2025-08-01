package post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
	
	public List<PostDto> getPost(String dong) throws SQLException{
		
		List<PostDto> list = new ArrayList<>();
		
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		String sql = "";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
		
		
		return list;
	}
}
