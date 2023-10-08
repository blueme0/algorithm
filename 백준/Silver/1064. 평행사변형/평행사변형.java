import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int xa = sc.nextInt();
		int ya = sc.nextInt();
		int xb = sc.nextInt();
		int yb = sc.nextInt();
		int xc = sc.nextInt();
		int yc = sc.nextInt();
		
		
		if ((ya - yb) * (xb - xc) == (yb - yc) * (xa - xb)) {
			System.out.println(-1.0);
		}
		else {
			double[] len = new double[3];
			len[0] = Math.sqrt((xa - xb) * (xa - xb) + (ya - yb) * (ya - yb));
			len[1] = Math.sqrt((xb - xc) * (xb - xc) + (yb - yc) * (yb - yc));
			len[2] = Math.sqrt((xc - xa) * (xc - xa) + (yc - ya) * (yc - ya));

			double min = len[0];
			double max = len[0];
			
			// len1 ~ len3 중 2 * (max - min)
			
			for (int i = 1; i < 3; i++) {
				if (len[i] < min) min = len[i];
				else if (len[i] > max) max = len[i];
			}
			
			System.out.println(2 * (max - min));
		}	
	}
}
