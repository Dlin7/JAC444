package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryAccounts {
	public static void main(String[] args){

		
		Connection con = null;
		Statement stmt = null;

		try {
			// 2. Get connection and statements objects
			con = DriverManager.getConnection(Values.URL, Values.USER_NAME, Values.PASS_WORD);
			stmt = con.createStatement();

			// 3. Execute JDBC commands

			ResultSet rs = stmt.executeQuery("select ACCOUNT, FNAME, LNAME, BALANCE from Accounts");

			System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
			while (rs.next()) {
				int a = rs.getInt("ACCOUNT");
				String fn = rs.getString("FNAME");
				String ln = rs.getString("LNAME");
				float b = rs.getFloat("BALANCE");
				System.out.printf("%-10d%-12s%-12s%10.2f%n", a, fn, ln, b);
			}
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try {
				// 4. Close the connection and statement
				if (stmt != null)
					stmt.close();

				if (con != null)
					con.close();
			} catch (Exception ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		}
	}
}
