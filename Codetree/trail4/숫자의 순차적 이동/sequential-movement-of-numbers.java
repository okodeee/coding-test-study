import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int N;
    static int[] dx = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            turn();
        }

        print();
    }

    static void turn() {
        // 작은 수부터 진행
        for (int n = 1; n <= N * N; n++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (grid[i][j] == n) {
                        op(i, j);
                        j = N + 1;
                        i = N + 1;
                        break;
                    }
                }
            }
        }
    }

    static void op(int x, int y) {
        int num = grid[x][y];

        int maxNum = 0;
        int dir = -1;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

            if (maxNum < grid[nx][ny]) {
                maxNum = grid[nx][ny];
                dir = i;
            }
        }

        // 숫자 교환
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        grid[x][y] = grid[nx][ny];
        grid[nx][ny] = num;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}