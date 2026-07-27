import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0);

            if (d == 'R') {
                e = s + l;
                pq.offer(new int[] { s, 1 });
                pq.offer(new int[] { e, -1 });
            } else if (d == 'L') {
                e = s - l;
                pq.offer(new int[] { s, -1 });
                pq.offer(new int[] { e, 1 });
            }

            

            s = e;
        }

        int answer = 0;
        int cross = 0;
        int ncross = 0;
        int checked = 0;    // 적합한 구간의 시작점
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            ncross = cross + curr[1];

            if (cross < K && ncross >= K) {
                checked = curr[0];
                
            } else if (cross >= K && ncross < K) {
                answer += (curr[0] - checked);
                
            }

            cross = ncross;
        }

        System.out.println(answer);
    }
}