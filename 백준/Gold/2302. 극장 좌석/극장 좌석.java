import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] vip = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int seat = Integer.parseInt(br.readLine());
            vip[seat] = true;
        }

        int[][] dp = new int[N + 1][2];  // 해당 좌석까지의 앉을 수 있는 가짓수 (해당 번호 안 바뀜, 바뀜)
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];

            if (!vip[i - 1] && !vip[i]) {
                dp[i][1] = dp[i - 1][0];
            }
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
