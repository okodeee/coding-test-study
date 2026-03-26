import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2;
        int y = N / 2;
        int d = 0;  // 0: ←, 1: ↓, 2: →, 3: ↑

        int result = 0;
        int steps = 1;
        int stepCount = 0;
        int turnCount = 0;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0) break;

            int sand = A[nx][ny];
            int move = 0;

            if (d == 0) {
                // 1%
                int pot = sand / 100;
                if (nx - 1 >= 0) {
                    A[nx - 1][y] += pot;
                } else  {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N) {
                    A[nx + 1][y] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 2%
                pot = sand * 2 / 100;
                if (nx - 2 >= 0) {
                    A[nx - 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 2 < N) {
                    A[nx + 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 7%
                pot = sand * 7 / 100;
                if (nx - 1 >= 0) {
                    A[nx - 1][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N) {
                    A[nx + 1][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 10%
                pot = sand / 10;
                if (nx - 1 >= 0 && ny - 1 >= 0) {
                    A[nx - 1][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N && ny - 1 >= 0) {
                    A[nx + 1][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 5%
                pot = sand * 5 / 100;
                if (ny - 2 >= 0) {
                    A[nx][ny - 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 남은 모래 전부
                pot = sand - move;
                if (ny - 1 >= 0) {
                    A[nx][ny - 1] += pot;
                } else {
                    result += pot;
                }
            } else if (d == 1) {
                // 1%
                int pot = sand / 100;
                if (ny - 1 >= 0) {
                    A[x][ny - 1] += pot;
                } else  {
                    result += pot;
                }
                move += pot;

                if (ny + 1 < N) {
                    A[x][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 2%
                pot = sand * 2 / 100;
                if (ny - 2 >= 0) {
                    A[nx][ny - 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (ny + 2 < N) {
                    A[nx][ny + 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 7%
                pot = sand * 7 / 100;
                if (ny - 1 >= 0) {
                    A[nx][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (ny + 1 < N) {
                    A[nx][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 10%
                pot = sand / 10;
                if (nx + 1 < N && ny - 1 >= 0) {
                    A[nx + 1][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N && ny + 1 < N) {
                    A[nx + 1][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 5%
                pot = sand * 5 / 100;
                if (nx + 2 < N) {
                    A[nx + 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 남은 모래 전부
                pot = sand - move;
                if (nx + 1 < N) {
                    A[nx + 1][ny] += pot;
                } else {
                    result += pot;
                }
            } else if (d == 2) {
                // 1%
                int pot = sand / 100;
                if (nx - 1 >= 0) {
                    A[nx - 1][y] += pot;
                } else  {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N) {
                    A[nx + 1][y] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 2%
                pot = sand * 2 / 100;
                if (nx - 2 >= 0) {
                    A[nx - 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 2 < N) {
                    A[nx + 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 7%
                pot = sand * 7 / 100;
                if (nx - 1 >= 0) {
                    A[nx - 1][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N) {
                    A[nx + 1][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 10%
                pot = sand / 10;
                if (nx - 1 >= 0 && ny + 1 < N) {
                    A[nx - 1][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx + 1 < N && ny + 1 < N) {
                    A[nx + 1][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 5%
                pot = sand * 5 / 100;
                if (ny + 2 < N) {
                    A[nx][ny + 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 남은 모래 전부
                pot = sand - move;
                if (ny + 1 < N) {
                    A[nx][ny + 1] += pot;
                } else {
                    result += pot;
                }
            } else if (d == 3) {
                // 1%
                int pot = sand / 100;
                if (ny - 1 >= 0) {
                    A[x][ny - 1] += pot;
                } else  {
                    result += pot;
                }
                move += pot;

                if (ny + 1 < N) {
                    A[x][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 2%
                pot = sand * 2 / 100;
                if (ny - 2 >= 0) {
                    A[nx][ny - 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (ny + 2 < N) {
                    A[nx][ny + 2] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 7%
                pot = sand * 7 / 100;
                if (ny - 1 >= 0) {
                    A[nx][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (ny + 1 < N) {
                    A[nx][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 10%
                pot = sand / 10;
                if (nx - 1 >= 0 && ny - 1 >= 0) {
                    A[nx - 1][ny - 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                if (nx - 1 >= 0 && ny + 1 < N) {
                    A[nx - 1][ny + 1] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 5%
                pot = sand * 5 / 100;
                if (nx - 2 >= 0) {
                    A[nx - 2][ny] += pot;
                } else {
                    result += pot;
                }
                move += pot;

                // 남은 모래 전부
                pot = sand - move;
                if (nx - 1 >= 0) {
                    A[nx - 1][ny] += pot;
                } else {
                    result += pot;
                }
            }

            // 해당 칸의 모래 제거
            A[nx][ny] = 0;
            x = nx;
            y = ny;
            stepCount++;

            if (stepCount == steps) {
                stepCount = 0;
                d = (d + 1) % 4;
                turnCount++;

                // 2번 회전할 때마다 이동 칸 수 증가
                if (turnCount == 2) {
                    turnCount = 0;
                    steps++;
                }
            }
        }

        System.out.println(result);
    }
}
