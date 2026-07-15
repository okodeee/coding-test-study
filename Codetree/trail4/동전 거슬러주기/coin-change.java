import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int INF = 100001; 
        int[] DP = new int[M + 1];
        Arrays.fill(DP, INF);
        DP[0] = 0;

        for (int i = 1; i <= M; i++) {
            int min = INF;
            for (int j = 0; j < N; j++) {
                if (i >= coins[j]) {
                    min = Math.min(min, DP[i - coins[j]]);
                }
            }

            if (min != INF) {
                DP[i] = min + 1;
            } else {
                DP[i] = INF; // 만들 수 없다면 INF 상태 유지
            }
        }

        if (DP[M] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(DP[M]);
        }
    }
}