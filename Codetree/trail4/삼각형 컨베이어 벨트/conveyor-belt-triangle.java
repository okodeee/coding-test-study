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

        grid = new int[3][N];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            turn();
        }

        print();
    }

    static void turn() {
        int temp1 = grid[0][N - 1];
        int temp2 = grid[1][N - 1];
        int temp3 = grid[2][N - 1];

        for (int i = 0; i < 3; i++) {
            for (int j = N - 2; j >= 0; j--) {
                grid[i][j + 1] = grid[i][j];
            }
        }

        grid[0][0] = temp3;
        grid[1][0] = temp1;
        grid[2][0] = temp2;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}