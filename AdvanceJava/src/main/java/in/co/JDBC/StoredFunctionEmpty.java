package in.co.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*CREATE DEFINER=`root`@`localhost` FUNCTION `Apply`() RETURNS int
DETERMINISTIC
BEGIN
declare a int ;
select count(*) from emp into a;
RETURN a;
END*/

public class StoredFunctionEmpty {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "root");

		CallableStatement call = conn.prepareCall("{ ? = call Apply() }");

		call.registerOutParameter(1, Types.INTEGER);

		call.execute();

		System.out.println(call.getInt(1));

	}
}
