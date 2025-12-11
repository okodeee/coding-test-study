import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static int[][] distance;

    static class room {
        int x;
        int y;

        room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] field = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '1') {
                    field[i][j] = true; // 흰 방이 true
                }
            }
        }

        // 최단거리 구하기 (최소 검은 방)
        Queue<room> q = new LinkedList<>();
        distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = 100;
            }
        }
        distance[0][0] = 0;
        q.offer(new room(0, 0));

        while (!q.isEmpty()) {
            room current = q.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int next = field[nx][ny] ? distance[x][y] : distance[x][y] + 1;

                    if (next < distance[nx][ny]) {
                        distance[nx][ny] = next;
                        q.offer(new room(nx, ny));
                    }
                }
            }
        }

        System.out.println(distance[n - 1][n - 1]);
    }
}