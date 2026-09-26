import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[2 * n + 1][n + 1]; // { 시행횟수, red 개수 }
        for (int i = 0; i <= 2 * n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= 2 * n; i++) {
            int red = sc.nextInt();
            int blue = sc.nextInt();

            dp[i][0] = dp[i-1][0] + blue;   // 지금까지 blue만 고름
            for (int j = 1; j <= n; j++) {

                dp[i][j] = Math.max(dp[i-1][j-1] + red, dp[i-1][j] + blue);
            }
        }
        // Please write your code here.
        System.out.println(dp[2 * n][n]);
    }
}