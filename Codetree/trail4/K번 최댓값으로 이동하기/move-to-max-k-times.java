import java.util.*;
public class Main {
    static int n, k;
    static int[] dx = new int[] { -1, 0, 0, 1 };
    static int[] dy = new int[] { 0, -1, 1, 0 };
    static int[][] grid;
    static int ax, ay;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        bfs(r-1, c-1, k);
    }

    static void bfs(int x, int y, int k) {
        if (k <= 0) {
            System.out.println((x + 1) + " " + (y + 1));
            return;
        }

        boolean[][] visited = new boolean[n][n];
        int v = grid[x][y];

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] { x, y });
        int maxNum = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] >= v) continue;

                visited[nx][ny] = true;
                maxNum = Math.max(maxNum, grid[nx][ny]);
                q.offer(new int[] { nx, ny });
            }
        }

        boolean moved = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == maxNum && visited[i][j]) {
                    moved = true;

                    bfs(i, j, k-1);

                    i = n;
                    break;
                }
            }
        }

        if (!moved) {
            System.out.println((x + 1) + " " + (y + 1));
            return;
        }

    }
}