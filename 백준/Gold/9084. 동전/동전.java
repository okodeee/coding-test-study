import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] count = new int[M + 1];
            count[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    count[i] += count[i - coin];
                }
            }

            sb.append(count[M]).append('\n');
        }

        System.out.println(sb);
    }
}
