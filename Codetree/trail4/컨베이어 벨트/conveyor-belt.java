import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        grid = new int[2][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grid[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grid[1][i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < T; i++) {
            turn();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(grid[0][i]).append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < N; i++) {
            sb.append(grid[1][i]).append(' ');
        }

        System.out.println(sb);
    }

    static void turn() {
        int temp1 = grid[0][N - 1];
        int temp2 = grid[1][N - 1];

        for (int i = N - 2; i >= 0; i--) {
            grid[0][i + 1] = grid[0][i];
            grid[1][i + 1] = grid[1][i];
        }

        grid[0][0] = temp2;
        grid[1][0] = temp1;
    }
}