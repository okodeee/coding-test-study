import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = new int[] { 0, 1, -1, 0 };
    static int[] dy = new int[] { 1, 0, 0, -1 };
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 보드 입력받기
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    cycle(i, j, i, j, board[i][j], 0, -1);
                    if (result) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

//        cycle(0, 0, 0, 0, board[0][0], 0, -1);

        System.out.println("No");
    }

    static void cycle(int startX, int startY, int x, int y, char state, int corner, int direction) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            if (direction + i == 3) continue;   // 왔던 방향으로 다시 돌아가지 않도록

            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == state) {
                if (visited[nx][ny]) {
                    result = true;
                    return;
                }
                cycle(startX, startY, nx, ny, state, i != direction ? corner + 1 : corner, i);

                if (result) return;
            }
        }
    }
}