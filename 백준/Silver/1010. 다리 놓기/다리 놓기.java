
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(fact(b).divide(fact(a)).divide(fact(b-a)));
			
		}
		
	}
	
	
	public static BigInteger fact(int a) {
		if (a <= 1) return new BigInteger("1");
		else return fact(a - 1).multiply(new BigInteger(Integer.toString(a)));
	}
	
}

