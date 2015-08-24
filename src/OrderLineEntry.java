import java.util.Scanner;

public class OrderLineEntry {

	DBConnector qTable = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public OrderLineEntry() {

	}

	public void run() {
		String A = "";
		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int orderID;
		int productID;
		int productQuantity;
		int porousware;

		System.out.println("Enter your Order ID: ");
		orderID = user_input.nextInt();

		System.out.println("Enter your Product ID: ");
		productID = user_input.nextInt();

		System.out.println("Enter the quantity: ");
		productQuantity = user_input.nextInt();

		System.out.println("Does your product have porousware? ");
		porousware = user_input.nextInt();

		qTable.AddOLDB(orderID, productID, productQuantity, porousware);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else  if (A.equals("N")){
			user_input.close();
		}

	}

	public static void main(String[] args) {
		OrderLineEntry ol = new OrderLineEntry();
		ol.run();
	}

}