import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {a, 1});
            pq.offer(new int[] {b, -1});
        }

        int answer = 0;
        int v = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (curr[1] == 1) {
                if (v == 0) {
                    answer++;
                }
                v++;
            } else {
                v--;
            }
        }

        System.out.println(answer);
    }
}