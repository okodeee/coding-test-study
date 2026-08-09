import java.io.*;
import java.util.*;

class Edge {
    int node;
    int weight;

    public Edge(int n, int w) {
        this.node = n;
        this.weight = w;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, d));
            graph[v].add(new Edge(u, d));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Edge(A, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > dist[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (dist[next.node] > dist[curr.node] + next.weight) {
                    dist[next.node] = dist[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }

        System.out.println(dist[B]);
    }
}