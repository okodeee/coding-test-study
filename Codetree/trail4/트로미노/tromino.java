import java.util.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[] dx = new int[] { -1, 0, 0, 1 };
    static int[] dy = new int[] { 0, -1, 1, 0 };
    static List<int[]> selected = new ArrayList<>();
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                selected.add(new int[] { i, j });
                visited[i][j] = true;
                select(i, j);
                selected.clear();
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    static void select(int x, int y) {
        if (selected.size() >= 3) {
            calculate();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            selected.add(new int[] { nx, ny });
            select(x, y);
            visited[nx][ny] = false;
            selected.remove(selected.size() - 1);
        }
    }

    static void calculate() {
        int sum = 0;
        for (int[] curr : selected) {
            sum += grid[curr[0]][curr[1]];
        }

        answer = Math.max(answer, sum);
    }
}