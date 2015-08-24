import java.util.Scanner;

public class WarehouseOrderManagerUpdate {

	DBConnector dbConnector = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public WarehouseOrderManagerUpdate() {

	}

	public void run() {
		String A = "";
		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int orderID;
		String orderProcess;

		System.out.println("Enter your Order ID: ");
		orderID = user_input.nextInt();

		System.out.println("What is the now process of the order? ");
		orderProcess = user_input.next();

		DBConnector.UpdateCODB(orderID, orderProcess);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else {
			user_input.close();
		}

	}

	public static void main(String[] args) {
		WarehouseOrderManagerUpdate womu = new WarehouseOrderManagerUpdate();
		womu.run();
	}
}