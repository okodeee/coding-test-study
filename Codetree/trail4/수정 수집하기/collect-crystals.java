import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();
        // Please write your code here.
        int[][] dp = new int[N+1][K+1];
        dp[1][0] = s.charAt(0) == 'L' ? 1 : 0;
        dp[1][1] = s.charAt(0) == 'R' ? 1 : 0;
        
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + (s.charAt(i-1) == 'L' ? 1 : 0);
            answer = Math.max(answer, dp[i][0]);

            for (int j = 1; j <= Math.min(K, i); j++) {
                char pos = (j % 2 == 0) ? 'L' : 'R';
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                
                if (s.charAt(i-1) == pos) {
                    dp[i][j]++;
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}