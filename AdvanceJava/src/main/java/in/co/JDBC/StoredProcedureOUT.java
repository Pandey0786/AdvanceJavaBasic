package in.co.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*CREATE DEFINER=`root`@`localhost` PROCEDURE `Test2`(OUT o int)
BEGIN
Select count(*) into o from emp; 
END*/

public class StoredProcedureOUT {
	
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "root");

		CallableStatement call = conn.prepareCall("{call Test2(?)}");

		call.setInt(1, 1);

		call.registerOutParameter(1, Types.INTEGER);

		call.execute();

		System.out.println(call.getInt(1) );

		conn.close();

	}

}
