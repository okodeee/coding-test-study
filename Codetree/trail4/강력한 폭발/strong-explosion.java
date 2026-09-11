import java.util.*;
import java.io.*;

public class Main {
    static int[][][] bombDirections = {
        { {-2, 0}, {-1, 0}, {1, 0}, {2, 0} }, // 세로 폭탄
        { {-1, 0}, {0, -1}, {0, 1}, {1, 0} }, // 십자 폭탄
        { {-1, -1}, {-1, 1}, {1, -1}, {1, 1} } // X자 폭탄
    };
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

        isExploded = new boolean[N + 1][N + 1];
        backtracking(0, new int[bomb] );

        System.out.println(answer);
    }

    static void backtracking(int d, int[] s) {
        if (d >= bomb) {
            calculate(s);
            return;
        }

        for (int type = 0; type < 3; type++) {
            s[d] = type;
            backtracking(d + 1, s);
        }
    }

    static void calculate(int[] s) {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(isExploded[i], false);
        }

        for (int i = 0; i < s.length; i++) {
            int[] c = position.get(i);
            int x = c[0];
            int y = c[1];
            int bombType = s[i];

            isExploded[x][y] = true;

            for (int[] dir : bombDirections[bombType]) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
                isExploded[nx][ny] = true;
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