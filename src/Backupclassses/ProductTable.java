package Backupclassses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductTable {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public static void accessBD() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

	public static void ReadDB() {
		System.out.println("reading from Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String read = "SELECT Product ID, Product Name,  Product Order , Product Location FROM orders";
			ResultSet results = stmt.executeQuery(read);

			while (results.next()) {
				int id = results.getInt("Prod ID");
				String prodName = results.getString("Product Name");
				int prodOrder = results.getInt("Product Order");
				String prodLocation = results.getString("Product Location");
				System.out.println("ID: " + id + ", product name: " + prodName
						+ ", product order: " + prodOrder
						+ ", product location: " + prodLocation);
			}
			results.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			System.out.println("Goodbye!");
		}

	}

	public static void AddDB(int prodID, String prodName, int prodOrder,
			String prodLocation) {
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String addition = "INSERT INTO productTable " + "VALUES ("
					+ String.valueOf(prodID) + ", '" + prodName + "', "
					+ String.valueOf(prodOrder) + ", '" + prodLocation + "')";
			System.out.println();
			System.out.println(addition);
			System.out.println();

			stmt.executeUpdate(addition);
			System.out.println("inserted " + prodName + " into table");

			// Catching Errors
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Closes the connection
		finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			System.out.println("Goodbye!");
		}
	}

	public static void UpdateDB(int prodID, int Quantity, boolean add) {// product
																		// changing,
																		// by
																		// how
																		// much,
																		// are
																		// we
																		// adding
																		// or
																		// subtracting
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			/**************/

			String read = "SELECT Quantity FROM products WHERE ProductID = "
					+ String.valueOf(prodID);
			ResultSet results = stmt.executeQuery(read);

			int DB = 0;
			while (results.next()) {
				DB = results.getInt("Quantity");
				System.out.println("DB is " + DB);
			}
			if (add) {
				DB = DB + Quantity;
			} else {
				DB = DB - Quantity;

			}
			/*****************/
			String update = "UPDATE products " + "SET Quantity = "
					+ String.valueOf(DB) + " WHERE ProductID = "
					+ String.valueOf(prodID);

			System.out.println(update);
			stmt.execute(update);

			System.out.println("we just changed the quantity");

			// Catching Errors

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Closing connections
		finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			System.out.println("Goodbye!");
		}
	}

}
