import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] num = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] DP = new int[N+1][N+1];
        DP[1][1] = num[1][1];
        for (int i = 2; i <= N; i++) {
            DP[1][i] = Math.max(DP[1][i-1], num[1][i]);
            DP[i][1] = Math.max(DP[i-1][1], num[i][1]);
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                DP[i][j] = Math.max(Math.min(DP[i-1][j], DP[i][j-1]), num[i][j]);
            }
        }

        System.out.println(DP[N][N]);

    }
}