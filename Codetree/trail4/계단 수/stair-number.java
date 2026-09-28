import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[][] dp = new int[n + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % 1000000007;
                if (j < 9) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % 1000000007;
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % 1000000007;
        }
        System.out.println(answer % 1000000007);
    }
}