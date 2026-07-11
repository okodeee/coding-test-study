import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] dis;
    static int[] dx = new int[] {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        dis = new int[N][N];
        BFS(r1-1, c1-1);

        if (r1 == r2 && c1 == c2) {
            System.out.println(0);
            return;
        }

        System.out.println(dis[r2-1][c2-1] > 0 ? dis[r2-1][c2-1] : -1);
    }

    static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;
        q.offer(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                dis[nx][ny] = dis[x][y] + 1;
                q.offer(new int[] {nx, ny});
            }
        }

    }
}