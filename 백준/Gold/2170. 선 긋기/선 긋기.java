import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] = b[1];
            return a[0] - b[0];
        });

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new int[] { x, y });
        }

        int[] line = pq.poll();
        int length = line[1] - line[0];
        int curr = line[1];

        while (!pq.isEmpty()) {
            line = pq.poll();

            if (line[1] > curr) {
                if (line[0] > curr) {
                    length += (line[1] - line[0]);
                } else {
                    length += (line[1] - curr);
                }

                curr = line[1];
            }
        }

        System.out.println(length);
    }
}
