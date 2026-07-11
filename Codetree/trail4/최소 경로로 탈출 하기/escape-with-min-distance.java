import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] snake;
    static int[][] dis;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        snake = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                snake[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dis = new int[N][M];
        visited = new boolean[N][M];
        BFS();

        System.out.println(dis[N-1][M-1] == 0 ? -1 : dis[N-1][M-1]);
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || snake[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                dis[nx][ny] = dis[x][y] + 1;
                q.offer(new int[] {nx, ny});
            }
        }
    }
}