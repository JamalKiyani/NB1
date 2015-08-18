
public class PassByReference {
	public static void main(String[] args) {
		Number num = new Number();
		System.out.println("Start type = " +num.num1);
			Calculator calc = new Calculator();
			calc.multiply(num);
			System.out.println("Final value = " +num.num1);
	}
}
