import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n+1][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = 0;
        dp[1][1] = coins[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-2][0] + coins[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-2][1]) + coins[i];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-2][2]) + coins[i];
            dp[i][3] = Math.max(dp[i-1][2], dp[i-2][3]) + coins[i];
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], Math.max(dp[n][2], dp[n][3]))));
    }
}