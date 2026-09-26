import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] s = new int[n];
        int[] e = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[m+1][n];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for(int i = 0; i < n; i++) {
            if (s[i] <= 1 && e[i] >= 1) dp[1][i] = 0;
        }
        
        for (int i = 2; i <= m; i++) {  // 날짜
            for (int j = 0; j < n; j++) {   // 오늘 입을 옷
                if (s[j] > i || i > e[j]) continue;

                for (int k = 0; k < n; k++) {   // 어제 입은 옷                   
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Math.abs(v[j] - v[k]));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[m][i]);
        }

        System.out.println(answer);
    }
}