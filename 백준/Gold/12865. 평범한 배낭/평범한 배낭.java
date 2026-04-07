import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 물품의 수
        int K = Integer.parseInt(st.nextToken());   // 배낭의 최대 무게

        // dp[i][j] : i번째 물건까지 고려했을 때, 무게 j에서의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 현재 물건의 무게
            int V = Integer.parseInt(st.nextToken()); // 현재 물건의 가치

            for (int j = 1; j <= K; j++) {
                if (j < W) {
                    // 현재 배낭 무게(j)가 물건 무게(W)보다 작으면 못 넣음
                    // 이전 물건까지의 최댓값을 그대로 가져옴
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 넣지 않는 경우 vs (현재 물건을 넣기 위해 무게를 비운 상태의 가치 + 현재 가치)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
