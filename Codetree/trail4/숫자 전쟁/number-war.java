import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n+2][n+2];
        
        // 역방향
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                
                // 1. 남우의 카드가 상대방 카드보다 작은 경우 -> 남우가 점수를 얻고 남우 카드만 버림
                if (a[i] > b[j]) {
                    dp[i][j] = dp[i][j + 1] + b[j];
                } 
                // 2. 상대방 카드가 더 작은 경우 -> 상대방 카드만 버리거나 규칙 2(둘 다 버리기) 가능
                else if (a[i] < b[j]) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                } 
                // 3. 두 카드가 같은 경우 -> 규칙 2 적용
                else {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                
            }
        }

        System.out.println(dp[1][1]);
    }
}