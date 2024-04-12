import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static Queue<Ball>[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new LinkedList[N][N];
		// 질량합, 속력합, 개수
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<Ball>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1].add(new Ball(false, m, s, d));
		}
		
		int result = bfs();
		System.out.println(result);
	}
	
	static int bfs() {
		
		int count = 0;
		
		while (count < K) {
			count++;

			// 모든 파이어볼이 자신의 방향 d로 속력 s만큼 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Queue<Ball> cur = map[i][j];
					int qsize = cur.size();
					int qcount = 0;
					while (qcount < qsize) {
						qcount++;

						Ball cur_ball = map[i][j].peek();
						if (cur_ball.moved) continue;
						// cur_ball이 움직이지 않은 경우에만 다음 단계 수행
						int x = (j + cur_ball.s * dx[cur_ball.d]) % N;
						int y = (i + cur_ball.s * dy[cur_ball.d]) % N;
						if (x < 0) x += N;
						if (y < 0) y += N;
						map[y][x].add(new Ball(true, cur_ball.m, cur_ball.s, cur_ball.d));
						map[i][j].poll();
					}
				}
			}
			
			// 이동한 뒤의 파이어볼에 대해, 합치거나 유지하기, moved = false로 바꿔주기!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Queue<Ball> cur = map[i][j];
					int cur_size = cur.size();
					if (cur_size == 1) {
						Ball oneball = map[i][j].poll();
						map[i][j].add(new Ball(false, oneball.m, oneball.s, oneball.d));
					}
					else if (cur_size > 1) {
						int msum = 0;
						int ssum = 0;
						int oddcount = 0;
						int evencount = 0;
						
						for (Ball b : cur) {
							msum += b.m;
							ssum += b.s;
							if (b.d % 2 == 0) evencount++;
							else oddcount++;
						}
						
						map[i][j].clear();
						boolean toeven = oddcount == cur_size || evencount == cur_size;
						if (msum / 5 > 0) {
							for (int z = 0; z < 4; z++) {
								if (toeven) map[i][j].add(new Ball(false, msum / 5, ssum / cur_size, 2 * z));
								else map[i][j].add(new Ball(false, msum / 5, ssum / cur_size, 2 * z + 1));
							}
						}
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Queue<Ball> bqueue = map[i][j];
				for (Ball b : bqueue) {
					result += b.m;
				}
			}
		}
		return result;
	}
}

class Ball {
	boolean moved;
	int m, s, d;
	
	Ball(boolean moved, int m, int s, int d) {
		this.moved = moved;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}