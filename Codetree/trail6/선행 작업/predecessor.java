import java.util.*;
import java.io.*;

class Edge {
    int n;
    int w;

    public Edge(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

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
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        time = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                int p = Integer.parseInt(st.nextToken());
                graph[p].add(i);
            }
            time[i] = t;
            indegree[i] += c;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                dp[i] = time[i];
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            int e = q.poll();
            
            for (int next : graph[e]) {
                indegree[next]--;
                dp[next] = Math.max(dp[next], dp[e] + time[next]);
                answer = Math.max(answer, dp[next]);

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(answer);
    }
}