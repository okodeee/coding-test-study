import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int N;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] pos = new int[] { r - 1, c - 1 };
        move(pos);
    }

    static void move(int[] pos) {
        sb.append(grid[pos[0]][pos[1]]).append(' ');
        int dir = -1;    // 다음으로 이동할 방향

        for (int i = 0; i < 4; i++) {
            int nx = pos[0] + dx[i];
            int ny = pos[1] + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if (grid[nx][ny] > grid[pos[0]][pos[1]]) {
                dir = i;
                break;
            }
        }

        if (dir == -1) { // 이동할 수 없음
            System.out.println(sb);
            return;
        }

        int nx = pos[0] + dx[dir];
        int ny = pos[1] + dy[dir];

        move(new int[] { nx, ny });
    }
}