import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static boolean[][] wall;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	
	static int hx, hy, bx, by, rx, ry;
	static boolean[][] both_visited;
	static int[][] both_depth;
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] cmd = br.readLine().split(" ");
		N = Integer.parseInt(cmd[0]);
		M = Integer.parseInt(cmd[1]);
		
		wall = new boolean[N][M];
		
		both_visited = new boolean[111][111];
		both_depth = new int[111][111];
		// red, blue 순으로 -> y*10 + x가 해당 맵의 좌표

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (line.charAt(j)) {
					case '#':
						wall[i][j] = true;
						break;
					case 'B':
						bx = j;
						by = i;
						break;
					case 'R':
						rx = j;
						ry = i;
						break;
					case 'O':
						hx = j;
						hy = i;
						break;
				}
			}
		}
		
		int result = bfs(ry * 10 + rx, by * 10 + bx);
		System.out.print(result);
	}
	
	static int bfs(int red, int blue) {
		Queue<Both> que = new LinkedList<>();
		que.add(new Both(red, blue));
		both_visited[red][blue] = true;
		int result = 0;
		int count = 0;
		
		while (!que.isEmpty() && count < 11) {
			Both cur = que.poll();
			int redx, redy, bluex, bluey;
			if (cur.r % 10 == 0) {
				redx = 10;
				redy = (cur.r - 10) / 10;
			} else {
				redx = cur.r % 10;
				redy = cur.r / 10;
			}
			if (cur.b % 10 == 0) {
				bluex = 10;
				bluey = (cur.b - 10) / 10;
			} else {
				bluex = cur.b % 10;
				bluey = cur.b / 10;
			}

			int nrx, nry, nbx, nby;

			for (int i = 0; i < 4; i++) {
				nrx = redx;
				nry = redy;
				nbx = bluex;
				nby = bluey;
				
				result = 0;
				// 하 우 상 좌
				boolean moved = false;
				boolean rfirst = true;
				if (i == 0 && redy < bluey
						|| i == 1 && redx < bluex
						|| i == 2 && redy > bluey
						|| i == 3 && redx > bluex) rfirst = false;
								
				if (rfirst) {
					int rrx = redx + dx[i];
					int rry = redy + dy[i];
					while (rrx >= 0 && rrx < M && rry >= 0 && rry < N && !wall[rry][rrx]) {
						moved = true;
						nrx = rrx;
						nry = rry;
						
						if (rrx == hx && rry == hy) { 
							result = both_depth[cur.r][cur.b] + 1;
							break;
						}
												
						rrx += dx[i];
						rry += dy[i];
					}
					
					int bbx = nbx + dx[i];
					int bby = nby + dy[i];
					while (bbx >= 0 && bbx < M && bby >= 0 && bby < N && !wall[bby][bbx]) {
						if (bbx == hx && bby == hy) {
							result = -1;
							break;
						} 
						
						if (bbx == nrx && bby == nry) break;
						moved = true;
						nbx = bbx;
						nby = bby;
												
						bbx += dx[i];
						bby += dy[i];
					}
				} else {
					int bbx = nbx + dx[i];
					int bby = nby + dy[i];
					while (bbx >= 0 && bbx < M && bby >= 0 && bby < N && !wall[bby][bbx]) {
						moved = true;
						nbx = bbx;
						nby = bby;
						
						if (bbx == hx && bby == hy) {
							result = -1;
							break;
						}
						
						bbx += dx[i];
						bby += dy[i];
					}
					
					int rrx = nrx + dx[i];
					int rry = nry + dy[i];
					while (rrx >= 0 && rrx < M && rry >= 0 && rry < N && !wall[rry][rrx]) {
						if (rrx == hx && rry == hy) { 
							if (result != -1) result = both_depth[cur.r][cur.b] + 1;
							break;
						}
						
						if (rrx == nbx && rry == nby) break;
						moved = true;
						nrx = rrx;
						nry = rry;
												
						rrx += dx[i];
						rry += dy[i];
					}
				}
				if (result > 0) break;
				/*
				 * blue가 먼저 빠져도 count == 10까지는 탐색
				 */
				int redp = nry * 10 + nrx;
				int bluep = nby * 10 + nbx;
				if (result == 0 && moved && !both_visited[redp][bluep]) {
					// depth 갱신
					que.add(new Both(redp, bluep));
					both_visited[redp][bluep] = true;
					both_depth[redp][bluep] = both_depth[cur.r][cur.b] + 1; 
					count = both_depth[redp][bluep];
				}
			}
			if (result > 0) break;
		}
		if (result == 0 || result == 11) return -1;
		else return result;
	}
}

class Both {
	int r;
	int b;
	
	Both(int r, int b) {
		this.r = r;
		this.b = b;
	}
}