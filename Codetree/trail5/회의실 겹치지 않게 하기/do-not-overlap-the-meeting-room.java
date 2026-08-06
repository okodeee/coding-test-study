import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int time = pq.poll()[1];
        int answer = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] >= time) {
                answer++;
                time = curr[1];
            }
        }

        System.out.println(N - answer);
    }
}