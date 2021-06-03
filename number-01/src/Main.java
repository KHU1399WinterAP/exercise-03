import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt();
		int b = input.nextInt();
		
		System.out.println(remainder(a, b));
	}
	
	private static int remainder(int a, int b) {
		if (b == 0)
			throw new IllegalArgumentException("Denominator cannot be zero.");
		
		return a % b;
	}
}
