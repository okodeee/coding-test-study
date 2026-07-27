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
            pq.offer(new int[] { Integer.parseInt(st.nextToken()), 1 });
            pq.offer(new int[] { Integer.parseInt(st.nextToken()), -1 });
        }

        int answer = 0;
        int cross = 0;
        int ncross = 0;
        int checked = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            ncross = cross + curr[1];

            if (cross < 1 && ncross >= 1) {
                checked = curr[0];
            } else if (cross >= 1 && ncross < 1) {
                answer += (curr[0] - checked);
            }

            cross = ncross;
        }

        System.out.println(answer);
    }
}