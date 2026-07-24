import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] + x - sum[i-1][j-1];
            }
        }

        int answer = 0;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= N; j++) {
                int square = sum[i][j] - sum[i][j-K] - sum[i-K][j] + sum[i-K][j-K];
                answer = Math.max(answer, square);
            }
        }

        System.out.println(answer);
    }
}