import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int x, y;
    static boolean[][] matrix1;
    static boolean[][] matrix2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix1 = new boolean[N][M];
        matrix2 = new boolean[N][M];

        // matrix1 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix1[i][j] = str.charAt(j) == '1';
            }
        }

        // matrix2 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix2[i][j] = str.charAt(j) == '1';
            }
        }

        int answer = 0;
        while (!same()) {
            if (!operation()) {
                System.out.println(-1);
                return;
            }

            answer++;
        }

        System.out.println(answer);
    }

    static boolean same() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    x = i;
                    y = j;
                    return false;
                }
            }
        }

        return true;
    }

    static boolean operation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = x + i;
                int ny = y + j;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) return false;

                matrix1[nx][ny] = !matrix1[nx][ny];
            }
        }

        return true;
    }
}
