package in.co.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prepared {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Insert into student(student_id,name)  values(?,?)");

		ps.setInt(1, 200);
		ps.setString(2, "Shekhar");

		int a = ps.executeUpdate();

		System.out.println(a);

	}
}
