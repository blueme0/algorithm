import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int N;
	static int[][] fish;
	static boolean[][] visited;
	static int[] dx = {0, -1, 1, 0};
	static int[] dy = {-1, 0, 0, 1};
	static int[] cur = {0, 0};
	static int ate = 0;
	static int move = 0;
	static int size = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		fish = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 9) {
					cur[0] = j;
					cur[1] = i;
					// arr[b][a];
				} else if (now != 0) {
					fish[i][j] = now;
				}
			}
		}
		
		while (true) {
			visited = new boolean[N][N];
			boolean ck = bfs();
			if (!ck) break;
		}
		System.out.print(move);
	}
	
	static boolean bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
			o1[2] != o2[2] ? o1[2] - o2[2] : (o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0])
		);
		
		visited[cur[1]][cur[0]] = true;
		pq.add(new int[]{cur[0], cur[1], 0});
		boolean ck = false;
		
		while (!pq.isEmpty()) {
			cur = pq.poll();
			
			if (fish[cur[1]][cur[0]] > 0 && fish[cur[1]][cur[0]] < size) {
				// fish exists and baby shark can eat the fish
				ate++;
				ck = true;
				fish[cur[1]][cur[0]] = 0;
				move += cur[2];
				if (size == ate) {
					size++;
					ate = 0;
				}
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int x = cur[0] + dx[i];
				int y = cur[1] + dy[i];
				
				if (x >= 0 && x < N && y >= 0 && y < N && !visited[y][x] && fish[cur[1]][cur[0]] <= size) {
					visited[y][x] = true;
					pq.add(new int[] {x, y, cur[2] + 1});
				}
			}
		}
		
		return ck;
	}
}