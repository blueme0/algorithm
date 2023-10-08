import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int min = w * h;
		
		min = Math.min(min, Math.min(x, w - x));
		min = Math.min(min, Math.min(y, h - y));
		
		System.out.println(min);
		
	}
}
	