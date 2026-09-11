import java.util.*;
import java.io.*;

public class Main {
    static int[] dx1 = new int[] { -2, -1, 1, 2 };
    static int[] dy1 = new int[] { 0, 0, 0, 0 };
    static int[] dx2 = new int[] { -1, 0, 0, 1 };
    static int[] dy2 = new int[] { 0, -1, 1, 0 };
    static int[] dx3 = new int[] { -1, -1, 1, 1 };
    static int[] dy3 = new int[] { -1, 1, -1, 1 };
    static int N;
    static int bomb;
    static List<int[]> position = new ArrayList<>();
    static int[][] grid;
    static boolean[][] isExploded;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bomb = 0;
        grid = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    bomb++;
                    position.add(new int[] {i, j});
                }
            }
        }

        backtracking(0, new int[bomb] );

        System.out.println(answer);
    }

    static void backtracking(int d, int[] s) {
        if (d >= bomb) {
            calculate(s);
            return;
        }

        s[d] = 1;
        backtracking(d+1, s);

        s[d] = 2;
        backtracking(d+1, s);

        s[d] = 3;
        backtracking(d+1, s);
    }

    static void calculate(int[] s) {
        isExploded = new boolean[N+1][N+1];
        for (int i = 0; i < s.length; i++) {
            int[] c = position.get(i);
            int x = c[0];
            int y = c[1];

            isExploded[x][y] = true;

            if (s[i] == 1) {
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx1[j];
                    int ny = y + dy1[j];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N) continue;

                    isExploded[nx][ny] = true;
                }   
            } else if (s[i] == 2) {
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx2[j];
                    int ny = y + dy2[j];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N) continue;

                    isExploded[nx][ny] = true;
                }   
            } else if (s[i] == 3) {
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx3[j];
                    int ny = y + dy3[j];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N) continue;

                    isExploded[nx][ny] = true;
                }   
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (isExploded[i][j]) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
}