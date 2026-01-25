import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int mid = Integer.parseInt(br.readLine());
        sb.append(mid).append('\n');

        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> big = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            int curr = Integer.parseInt(br.readLine());
            if (curr > mid) {
                big.offer(curr);
            } else if (curr < mid) {
                small.offer(curr);
            } else {
                if (small.size() < big.size()) {
                    small.offer(curr);
                } else {
                    big.offer(curr);
                }
            }

            // 중앙값 조절
            if (small.size() > big.size()) {
                // small의 최댓값을 mid로
                big.offer(mid);
                mid = small.poll();
            } else if (small.size() + 1 < big.size()) {
                // big의 최솟값을 mid로
                small.offer(mid);
                mid = big.poll();
            }

            sb.append(mid).append('\n');
        }

        System.out.println(sb);
    }
}
