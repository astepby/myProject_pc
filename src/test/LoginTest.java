package test;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import assets.DBConnectionMgr;

public class LoginTest {
	public static void main(String[] args) {
		
		boolean test = loginTest("test", "1234");
		System.out.println("로그인테스트: "+test);
	}
	
	public static boolean loginTest(String id, String password) {
		boolean flag = false;
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql = null;
		String getPass = null;
		
		try {
			
			con = (Connection) pool.getConnection();
			//Connection;
			sql = "select password from member where id=?";
			//
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			//
			pstmt.setString(1, id);;
			
			//
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				getPass = rs.getString("password");
				if(getPass.equals(password)) {
					System.out.println("비밀번호: "+getPass);
					flag = true;
					
				}
			}
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			pool.freeConnection(con,pstmt,rs);
			
		}
		
		
		return flag;
	}

}
