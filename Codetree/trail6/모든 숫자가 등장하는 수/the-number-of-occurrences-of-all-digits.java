import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][][] dp = new int[n][1 << 10][10];
        
        // 초기조건
        // 1개를 1 ~ 9 중 하나로 고름
        for (int i = 1; i <= 9; i++) {
            dp[0][(1 << i)][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < (1 << 10); j++) {
                for (int k = 0; k < 10; k++) {
                    if (dp[i][j][k] == 0) continue; // dp값이 0이면 불가능

                    if (0 <= k - 1) {
                        dp[i + 1][j | (1 << (k - 1))][k - 1] += dp[i][j][k];
                        dp[i + 1][j | (1 << (k - 1))][k - 1] %= 10007;
                    }

                    if (k + 1 < 10) {
                        dp[i + 1][j | (1 << (k + 1))][k + 1] += dp[i][j][k];
                        dp[i + 1][j | (1 << (k + 1))][k + 1] %= 10007;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n-1][((1 << 10) - 1)][i];
            answer %= 10007;
        }

        System.out.println(answer);
    }
}