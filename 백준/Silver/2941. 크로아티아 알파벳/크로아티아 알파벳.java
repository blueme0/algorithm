import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str + "00";
		int num = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			char temp = str.charAt(i);
			
			if (temp == '0') break;
			
			num++;
			
			if (temp == 'c') {
				if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
					i++;
				}
			}
			else if (temp == 'd') {
				if (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
					i = i + 2;
				}
				else if (str.charAt(i + 1) == '-')
					i++;
			}
			else if (temp == 'l' && str.charAt(i + 1) == 'j')
				i++;
			else if (temp == 'n' && str.charAt(i + 1) == 'j')
				i++;
			else if (temp == 's' && str.charAt(i + 1) == '=')
				i++;
			else if (temp == 'z' && str.charAt(i + 1) == '=')
				i++;
			
		}
		
		System.out.println(num);	
		
	}
}