import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }

        PriorityQueue<int[]> selected = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        int answer = 0;
        int time = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] > selected.size()) {
                answer += curr[0];
                selected.offer(curr);
            }
            else if (!selected.isEmpty()) {
                int[] min = selected.peek();
                if (min[0] < curr[0]) {
                    selected.poll(); // 가장 점수가 낮은 것
                    answer -= min[0];
                    
                    answer += curr[0]; // 더 좋은 점수를 가진 현재 폭탄 추가
                    selected.offer(curr);
                }
            }
            time++;
        }
        System.out.println(answer);
    }
}