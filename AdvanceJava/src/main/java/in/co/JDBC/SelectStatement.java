package in.co.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SelectStatement {

	public static void main(String[] args) throws Exception {

		String s = "Select * From student";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet set = stmt.executeQuery(s);

		while (set.next()) {

			System.out.println(set.getInt("student_id"));
			System.out.println(set.getString("name"));

		}

	}
}
