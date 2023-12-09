package in.co.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/*CREATE DEFINER=`root`@`localhost` FUNCTION `FIN`(i int) RETURNS int
DETERMINISTIC
BEGIN 
declare b int;
select count(*) into b from emp where id = i;
RETURN b;
END*/

public class StoredFunctionInput {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "root");

		CallableStatement call = conn.prepareCall("{ ? = call FIN(?) }");
		call.setInt(2, 1);
		call.registerOutParameter(1, Types.INTEGER);

		call.execute();

		System.out.println(call.getInt(1));
	}

}
