import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
            data[i][2] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[N+1][3];   // { 현재까지 탐색한 층, 해당 층의 방 }
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + data[i][0];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + data[i][1];
            dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + data[i][2];
        }

        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}