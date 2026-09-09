import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static int[] time;
    static int[] dp;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        time = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p;
            while ((p = Integer.parseInt(st.nextToken())) != -1) {
                graph[p].add(i);
                indegree[i]++;
            }
            time[i] = t;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int e = q.poll();

            for (int next : graph[e]) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[e]);

                if (indegree[next] == 0) {
                    q.offer(next);
                    dp[next] = dp[next] + time[next];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append("\n");
        }

        System.out.println(sb);
    }
}