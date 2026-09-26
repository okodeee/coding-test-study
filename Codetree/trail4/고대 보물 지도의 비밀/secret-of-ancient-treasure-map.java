import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[N+1][K+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        
        // 1번째 원소 초기화
        if (arr[1] < 0) {
            if (K >= 1) dp[1][1] = arr[1];
        } else {
            dp[1][0] = arr[1];
        }

        int answer = Integer.MIN_VALUE;
        
        for (int j = 0; j <= K; j++) {
            answer = Math.max(answer, dp[1][j]);
        }
        
        for (int i = 2; i <= N; i++) {
            if (arr[i] >= 0) {
                dp[i][0] = Math.max(dp[i-1][0], 0) + arr[i];

                for (int j = 1; j <= K; j++) {
                    if (dp[i-1][j] != Integer.MIN_VALUE) {
                        dp[i][j] = dp[i-1][j] + arr[i];
                    }
                }
            } else {
                if (K >= 1) {
                    dp[i][1] = arr[i];
                }

                for (int j = 1; j <= K; j++) {
                    if (dp[i-1][j-1] != Integer.MIN_VALUE) {
                        // 기존에 새로 시작한 값(dp[i][j])이 있을 수 있으므로 Math.max 처리
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + arr[i]);
                    }
                }
            }

            for (int j = 0; j <= K; j++) {
                answer = Math.max(answer, dp[i][j]);
            }            
        }

        System.out.println(answer);
    }
}