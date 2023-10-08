import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[num];
		
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextLine();
		}
		


		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length())
					return s1.compareTo(s2);
				else
					return s1.length() - s2.length();
			}
		});
		

		System.out.println(arr[0]);
		for (int i = 1; i < num; i++) {
			if (!arr[i].equals(arr[i-1]))
				System.out.println(arr[i]);
		}
		
	}
}

