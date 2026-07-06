import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int highest = N;
        for (int col = K - 1; col < K + M - 1; col++) {
            int height = 0;

            for (int i = 0; i < N; i++) {
                if (grid[i][col] != 0) {
                    break;
                }

                height++;
            }

            highest = Math.min(highest, height);
        }

        // 블럭 두기
        for (int col = K - 1; col < K + M - 1; col++) {
            grid[highest - 1][col] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}