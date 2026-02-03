import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static boolean[][] mirror;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] shortest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        mirror = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == '1') {
                    mirror[i][j] = true;
                }
            }
        }

        shortest = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                shortest[i][j] = Integer.MAX_VALUE;
            }
        }
        dijkstra();

        System.out.println(shortest[N - 1][M - 1]);
    }

    static void dijkstra() {
        boolean[][] visited = new boolean[N][M];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[] { 0, 0, 0 });
        shortest[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            visited[x][y] = true;
            shortest[x][y] = curr[2];

            // (N, M)까지 모두 구함
            if (x == N - 1 && y == M - 1) return;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                if (mirror[nx][ny] && shortest[nx][ny] > curr[2] + 1) {
                    shortest[nx][ny] = curr[2] + 1;
                    pq.offer(new int[] { nx, ny, curr[2] + 1 });
                } else if (!mirror[nx][ny] && shortest[nx][ny] > curr[2]){
                    shortest[nx][ny] = curr[2];
                    pq.offer(new int[] { nx, ny, curr[2] });
                }
            }
        }
    }
}
