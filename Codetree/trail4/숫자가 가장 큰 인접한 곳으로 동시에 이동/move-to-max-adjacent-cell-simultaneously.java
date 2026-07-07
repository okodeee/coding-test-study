import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int[][] count;
    static int N, M;
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            count[r][c] = 1;
        }

        for (int i = 0; i < T; i++) {
            move();
        }
        
        System.out.println(M);
    }

    static void move() {
        int[][] nextCount = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구슬이 있다면 움직이기 
                if (count[i][j] > 0) {
                    int max = 0;
                    int dir = -1;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                        if (max < grid[nx][ny]) {
                            max = grid[nx][ny];
                            dir = d;
                        }
                    }

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    nextCount[nx][ny]++;
                }
            }
        }

        // 구슬 충돌
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (nextCount[i][j] > 1) {
                    M -= nextCount[i][j];
                    nextCount[i][j] = 0;
                }
            }
        }

        count = nextCount;
    }
}