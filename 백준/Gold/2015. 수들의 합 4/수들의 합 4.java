import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1L);   // 아무것도 선택 안한 경우

        long sum = 0;    // 현재까지 누적합
        long count = 0;  // 결과

        for (int i = 0; i < N; i++) {
            sum += nums[i];

            if (prefixSumCount.containsKey(sum - K)) {
                count += prefixSumCount.get(sum - K);
            }

            // 현재 누적합을 HashMap에 저장
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0L) + 1);
        }
        System.out.println(count);
    }
}