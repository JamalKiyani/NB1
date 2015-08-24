package Backupclassses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuantityTable {

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
			String read = "SELECT Order ID, productID,  productQuantity, porousWare FROM quantity";
			ResultSet results = stmt.executeQuery(read);

			while (results.next()) {
				int orderID = results.getInt("Order ID");
				int productID = results.getInt("Product ID");
				int productQuantity = results.getInt("Product Quantity");
				boolean porousWare = results.getBoolean("Porousware");
				System.out.println("Order ID: " + orderID + ", product ID: "
						+ productID + ", product quantity: " + productQuantity
						+ ", porousware: " + porousWare);
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

	public static void AddDB(int orderID, int productID, int productQuantity,
			int porousware) {
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String addition = "INSERT INTO quantityTable " + "VALUES ("
					+ String.valueOf(orderID) + ", '" + productID + "', "
					+ String.valueOf(productQuantity) + ", '" + porousware
					+ "')";
			System.out.println();
			System.out.println(addition);
			System.out.println();

			stmt.executeUpdate(addition);
			System.out.println("inserted " + orderID + " into table");

			// Error catching
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