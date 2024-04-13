import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int N;
	static int[][] sand;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][][] rate;
	static int[][] direct;
	static int[] drt;
	static int original_sand = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sand = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sand[i][j] = Integer.parseInt(st.nextToken());
				original_sand += sand[i][j];
			}
		}
				
		direct = new int[N][N];
		drt = new int[N * N];
		rate = new int[4][10][3];
		
		for (int i = 0; i <= N / 2; i++) {
			int start = i;
			int end = N - 1 - i;
			for (int j = 0; j < start; j++) {
				direct[i][j] = 1;
			}
			for (int j = start; j <= end; j++) {
				direct[i][j] = 0;
			}
			for (int j = end + 1; j < N; j++) {
				direct[i][j] = 3;
			}
		}
		for (int i = N / 2 + 1; i < N; i++) {
			int start = N - 1 - i;
			int end = i - 1;
			for (int j = 0; j < start; j++) {
				direct[i][j] = 1;
			}
			for (int j = start; j <= end; j++) {
				direct[i][j] = 2;
			}
			for (int j = end + 1; j < N; j++) {
				direct[i][j] = 3;
			}
		}
		
		// dx, dy, rate
		rate[0][0] = new int[] {0, -1, 1};
		rate[0][1] = new int[] {0, 1, 1};
		rate[0][2] = new int[] {-1, -2, 2};
		rate[0][3] = new int[] {-1, -1, 7};
		rate[0][4] = new int[] {-1, 1, 7};
		rate[0][5] = new int[] {-1, 2, 2};
		rate[0][6] = new int[] {-2, -1, 10};
		rate[0][9] = new int[] {-2, 0, -1};
		rate[0][7] = new int[] {-2, 1, 10};
		rate[0][8] = new int[] {-3, 0, 5};
		
		for (int i = 0; i < 10; i++) {
			rate[1][i] = new int[] {rate[0][i][1], rate[0][i][0] * -1, rate[0][i][2]};
		}
		for (int i = 0; i < 10; i++) {
			rate[2][i] = new int[] {rate[0][i][0] * -1, rate[0][i][1], rate[0][i][2]};
		}
		for (int i = 0; i < 10; i++) {
			rate[3][i] = new int[] {rate[0][i][1], rate[0][i][0], rate[0][i][2]};
		}
		
		bfs();
		int rest_sand = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				rest_sand += sand[i][j];
			}
		}
		System.out.print(original_sand - rest_sand);
	}
	
	static void bfs() {
		int times = N * N - 1;
		int cnt = 0;
		int[] now = {N / 2, N / 2};

		while (cnt < times) {
			cnt++;
			int sand_with_flew = 0;
			int drt = direct[now[1]][now[0]];

			Queue<int[]> temp_map = new LinkedList<>();
			
			// 모래 모두 움직이기
			// now[0], now[1]은 x point, drtx, drty는 y point
			int drtx = now[0] + dx[drt];
			int drty = now[1] + dy[drt];
			int now_sand = sand[drty][drtx];
			sand[drty][drtx] = 0;
			
			for (int i = 0; i < 10; i++) {
				int x = now[0] + rate[drt][i][0];
				int y = now[1] + rate[drt][i][1];
				int r = rate[drt][i][2];
				int rate_sand = now_sand;
				if (r == -1) rate_sand = now_sand - sand_with_flew;
				else rate_sand = (int) (now_sand * (0.01 * r));

				if (x >= 0 && x < N && y >= 0 && y < N) {
					// 좌표가 있음!
					temp_map.add(new int[] {x, y, rate_sand});
				}
				sand_with_flew += rate_sand;
			}
			
			while (!temp_map.isEmpty()) {
				int[] cur = temp_map.poll();
				sand[cur[1]][cur[0]] += cur[2];
			}
			
			// 다음으로
			now[0] = drtx;
			now[1] = drty;
		}
	}
}