import java.util.Scanner;


public class OrderLineUpdate {

	DBConnector qTable = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public void run() {
		String A = "";
		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int orderID;
		int productQuantity;

		System.out.println("Enter your Order ID: ");
		orderID = user_input.nextInt();

		System.out.println("Enter the quantity: ");
		productQuantity = user_input.nextInt();

		DBConnector.UpdateOLDB(orderID, productQuantity);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else if (A.equals("N")) {
			user_input.close();
		}

	}

	public static void main(String[] args) {
		OrderLineUpdate olu = new OrderLineUpdate();
		olu.run();
	}

}