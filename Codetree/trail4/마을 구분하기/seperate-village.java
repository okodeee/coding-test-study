import java.util.*;

public class Main {
    static int n, people;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        int village = 0;
        visited = new boolean[n][n];
        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    people = 0;
                    village++;
                    dfs(i, j);
                    num.add(people);
                }
            }
        }

        Collections.sort(num);
        StringBuilder sb = new StringBuilder();
        for (int p : num) {
            sb.append(p).append('\n');
        }

        System.out.println(village);
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        people++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}