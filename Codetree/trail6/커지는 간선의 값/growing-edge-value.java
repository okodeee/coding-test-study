import java.util.*;
import java.io.*;

class Edge{
    int n, w;

    Edge(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {
    static int N, M, K;
    static long[] dist;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        prim(1);
    }

    static void prim(int n) {
        boolean[] visited = new boolean[N+1];

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Edge(n, 0));

        long answer = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.n]) continue;

            visited[curr.n] = true;

            answer += curr.w;

            for (Edge next : graph[curr.n]) {
                if (visited[next.n]) continue;

                if (dist[next.n] > next.w) {
                    dist[next.n] = next.w;
                    pq.offer(new Edge(next.n, next.w));
                }
            }
        }

        for (int i = 1; i <= N-2; i++) {
            answer += i * K;
        }

        System.out.println(answer);
    }
}