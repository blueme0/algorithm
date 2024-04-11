import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.invoke.StringConcatFactory;
import java.util.*;

public class Main {
	// 위 아 왼 오
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][][] map;
	static int[][] shark;
	static int[][][] priority;
	static int N, M, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		shark = new int[M + 1][3];
		priority = new int[M + 1][4][4];
		map = new int[N][N][2];
		// x, y에 0은 상어 번호, 1은 남은 시간
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				shark[cur][0] = j;
				shark[cur][1] = i;
				// x, y, direction
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			shark[i][2] = cur - 1;
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int h = 0; h < 4; h++) {
					int cur = Integer.parseInt(st.nextToken());
					priority[i][j][h] = cur - 1;
				}
			}
		}
		
		int result = bfs();
		System.out.print(result);
		
	}
	
	static int bfs() {
		// 모든 map을 체크하고 냄새의 남은 시간 -- 해주기
		// 현재 상어들이 위치한 곳에 spread
		// N개의 상어들이 이동 (우선순위에 따라..., 아무 냄새가 없는 칸이 먼저 -> 그 다음이 자신의 냄새가 있는 곳)
		// 겹치는 상어 있으면 숫자가 제일 작은 것만 남겨두기
		// 상어 하나 남았으면 break
		
		int rest_shark = M;
		int count = 0;
		
		for (int i = 1; i <= M; i++) {
			int[] cur_shark = shark[i];
			if (cur_shark[0] > -1) {
				// shark exists
				map[cur_shark[1]][cur_shark[0]] = new int[] {i, k};
			}
		}
		
		while (count < 1000 && rest_shark > 1) {
			count++;
			
			for (int i = 1; i <= M; i++) {
				int[] cur_shark = shark[i];
				if (cur_shark[0] == -1) continue;
				int[] cur_priority = priority[i][cur_shark[2]];

				for (int j = 0; j < 8; j++) {
					int x = cur_shark[0] + dx[cur_priority[j % 4]];
					int y = cur_shark[1] + dy[cur_priority[j % 4]];
					if (x >= 0 && x < N && y >= 0 && y < N) {							
						if (j / 4 == 0 && map[y][x][1] == 0 || j / 4 == 1 && map[y][x][0] == i) {
							// 만약 지금 칸에 냄새가 없어 그러면 ㄱㄱ 아니면 두바뀌짼데 내 냄새가 있으면 ㄱㄱ
							
							boolean ck = true;
							for (int z = 1; z < i; z++) {
								if (shark[z][0] == x && shark[z][1] == y) {
									ck = false;
									break;
								}
							}
							if (ck) shark[i] = new int[] {x, y, cur_priority[j % 4]};
							else {
								shark[i] = new int[] {-1, -1, -1};
								rest_shark--;
							}
							break;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][1] > 1) map[i][j][1]--;
					else if (map[i][j][1] == 1) {
						map[i][j][1]--;
						map[i][j][0] = 0;
					}
				}
			}
			
			for (int i = 1; i <= M; i++) {
				int[] cur_shark = shark[i];
				if (cur_shark[0] > -1) {
					// shark exists
					map[cur_shark[1]][cur_shark[0]] = new int[] {i, k};
				}
			}
		}
		
		if (rest_shark == 1) return count;
		else return -1;
	}
}