import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int N;
    static int[] population;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dp = new int[N + 1][2];
        dfs(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int idx, int parent) {
        dp[idx][0] = 0;
        dp[idx][1] = population[idx];

        for (int child : graph[idx]) {
            if (child == parent) continue;
            dfs(child, idx);
            dp[idx][1] += dp[child][0];
            dp[idx][0] += Math.max(dp[child][0], dp[child][1]);
        }
    }
}