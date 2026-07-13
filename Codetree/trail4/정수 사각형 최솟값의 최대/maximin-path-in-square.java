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

        if (N == 1) {
            System.out.println(num[1][1]);
            return;
        }

        int[][] min = new int[N+1][N+1];
        min[1][1] = num[1][1];
        for (int i = 2; i <= N; i++) {
            min[1][i] = Math.min(min[1][i-1], num[1][i]);
            min[i][1] = Math.min(min[i-1][1], num[i][1]);
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                min[i][j] = Math.min(Math.max(min[i-1][j], min[i][j-1]), num[i][j]);
            }
        }

        System.out.println(min[N][N]);
    }
}