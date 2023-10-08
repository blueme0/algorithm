import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		
		String str = sc.nextLine();
		int len = str.length();
		StringBuilder sb = new StringBuilder(str);
		
		for (int i = 1; i < num; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < len; j++) {
				if (str.charAt(j) != '?' && str.charAt(j) != temp.charAt(j)) {
					sb.setCharAt(j, '?');
					str = sb.toString();
				}
			}
		}
		
		System.out.println(str);
		
	}
}
