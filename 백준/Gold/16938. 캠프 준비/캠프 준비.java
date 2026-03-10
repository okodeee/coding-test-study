import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] level = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        // 모든 부분집합 탐색 (비트마스킹)
        for (int mask = 0; mask < (1 << N); mask++) {
            // 선택된 문제 개수 체크
            if (Integer.bitCount(mask) < 2) continue;

            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += level[i];
                    min = Math.min(min, level[i]);
                    max = Math.max(max, level[i]);
                }
            }

            // 조건 검증
            if (sum >= L && sum <= R && (max - min) >= X) {
                count++;
            }
        }

        System.out.println(count);
    }
}