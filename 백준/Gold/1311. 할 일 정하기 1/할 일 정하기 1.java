import java.io.*;
import java.util.*;

/*
 * dp[visited] = visited 상태로 일이 배정됐을 때의 최소 비용
 */
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

        int total = 1 << N; // 2^N
        int[] dp = new int[total];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 0번 사람이 각 일을 맡는 경우 초기화
        for (int work = 0; work < N; work++) {
            int visit = 1 << work;
            dp[visit] = cost[0][work];
        }

        for (int visited = 1; visited < total; visited++) {
            if (dp[visited] == Integer.MAX_VALUE) continue;

            int next = Integer.bitCount(visited);

            for (int work = 0; work < N; work++) {

                // 이미 배정되었으면 패스
                if ((visited & (1 << work)) > 0) continue;

                dp[visited | (1 << work)] = Math.min(dp[visited | (1 << work)], dp[visited] + cost[next][work]);
            }
        }

        System.out.println(dp[total - 1]);
    }
}
