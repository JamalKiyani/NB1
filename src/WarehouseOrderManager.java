import java.util.Scanner;

public class WarehouseOrderManager {

	DBConnector dbConnector = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public WarehouseOrderManager() {

	}

	public void run() {
		String A = "";
		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int orderID;
		String orderProcess;
		

		System.out.println("Enter your Order ID: ");
		orderID = user_input.nextInt();

		System.out.println("Where is your order in the process? ");
		orderProcess = user_input.next();

		dbConnector.AddCODB(orderID, orderProcess);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else if (A.equals("N")){
			user_input.close();
		}

	}

	public static void main(String[] args) {
		WarehouseOrderManager wom = new WarehouseOrderManager();
		wom.run();
	}
}