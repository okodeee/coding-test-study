import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        explode(x - 1, y - 1); // 0-based

        print();
    }

    static void explode(int x, int y) {
        int size = grid[x][y];

        for (int i = 0; i < size; i++) {
            // 상
            if (x - i >= 0) {
            grid[x - i][y] = 0;
            }
            // 하
            if (x + i < N) {
                grid[x + i][y] = 0;
            }
            // 좌
            if (y - i >= 0) {
                grid[x][y - i] = 0;
            }
            // 우
            if (y + i < N) {
                grid[x][y + i] = 0;
            }
        }

        gravity();
    }

    static void gravity() {
        for (int col = 0 ; col < N; col++) {
            int index = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][col] == 0) continue;

                grid[index--][col] = grid[i][col];
            }

            // 남은 부분 0으로
            for (int i = index; i >= 0; i--) {
                grid[i][col] = 0;
            }
        }
    }

    static void print() {
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