package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class dbConnTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/elections";
		String user = "root";
		String password = "DIAD2016";
		
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("Connection made");
			
			String q = "select * from elections";
			
			Statement st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String canidOne = rs.getString(3);
				
				System.out.println(id + " : " + name + " : " + canidOne);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception");		
		}
	}

}
