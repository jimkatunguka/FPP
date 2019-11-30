package prog13_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJavaDb {
	// queries
	String TEST_INSERT = "INSERT INTO PERSON " + "(id,firstname,lastname,ssn) "
			+ "VALUES(7,'Jim','Katunguka','780989098')";

	String TEST_UPDATE = "UPDATE PERSON " + "SET ssn = '190874909' " + "WHERE id = 7";

	String TEST_READ = "SELECT * FROM PERSON WHERE id=7";

	//

	Connection dbcon;
	Statement stmt;
	String dburl = "jdbc:derby://localhost:1527/FPP_DB;create=true";
	String insertStmt = "";
	String selectStmt = "";
	String ssn = "";

	public static void main(String[] args) {
		TestJavaDb demo = new TestJavaDb();

		demo.insertExample();
		demo.readExample();
		demo.updateExample();
		demo.readExample();

		demo.closeConnection();

	}

	public TestJavaDb() {
		// keep connection open throughout demo
		try {
			dbcon = DriverManager.getConnection(dburl, "app", "app");
			System.out.println("Got connection...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	void loadDriver() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// debug
			e.printStackTrace();
		}
	}

	void closeConnection() {
		try {
			if (dbcon != null)
				dbcon.close();
			System.out.println("Connection closed");
		} catch (SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}

	}

	void insertExample() {
		try {
			stmt = dbcon.createStatement();

			System.out.println("insert query " + TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();

		} catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}

	}

	void readExample() {

		try {
			stmt = dbcon.createStatement();
			System.out.println("the query: " + TEST_READ);
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if (rs.next()) {
				String id = rs.getString("id");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				ssn = rs.getString("ssn");
				System.out.println("id: " + id + " name: " + fname + " " + lname + " SSN: " + ssn);
			} else {
				System.out.println("No records found");
			}
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	void updateExample() {
		try {
			stmt = dbcon.createStatement();

			System.out.println("update query " + TEST_UPDATE);
			stmt.executeUpdate(TEST_UPDATE);
			stmt.close();

		} catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		// check result
		try {
			stmt = dbcon.createStatement();
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if (rs.next()) {
				String newssn = rs.getString("ssn");
				System.out.println("old ssn: " + ssn + " new ssn: " + newssn);
			} else {
				System.out.println("No records found");
			}
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

}
