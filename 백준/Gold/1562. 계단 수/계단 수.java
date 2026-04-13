import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 10) {
            System.out.println(0);
            return;
        }

        // dp[depth][prev][visited]
        long[][][] dp = new long[N + 1][10][1 << 10];

        // 초기화: 1~9로 시작
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        // 전이
        for (int d = 1; d < N; d++) {
            for (int prev = 0; prev < 10; prev++) {
                for (int visited = 0; visited < (1 << 10); visited++) {
                    if (prev > 0) {
                        dp[d + 1][prev - 1][visited | (1 << (prev - 1))] = (dp[d + 1][prev - 1][visited | (1 << (prev - 1))] + dp[d][prev][visited]) % 1000000000;
                    }

                    if (prev < 9) {
                        dp[d + 1][prev + 1][visited | (1 << (prev + 1))] = (dp[d + 1][prev + 1][visited | (1 << (prev + 1))] + dp[d][prev][visited]) % 1000000000;
                    }
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i][(1 << 10) - 1]) % 1000000000;
        }
        System.out.println(answer);
    }
}
