import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        for (int[] row : dist) Arrays.fill(row, 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        // 모든 학생 간 키 비교 가능 여부 계산
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int known = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (dist[i][j] == 1 || dist[j][i] == 1) known++;
            }
            if (known == N - 1) count++;
        }

        System.out.println(count);
    }
}