import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (isCycle(i, j, -1, -1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }

    static boolean isCycle(int x, int y, int px, int py) {
        char color = board[x][y];
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || color != board[nx][ny]) continue;

            // 부모 노드로 되돌아가는 경우는 무시
            if (nx == px && ny == py) continue;

            // 이미 방문한 노드를 다시 만남 = 사이클!
            if (visited[nx][ny]) return true;

            // 재귀 탐색
            if (isCycle(nx, ny, x, y)) return true;
        }

        return false;
    }
}
