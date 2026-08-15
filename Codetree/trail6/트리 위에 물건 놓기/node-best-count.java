import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dp = new int[N+1][2];
        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int n) {
        visited[n] = true;

        // 기저 조건: 본인을 선택하는 경우는 우선 물건 1개 확보
        dp[n][0] = 0;
        dp[n][1] = 1;

        for (int next : graph[n]) {
            if (visited[next]) continue;

            dfs(next);

            dp[n][0] += dp[next][1];

            dp[n][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}