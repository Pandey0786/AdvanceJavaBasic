package in.co.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `Test1`(IN i int  )
BEGIN
update emp set salary = 30000 where id = i;
END*/

public class StoredProcedureIN {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "root");

		CallableStatement call = conn.prepareCall("{call Test1(?)}");

		call.setInt(1, 1);

		call.execute();

		System.out.println("Check DB");

		conn.close();

	}

}
