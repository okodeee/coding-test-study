import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int LIS = 0;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (children[i] > children[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            LIS = Math.max(LIS, dp[i]);
        }

        System.out.println(N - LIS);
    }
}
