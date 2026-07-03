import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        // 행
        for (int i = 0; i < N; i++) {
            int seq = 1;    // 연속된 숫자 수
            int prev = 0;   // 이전 숫자

            for (int j = 0; j < N; j++) {
                if (prev == grid[i][j]) {
                    seq++;
                } else {
                    seq = 1;
                    prev = grid[i][j];
                }

                if (seq >= M) {
                    answer++;
                    break;
                }
            }
        }

        // 열
        for (int i = 0; i < N; i++) {
            int seq = 1;    // 연속된 숫자 수
            int prev = 0;   // 이전 숫자

            for (int j = 0; j < N; j++) {
                if (prev == grid[j][i]) {
                    seq++;
                } else {
                    seq = 1;
                    prev = grid[j][i];
                }

                if (seq >= M) {
                    answer++;
                    break;
                } 
            }
        }

        System.out.println(answer);
    }
}