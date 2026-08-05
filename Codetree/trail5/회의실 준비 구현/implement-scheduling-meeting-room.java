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
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new int[] { s, e });
        }

        int answer = 0;
        int time = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (time <= curr[0]) {
                answer++;
                time = curr[1];
            }
        }

        System.out.println(answer);
    }
}