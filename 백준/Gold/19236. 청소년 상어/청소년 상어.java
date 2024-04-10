import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
	// 방향 bi는 8보다 작거나 같은 자연수를 의미하고, 1부터 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 를 의미한다.
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[][] arr;
	static int[] where;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[16 + 1][2];
		where = new int[16];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				arr[n][0] = i * 4 + j;
				arr[n][1] = d - 1;
				where[i * 4 + j] = n;
			}
		}
		
		dfs(0, 0, 0, where, arr, 0);
		System.out.print(max);		
	}
	
	static void dfs(int a, int b, int sum, int[] wh, int[][] ar, int depth) {
		// 초기화... 이전에서 넘어온 배열 복사해야 함....
				
		// 상어가 (a, b)에 있음!
		int w = wh[b * 4 + a];
		int[] dwhere = new int[16];
		int[][] darr = new int[17][2];
		for (int i = 0; i < 16; i++) {
			dwhere[i] = wh[i];
			darr[i + 1] = new int[] {ar[i + 1][0], ar[i + 1][1]};
		}
		
		// (a, b)에 물고기가 있음! -> 상어가 먹기!
		int s = sum + w;
		max = Math.max(max, s);
		int direct = darr[w][1];
		darr[w][1] = -1;
		dwhere[b * 4 + a] = 0;
		
		// 물고기 옮기기
		for (int i = 1; i <= 16; i++) {
			int[] now = darr[i];
			if (i != w && darr[i][1] >= 0) {
				// 상어 없음! && 물고기 있음!
				int nx = now[0] % 4;
				int ny = now[0] / 4;
				// (now[0] % 4, now[0] / 4)가 현재 위치
				// now[1]이 방향
				for (int j = 0; j < 8; j++) {
					int d = (now[1] + j) % 8;
					int x = nx + dx[d];
					int y = ny + dy[d];
					
					if (x >= 0 && x < 4 && y >= 0 && y < 4) {
						if (a == x && b == y) continue;
						if (dwhere[y * 4 + x] == 0) {
							// x, y에 물고기 없음! 그냥 이동하거라
							darr[dwhere[ny * 4 + nx]] = new int[] {y * 4 + x, d};
							darr[dwhere[y * 4 + x]][0] = ny * 4 + nx;
							dwhere[y * 4 + x] = dwhere[ny * 4 + nx];
							dwhere[ny * 4 + nx] = 0;
							break;
						}
						else {
							darr[dwhere[ny * 4 + nx]] = new int[] {y * 4 + x, d};
							darr[dwhere[y * 4 + x]][0] = ny * 4 + nx;
							// nx, ny에 있는 물고기랑, x, y에 있는 물고기랑 바꾸기!
							int tw = dwhere[y * 4 + x];
							dwhere[y * 4 + x] = dwhere[ny * 4 + nx];
							dwhere[ny * 4 + nx] = tw;						
							break;
						}
					}
				}
			}
		}
		
		int na = a + dx[direct];
		int nb = b + dy[direct];

		while (na >= 0 && na < 4 && nb >= 0 && nb < 4) {
			if (dwhere[nb * 4 + na] > 0) {
				dfs(na, nb, s, dwhere, darr, depth + 1);
			}
			na += dx[direct];
			nb += dy[direct];
		}
	}
}