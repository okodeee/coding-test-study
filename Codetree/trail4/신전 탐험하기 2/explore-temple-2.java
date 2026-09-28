import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp0 = new int[n+1][3];   // { 현재까지 탐색한 층, 해당 층의 방 }
        int[][] dp1 = new int[n+1][3];   // { 현재까지 탐색한 층, 해당 층의 방 }
        int[][] dp2 = new int[n+1][3];   // { 현재까지 탐색한 층, 해당 층의 방 }
        dp0[1][0] = arr[1][0];
        dp1[1][1] = arr[1][1];
        dp2[1][2] = arr[1][2];
        
        for (int i = 2; i <= n; i++) {
            dp0[i][0] = Math.max(dp0[i-1][1], dp0[i-1][2]) + arr[i][0];
            dp0[i][1] = Math.max(dp0[i-1][0], dp0[i-1][2]) + arr[i][1];
            dp0[i][2] = Math.max(dp0[i-1][0], dp0[i-1][1]) + arr[i][2];

            dp1[i][0] = Math.max(dp1[i-1][1], dp1[i-1][2]) + arr[i][0];
            dp1[i][1] = Math.max(dp1[i-1][0], dp1[i-1][2]) + arr[i][1];
            dp1[i][2] = Math.max(dp1[i-1][0], dp1[i-1][1]) + arr[i][2];

            dp2[i][0] = Math.max(dp2[i-1][1], dp2[i-1][2]) + arr[i][0];
            dp2[i][1] = Math.max(dp2[i-1][0], dp2[i-1][2]) + arr[i][1];
            dp2[i][2] = Math.max(dp2[i-1][0], dp2[i-1][1]) + arr[i][2];
        }

        int answer = Math.max(dp0[n][1], dp0[n][2]);
        answer = Math.max(answer, Math.max(dp1[n][0], dp1[n][2]));
        answer = Math.max(answer, Math.max(dp2[n][0], dp2[n][1]));

        System.out.println(answer);
    }
}