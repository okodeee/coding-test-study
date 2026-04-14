import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 1 << N;
        // dp[현재 있는 도시][방문 현황]
        int[][] dp = new int[N][total];

        int INF = Integer.MAX_VALUE / 2;
        for (int[] row : dp) Arrays.fill(row, INF);

        // 어느 곳에서 출발하든 순회하기 때문에 0부터 출발한다고 지정
        dp[0][1] = 0;

        for (int visited = 1; visited < total; visited++) {
            for (int curr = 0; curr < N; curr++) {

                // 현재 도시가 방문 현황에 포함되어야 함
                if ((visited & (1 << curr)) == 0) continue;

                for (int next = 0; next < N; next++) {
                    // 다음 도시가 방문 현황에 포함되지 않아야 함
                    if ((visited & (1 << next)) > 0) continue;
                    
                    // 다음 도시로 가는 길이 있어야 함
                    if (cost[curr][next] == 0) continue;

                    int nextVisited = visited | (1 << next);
                    dp[next][nextVisited] = Math.min(dp[next][nextVisited], dp[curr][visited] + cost[curr][next]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            // 0번 도시로 돌아오는 길이 있어야 함
            if (cost[i][0] == 0) continue;

            answer = Math.min(answer, dp[i][total - 1] + cost[i][0]);
        }

        System.out.println(answer);
    }
}
