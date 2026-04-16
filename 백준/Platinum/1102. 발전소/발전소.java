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

        int state = 0;
        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'Y') {
                state |= 1 << i;
            }
        }

        int P = Integer.parseInt(br.readLine());

        // 이미 P개 이상의 발전소가 켜져 있음
        if (Integer.bitCount(state) >= P) {
            System.out.println(0);
            return;
        }

        int total = 1 << N;
        int[] dp = new int[total];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[state] = 0;

        int answer = Integer.MAX_VALUE;
        for (int i = state; i < total; i++) {
            if (Integer.bitCount(i) >= P) continue;

            if (dp[i] == Integer.MAX_VALUE) continue;

            // 고장난 발전소 중 재시작할 발전소
            for (int t = 0; t < N; t++) {
                if ((i & (1 << t)) > 0) continue;

                // 고장나지 않은 발전소 이용
                for (int f = 0; f < N; f++) {
                    if ((i & (1 << f)) == 0) continue;

                    int nextState = i | 1 << t;
                    dp[nextState] = Math.min(dp[nextState], dp[i] + cost[f][t]);

                    if (Integer.bitCount(nextState) >= P) {
                        answer = Math.min(answer, dp[nextState]);
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }
}
