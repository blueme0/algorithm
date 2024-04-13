import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int N, Q;
	static int size;
	static int[][] ice;
	static Queue<Integer> L;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, N);
		ice = new int[size][size];
		L = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L.add(Integer.parseInt(st.nextToken()));
		}
		
		while (!L.isEmpty()) {
			int cur = (int) Math.pow(2, L.poll());
			for (int i = 0; i < size; i += cur) {
				for (int j = 0; j < size; j += cur) {
					rotate(cur, new int[] {j, i});
				}
			}
			reduce();
		}
		int sum = sum();
		int max = bfs();
		System.out.println(sum);
		System.out.println(max);
	}
	
	static int bfs() {
		int max = 0;
		boolean[][] visited = new boolean[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j] && ice[i][j] != 0) {
					Queue<int[]> queue = new LinkedList();
					queue.add(new int[] {j, i});
					visited[i][j] = true;
					int count = 1;
					
					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = cur[0] + dx[k];
							int y = cur[1] + dy[k];
							if (x >= 0 && x < size && y >= 0 && y < size && ice[y][x] != 0) {
								if (!visited[y][x]) {
									queue.add(new int[] {x, y});
									visited[y][x] = true;
									count++;
								}
							}
						}
					}
					if (count == 1) count = 0;
					max = Math.max(max, count);
				}
			}
		}
		return max;
	}
	
	static int sum() {
		int result = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				result += ice[i][j];
			}
		}
		return result;
	}
	
	static void reduce() {
		Queue<int[]> queue = new LinkedList();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (ice[i][j] == 0) continue;
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int x = j + dx[k];
					int y = i + dy[k];
					if (x >= 0 && x < size && y >= 0 && y < size) {
						if (ice[y][x] > 0) count++;
					}
				}
				if (count < 3) {
					if (ice[i][j] == 1) queue.add(new int[] {j, i});
					else ice[i][j]--;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			ice[cur[1]][cur[0]]--;
		}
	}
	
	static void rotate(int s, int[] p) {
		int[][] temp = new int[s][s];
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				temp[j][s - 1 - i] = ice[p[1] + i][p[0] + j];
			}
		}
		
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				ice[p[1] + i][p[0] + j] = temp[i][j];
			}
		}
	}
}