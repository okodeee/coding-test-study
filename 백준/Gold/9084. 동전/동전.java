import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] counts = new int[M + 1];    // 금액을 만드는 방법의 수
            counts[0] = 1;  // 0원을 만드는 방법 1가지

            // 각 동전을 순서대로 사용
            for (int coin : coins) {
                for (int i = coin; i <= M; i++) {
                    counts[i] += counts[i - coin];
                }
            }

            sb.append(counts[M]).append('\n');
        }

        System.out.println(sb);
    }
}