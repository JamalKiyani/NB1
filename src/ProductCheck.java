import java.util.Scanner;

public class ProductCheck {

	DBConnector dbConnector = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public ProductCheck() {

	}

	public void run() {
		String A = "";

		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int productID;
		String prodName;
		int prodOrder;
		String prodLocation;
		int prodLocationX;
		int prodLocationY;

		System.out.println("Enter your Product ID: ");
		productID = user_input.nextInt();

		System.out.println("Enter the product name: ");
		prodName = user_input.next();

		System.out.println("Enter the product order number: ");
		prodOrder = user_input.nextInt();

		System.out.println("Product location: ");
		prodLocation = user_input.next();
		
		System.out.println("Product X location: ");
		prodLocationX = user_input.nextInt();
		
		System.out.println("Product Y location: ");
		prodLocationY = user_input.nextInt();

		DBConnector.AddProdDB(productID, prodName, prodOrder, prodLocation, prodLocationX, prodLocationY);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else if (A.equals("N")) {
			user_input.close();
		}
	}

	public static void main(String[] args) {
		ProductCheck pc = new ProductCheck();
		pc.run();

	}
}
