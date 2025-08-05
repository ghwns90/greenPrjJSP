package menus;

import java.sql.*;
import java.util.ArrayList;

// Dao : Data Access Object
// CRUD 작업 : Create(Insert), Read(Select), Update(Update), Delete(Delete)
public class MenuDao {
	
	// 데이터 조회 ( 목록 )
	public ArrayList<MenuDto> getMenuList() {
		DBConn db 			= new DBConn();
		Connection conn 	= db.getConnection();
		String sql 			= "";
		sql                += "SELECT * FROM MENUS ";
		sql                += " ORDER BY MENU_ID ASC";
		
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		// 검색결과 한줄을 dto 에 담고 dto 여러개를 담을 ArrayList 만들기
		ArrayList<MenuDto> menuList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			// 쿼리 실행 후 데이터를 반복문으로 가져오기
			while(rs.next()) {
				String menu_id = rs.getString("menu_id");
				String menu_name = rs.getString("menu_name");
				int menu_seq = rs.getInt("menu_seq");
				
				// DB에서 꺼내온 데이터들을 DTO 객체에 담는다
				MenuDto dto = new MenuDto(menu_id, menu_name, menu_seq);
				/*
				dto.setMenu_id(menu_id);
				dto.setMenu_name(menu_name);
				dto.setMenu_seq(menu_seq);
				*/
				
				// dto 한줄씩 반복해서 ArrayList 에 add
				menuList.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		// Finally 에서 close() 시켜주기		
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
					if(rs    != null) rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		// dto 객체를 담은 ArrayList 리턴
		return menuList;
		
	}
	
	// 데이터 추가
	public void addMenu(String menu_id, String menu_name, int menu_seq) {
		DBConn db               = new DBConn();
		Connection conn 		= db.getConnection();
		String sql 				= "";
		sql                    += "INSERT INTO MENUS VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, menu_id);
			 pstmt.setString(2, menu_name);
			 pstmt.setInt(3, menu_seq);
			 
			 pstmt.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn  != null) conn.close();
			} catch (SQLException e) {}
		}
	}
	
	// 데이터 조회 ( 메뉴 한개 )
	public MenuDto getMenu(String menu_id) {
		
		DBConn db		= new DBConn();
		Connection conn = db.getConnection();
		
		String sql = "";
		sql       += "SELECT * FROM MENUS";
		sql       += " WHERE menu_id = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs            = null;
		
		MenuDto dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			rs    = pstmt.executeQuery();
				
			if(rs.next()) {		
				
				dto = new MenuDto();
				
				dto.setMenu_id(menu_id);
				dto.setMenu_name(rs.getString("menu_name"));
				dto.setMenu_seq(rs.getInt("menu_seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
				try {
					if(pstmt != null) pstmt.close();
					if(conn  != null) conn.close();
					if(rs    != null) rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return dto;
	}
	
	// 데이터 수정	
	public void updateMenu(String menu_id, String menu_name, int menu_seq) {
		
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		
		String sql = "";
		sql       += "UPDATE MENUS ";
		sql       += " SET menu_name = ?, menu_seq = ?";
		sql       += " WHERE menu_id = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_name);
			pstmt.setInt(2, menu_seq);
			pstmt.setString(3, menu_id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	// 데이터 삭제
	public void deleteMenu(String menu_id) {
		
		DBConn       db = new DBConn();
		Connection conn = db.getConnection();
		
		String sql = "";
		sql       += "DELETE FROM MENUS";
		sql       += " WHERE menu_id = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu_id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
}
