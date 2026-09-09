import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static int[][] dp;  // { 가장 큰 압력도, 반복된 횟수 }
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        dp = new int[N+1][2];
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i][0] = 1;
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int e = q.poll();

            for (int next : graph[e]) {
                indegree[next]--;
                
                if (dp[next][0] == dp[e][0]) dp[next][1]++;
                else if (dp[next][0] < dp[e][0]) {
                    dp[next][0] = dp[e][0];
                    dp[next][1] = 1;
                }

                if (indegree[next] == 0) {
                    q.offer(next);
                    if (dp[next][1] > 1) dp[next][0]++;
                    answer = Math.max(answer, dp[next][0]);
                }
            }
        }

        System.out.println(answer);
    }
}