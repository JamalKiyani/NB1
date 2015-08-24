import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
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

	// Order Table
	public static void ReadOrderDB() {
		System.out.println("reading from Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String read = "SELECT Order ID, orderProcess FROM orders";
			ResultSet results = stmt.executeQuery(read);

			while (results.next()) {
				int orderID = results.getInt("Order ID");
				String orderProcess = results.getString("orderProcess");
				;
				System.out.println("ID: " + orderID + ", orderProcess: "
						+ orderProcess);
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

	public void AddCODB(int OrderID, String orderProcess) {
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String addition = "INSERT INTO customerorder " + "VALUES ("
					+ String.valueOf(OrderID) + ", '" + orderProcess + "')";
			System.out.println();
			System.out.println(addition);
			System.out.println();

			stmt.executeUpdate(addition);
			System.out.println("inserted " + OrderID + " into table");

			// Cataching errors

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// CLOSING THE CONNECTION
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

	public static void UpdateCODB(int OrderID, String orderProcess) {

		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			/**************/

			/*****************/
			String update = "UPDATE customerOrder " + "SET orderProcess = '"
					+ orderProcess + "'" + " WHERE OrderID = "
					+ String.valueOf(OrderID);

			System.out.println(update);
			stmt.execute(update);

			System.out.println("The order process is now changed!");

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

	// Orderline Table

	public static void ReadOLDB() {
		System.out.println("reading from quantity");
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

	public void AddOLDB(int orderID, int productID, int productQuantity,
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

	public static void UpdateOLDB(int orderID, int productQuantity) {
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			/**************/

			String update = "UPDATE quantitytable " + "SET ProductQuantity = '"
					+ productQuantity + "'" + " WHERE OrderID = "
					+ String.valueOf(orderID);

			System.out.println(update);
			stmt.execute(update);

			System.out.println("The location of the product has now changed!");

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

	// Product Table

	public static void ReadProdDB() {
		System.out.println("reading from Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String read = "SELECT Product ID, Product Name,  Product Order , Product Location , Product Location X, Product Location Y FROM orders";
			ResultSet results = stmt.executeQuery(read);

			while (results.next()) {
				int id = results.getInt("Prod ID");
				String prodName = results.getString("Product Name");
				int prodOrder = results.getInt("Product Order");
				String prodLocation = results.getString("Product Location");
				int prodLocationX =results.getInt("Product Location X");
				int prodLocationY =results.getInt("Product Location Y");
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

	public static void AddProdDB(int prodID, String prodName, int prodOrder,
			String prodLocation, int prodLocationX, int prodLocationY) {
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
					+ String.valueOf(prodOrder) + ", '" + prodLocation + "', "
					+ String.valueOf(prodLocationX) + ", '"
					+ String.valueOf(prodLocationY) + "')";
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

	public static void UpdateProdDB(int prodID, String prodLocation, int prodLocationX, int prodLocationY) {
		System.out.println("Adding to Products");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			/**************/

			String update = "UPDATE producttable " + "SET ProdLocation = '"
					+ prodLocation + "'"  + " WHERE prodID = "
					+ String.valueOf(prodID);

			System.out.println(update);
			stmt.execute(update);
			update = "updateLocationX";
			String updateLocationX = "UPDATE producttable " + "SET ProdLocationX = '"
					+ String.valueOf(prodLocationX) + "'"  + " WHERE prodID = "
					+ String.valueOf(prodID);
			System.out.println(updateLocationX);
			stmt.execute(updateLocationX);
			update = "updateLocationY";
			String updateLocationY = "UPDATE producttable " + "SET ProdLocationY = '"
					+ String.valueOf(prodLocationY) + "'"  + " WHERE prodID = "
					+ String.valueOf(prodID);
			System.out.println(updateLocationY);
			stmt.execute(updateLocationY);
			System.out.println("The location of the product has now changed!");

			
			
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
