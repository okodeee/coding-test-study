import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][n]; // 0-based
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 무한대 값 설정 (오버플로우 방지 대략 10억)
        final int INF = (int)1e9;
        
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[1 << 0][0] = 0; 
        
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                // j번 도시에 방문한 적이 없거나, 도달 불가능한 상태
                if (((i >> j) & 1) == 0 || dp[i][j] == INF) continue;

                for (int k = 0; k < n; k++) {
                    // 이미 방문
                    if (((i >> k) & 1) == 1) continue;

                    // 갈 수 없음
                    if (cost[j][k] == 0) continue;

                    dp[i + (1 << k)][k] = Math.min(dp[i + (1 << k)][k], dp[i][j] + cost[j][k]);
                }
            }
        }

        int answer = INF;
        // 모든 도시를 다 방문한 상태: (1 << n) - 1
        for (int i = 0; i < n; i++) {
            // i번 도시에서 다시 0번으로 돌아오는 길이 있을 때만 최솟값 갱신
            if (cost[i][0] != 0 && dp[(1 << n) - 1][i] != INF) {
                answer = Math.min(answer, dp[(1 << n) - 1][i] + cost[i][0]);
            }
        }

        System.out.println(answer);
    }
}
