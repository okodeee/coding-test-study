import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[2 * n + 2][2];
        
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int i = 2; i < 2 * n + 2; i++) {
            if (i % 2 == 1) {   // 홀수번째 (밑 삼각형)
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % 10007;
            } else {    // 짝수번째 (위 + top 삼각형)
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
                if (tops[i / 2 - 1] == 1) {
                    dp[i][1] = (dp[i][1] + dp[i - 1][1]) % 10007;
                }
            }
        }
        
        return dp[2 * n + 1][1];
    }
}