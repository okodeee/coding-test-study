import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int cost = 0;
        while (pq.size() > 1) {
            int v1 = pq.poll();
            int v2 = pq.poll();

            cost += v1;
            cost += v2;

            pq.offer(v1 + v2);
        }

        System.out.println(cost);
    }
}