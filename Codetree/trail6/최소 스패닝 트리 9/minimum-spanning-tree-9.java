import java.util.*;
import java.io.*;

class Edge {
    int n, w;

    Edge(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {
    static List<Edge>[] graph;

    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
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

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;
        prim(1);
    }

    static void prim(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.offer(new Edge(s, 0));

        int answer = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.n]) continue;

            visited[curr.n] = true;
            answer += curr.w;

            for (Edge next : graph[curr.n]) {
                if (visited[next.n]) continue;

                if (next.w < dist[next.n]) {
                    dist[next.n] = next.w; 
                    pq.offer(new Edge(next.n, next.w));
                }
            }
        }

        System.out.println(answer);
    }
}