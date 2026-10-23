import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        // dp[i][j]: i번째 행 직전까지 선택을 완료했고, 지금까지 선택한 열의 위치가 bitmask로 표시
        int[][] dp = new int[n + 1][1 << n];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        // 초기조건
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++){
                if (dp[i][j] == Integer.MIN_VALUE) continue;

                // i번째 행에 k번 열을 고르게 되는 겨우
                for (int k = 0; k < n; k++) {
                    // 이미 선택함 
                    if (((j >> k) & 1) == 1) continue;

                    dp[i + 1][j + (1 << k)] = Math.max(dp[i + 1][j + (1 << k)], dp[i][j] + board[i][k]);
                }
            }
        }

        System.out.print(dp[n][(1 << n) - 1]);
    }
}