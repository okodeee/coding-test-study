import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        int[] dp = new int[1 << n];

        for (int i = 0; i < (1 << n); i++) {
            dp[i] = (int)1e9;
        }

        dp[0] = 0;

        // dp[i]가 계산되어있다는 가정 하에 다음 상태값 진행
        for (int i = 0; i < (1 << n); i++) {
            // 그 다음 물체를 k에 놓는 경우
            for (int j = 0; j < n; j++) {
                // 이미 k에 물체 놓임
                if (((i >> j) & 1) == 1) continue;

                int mnCost = cost[j];
                for (int l = 0; l < n; l++) {
                    if (((i >> l) & 1) == 1) {
                        mnCost = Math.min(mnCost, board[l][j]);
                    }
                }

                dp[i + (1 << j)] = Math.min(dp[i + (1 << j)], dp[i] + mnCost);

            }
        
        }

        int ans = (int)1e9;
        for(int i = 0; i < (1 << n); i++) {
            int cnt = 0;

            for(int j = 0; j < n; j++) {
                if(((i >> j) & 1) == 1)
                    cnt++;
            }
                
            if(cnt >= k) {
                ans = Math.min(ans, dp[i]);
            }
        }

        System.out.print(ans);
    }
}