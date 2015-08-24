import java.util.Scanner;

public class ProductCheckUpdate {

	DBConnector dbConnector = new DBConnector();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mydb";

	static final String USER = "root";
	static final String PASS = "netbuilder";

	public ProductCheckUpdate() {

	}

	public void run() {
		String A = "";
		Scanner user_input = new Scanner(System.in);
		// Process user input here
		int productID;
		String prodLocation;
		int prodLocationX;
		int prodLocationY;

		System.out.println("Enter your Product ID: ");
		productID = user_input.nextInt();

		System.out.println("Change your Product location: ");
		prodLocation = user_input.next();

		System.out.println("Change the X Product location: ");
		prodLocationX = user_input.nextInt();
		
		System.out.println("Change the Y Product location: ");
		prodLocationY =user_input.nextInt();
		
		
		DBConnector.UpdateProdDB(productID, prodLocation, prodLocationX, prodLocationY);

		System.out.println("Continue(Y/N)");
		A = user_input.next();
		if (A.equals("Y")) {

			run();
		} else if (A.equals("N")) {
			user_input.close();
		}

	}

	public static void main(String[] args) {
		ProductCheckUpdate pcu = new ProductCheckUpdate();
		pcu.run();
	}
}
