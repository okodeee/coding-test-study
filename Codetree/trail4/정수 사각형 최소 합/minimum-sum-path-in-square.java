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

        int[][] sum = new int[N+1][N+1];

        sum[1][N] = num[1][N];
        for (int i = N-1; i > 0; i--) {
            sum[1][i] = sum[1][i+1] + num[1][i];
        }

        for (int i = 1; i <= N; i++) {
            sum[i][N] = sum[i-1][N] + num[i][N];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = N-1; j > 0; j--) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j+1]) + num[i][j];
            }
        }

        System.out.println(sum[N][1]);
    }
}