import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { N, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            visited[curr[0]] = true;

            // 동생 찾음
            if (curr[0] == K) {
                int count = 1;
                while(!q.isEmpty()) {
                    int[] n = q.poll();
                    if (n[0] == K && n[1] == curr[1]) count++;
                }

                System.out.println(curr[1]);
                System.out.println(count);
            }

            if (curr[0] - 1 >= 0 && !visited[curr[0] - 1]) {
                q.offer(new int[] { curr[0] - 1, curr[1] + 1 });
            }

            if (curr[0] + 1 <= 100000 && !visited[curr[0] + 1]) {
                q.offer(new int[] { curr[0] + 1, curr[1] + 1 });
            }

            if (curr[0] * 2 <= 100000 && !visited[curr[0] * 2]) {
                q.offer(new int[] { curr[0] * 2, curr[1] + 1 });
            }
        }
    }
}
