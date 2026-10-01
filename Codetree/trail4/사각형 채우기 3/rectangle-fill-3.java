import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        long[] dp = new long[n+1];
        dp[0] = 1;
        if (n <= 0) {
            System.out.println(dp[n]);
            return;
        }
        dp[1] = 2;
        if (n <= 1) {
            System.out.println(dp[n]);
            return;
        }
        dp[2] = 7;

        for (int i = 3; i <= n; i++) {
            dp[i] = (3 * dp[i - 1] + dp[i - 2] - dp[i - 3]) % 1000000007;

            if (dp[i] < 0) {
                dp[i] += 1000000007;
            }
        }
    
        System.out.println(dp[n]);
    }
}