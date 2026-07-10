import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] { 1, 0 };
    static int[] dy = new int[] { 0, 1 };
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
        
        System.out.println(answer ? 1 : 0);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        
        if (x == N - 1 && y == M - 1) {
            answer = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;

            DFS(nx, ny);
        }
    }
}