import java.io.*;
import java.util.*;

/*
 * dp[i][visited] = visited 상태에서 현재 도시 i에 있을 때,
 * 남은 도시 모두 돌고 0번 도시로 돌아오는 최소 비용
 * 시작 도시를 0번으로 고정 (어느 도시에서 출발해도 순환이므로 동일)
 */
public class Main {
    static int N;
    static int[][] cost;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 1 << N; // 2^N
        dp = new int[N][total];
        for (int[] row : dp) Arrays.fill(row, INF);

        // 시작: 0번 도시에 있고, 0번 도시 방문함
        dp[0][1] = 0;

        for (int visited = 1; visited < total; visited++) {
            for (int cur = 0; cur < N; cur++) {
                if (dp[cur][visited] == INF) continue;

                // cur이 visited에 포함되어 있어야 함
                if ((visited & (1 << cur)) == 0) continue;

                for (int next = 0; next < N; next++) {
                    if ((visited & (1 << next)) != 0) continue; // 이미 방문
                    if (cost[cur][next] == 0) continue; // 길 없음

                    int nextVisited = visited | (1 << next);
                    dp[next][nextVisited] = Math.min(dp[next][nextVisited], dp[cur][visited] + cost[cur][next]);
                }
            }
        }

        // 모든 도시 방문 후 0번으로 돌아오는 최소 비용
        int allVisited = total - 1;
        int ans = INF;
        for (int last = 1; last < N; last++) {
            if (cost[last][0] == 0) continue;
            ans = Math.min(ans, dp[last][allVisited] + cost[last][0]);
        }

        System.out.println(ans);
    }
}
