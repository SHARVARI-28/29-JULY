
/*
Write a java program that connects to oracle database, queries the inbuilt 
table “emp” and displays the first two columns (empno using column index 
and ename using column name ) of all the rows.
 */

package sharvari.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class July29_1 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs;
		
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl", "root", "root");			
		} catch (Exception e) {
			System.out.println("Connection could  not be established");
			if (conn != null) conn.close();
		}
		
		String sql = "SELECT empno, ename FROM emp";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("empno: " + rs.getInt(1) + ", ename: " + rs.getString("ename"));
		}
		
		if (stmt != null) stmt.close();		
		if (conn != null) conn.close();
	}

}
