import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] rest = new int[2 * N + 1];
		boolean[] robots = new boolean[2 * N + 1];
		
		int up = 1;
		int down = N;
		
		int count = 0;
		
		for (int i = 0; i < 2 * N; i++) {
			rest[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		int step = 0;
		
		while (count < K) {
			step++;
			// 1. 컨베이어 벨트 회전
			up--;
			if (up < 1) up = 2 * N;
			down--;
			if (down < 1) down = 2 * N;
			robots[down] = false;
			
			for (int i = 0; i < N - 1; i++) {
				// robots 내에서의 포지션은? N - i - 1
				int pos = down - i;
				if (pos < 1) pos += 2 * N;
				int left_pos = pos - 1;
				if (left_pos < 1) left_pos += 2 * N;
				
				if (!robots[pos] && robots[left_pos] && rest[pos] > 0) {
					robots[left_pos] = false;
					robots[pos] = true;
					rest[pos]--;
					if (rest[pos] == 0) {
						count++;
					}
				}
			}
			if (count >= K) break;
			if (robots[down]) robots[down] = false;
			
			if (rest[up] > 0) {
				robots[up] = true;
				rest[up]--;
				if (rest[up] == 0) count++;
			}
			if (count >= K) break;
		}
		System.out.print(step);
	}
}