import java.util.Scanner;

public class Main {
	
	public static boolean[][] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		int min = 64;
		
		arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			
			String str = sc.nextLine();
			
			for (int j = 0; j < M; j++) {
				
				if (str.charAt(j) == 'W')
					arr[i][j] = true;		// true == white, false == black
				else arr[i][j] = false;
				
			}
			
		}
		
		
		for (int i = 7; i < N; i++) {
			for (int j = 7; j < M; j++) {
				int temp = find(i, j);
				min = Math.min(min, temp);
			}
		}
		
		System.out.println(min);
		
	}
	
	public static int find(int x, int y) {
		
		int count = 0;
		
		boolean TF = arr[x - 7][y - 7];
		
		for (int i = x - 7; i < x + 1; i++) {
			for (int j = y - 7; j < y + 1; j++) {
				
				if (arr[i][j] == TF) count++;
				TF = !TF;
				
			}
			TF = !TF;
		}

		return Math.min(count, 64 - count);
		
	}
}