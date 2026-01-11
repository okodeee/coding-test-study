import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        // 적록색약 아닐 때 구역 구하기
        int area1 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    area1++;
                    dfs(i, j);
                }
            }
        }

        // 적록색약일 때
        int area2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    area2++;
                    blindDfs(i, j);
                }
            }
        }

        System.out.println(area1 + " " + area2);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        int color = grid[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && grid[nx][ny] == color) {
                dfs(nx, ny);
            }
        }
    }

    static void blindDfs(int x, int y) {
        visited[x][y] = true;
        int color = grid[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if ((color == 'B' && grid[nx][ny] != 'B') || (color != 'B' && grid[nx][ny] == 'B')) continue;
                blindDfs(nx, ny);
            }
        }
    }
}