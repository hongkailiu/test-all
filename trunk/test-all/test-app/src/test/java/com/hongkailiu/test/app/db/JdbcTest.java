package com.hongkailiu.test.app.db;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * ref. 
 * http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
 * @author Liu
 *
 */
public class JdbcTest {
	// JDBC driver name and database URL
	// static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	// static final String DB_URL = "jdbc:mysql://localhost/EMP";
	static final String JDBC_DRIVER = "org.h2.Driver";
	// static final String DB_URL = "jdbc:h2:~/mytest_jdbc";
	static final String DB_URL = "jdbc:h2:mem:mytest_jdbc;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
	// Database credentials
	static final String USER = "";
	static final String PASS = "";

	// static final JdbcDataSource ds = null;

	@BeforeClass
	public static void setupBeforeClass() throws SQLException,
			ClassNotFoundException {
		//initWithDatasource();
		initWithJdbc();
	}

	@SuppressWarnings("unused")
	private static void initWithDatasource() throws SQLException {
		 //h2 database start
		 JdbcDataSource ds = new JdbcDataSource();
		 ds.setURL(DB_URL);
		 ds.setUser(USER);
		 ds.setPassword(PASS);
		 Connection conn = ds.getConnection();
		 Statement stmt = conn.createStatement();
		 String sql =
		 "CREATE TABLE Person(id int(10) NOT NULL AUTO_INCREMENT,name varchar(20) NOT NULL DEFAULT '', country varchar(20) DEFAULT NULL,PRIMARY KEY (id));";
		 int r = stmt.executeUpdate(sql);
		 System.out.println("JdbcTest: setupBeforeClass: " + r);
		 sql =
		 "insert  into Person (id,name,country) values (5,'Pankaj','India'),(6,'Pankaj','India');";
		 r = stmt.executeUpdate(sql);
		 System.out.println("JdbcTest: setupBeforeClass: " + r);
		 stmt.close();
		 conn.close();
		
	}

	private static void initWithJdbc() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);

		System.out.println("Connecting to database...");
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

		System.out.println("Creating statement...");
		Statement stmt = conn.createStatement();
		String sql = "CREATE TABLE Person(id int(10) NOT NULL AUTO_INCREMENT,name varchar(20) NOT NULL DEFAULT '', country varchar(20) DEFAULT NULL,PRIMARY KEY (id));";
		int r = stmt.executeUpdate(sql);
		System.out.println("JdbcTest: setupBeforeClass: " + r);
		sql = "insert  into Person (id,name,country) values (5,'Pankaj','India'),(6,'Pankaj','India');";
		r = stmt.executeUpdate(sql);
		System.out.println("JdbcTest: setupBeforeClass: " + r);
		stmt.close();
		conn.close();
	}

	@Test
	public void testJDBC() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, country FROM Person";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String country = rs.getString("country");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Name: " + name);
				System.out.println(", Country: " + country);
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
}
