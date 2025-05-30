import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[][] quad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        quad = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String cur = br.readLine();
            for (int j = 0; j < N; j++) {
                quad[i][j] = cur.charAt(j) == '1';
            }
        }
        String answer = dfs(0, 0, N);
        System.out.println(answer);
    }

    public static String dfs(int x, int y, int size) {
        if (size == 1) {
            if (quad[x][y]) return "1";
            else return "0";
        }

        String topLeft = dfs(x, y, size / 2);
        String topRight = dfs(x, y + size / 2, size / 2);
        String bottomLeft = dfs(x + size / 2, y, size / 2);
        String bottomRight = dfs(x + size / 2, y + size / 2, size / 2);

        if (topLeft.length() == 1 && topLeft.equals(topRight) && bottomLeft.equals(bottomRight) && topLeft.equals(bottomLeft)) {
            return topLeft;
        } else {
            return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
        }
    }
}