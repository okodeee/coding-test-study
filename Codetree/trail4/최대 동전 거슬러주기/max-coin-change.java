import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[M+1];
        Arrays.fill(DP, -1);
        DP[0] = 0;
        for (int i = 0; i < N; i++) {
            int coin = coins[i];
            for (int j = coin; j < M+1; j++) {
                if (DP[j - coin] != -1) {
                    DP[j] = Math.max(DP[j], DP[j - coin] + 1);
                }
            }
        }

        System.out.println(DP[M]);
    }
}