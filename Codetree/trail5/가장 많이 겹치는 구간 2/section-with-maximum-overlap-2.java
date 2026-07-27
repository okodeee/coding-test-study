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

        int cross = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            cross += curr[1];

            answer = Math.max(answer, cross);
        }

        System.out.println(answer);
    }
}