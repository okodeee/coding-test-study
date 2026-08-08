import java.util.*;
import java.io.*;

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

            graph[v].add(new Edge(u, d));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Edge(N, 0));
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[N] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (dis[curr.node] < curr.weight) continue;

            for (Edge next : graph[curr.node]) {
                if (dis[next.node] > dis[curr.node] + next.weight) {
                    dis[next.node] = dis[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, dis[next.node]));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N-1; i++) {
            answer = Math.max(answer, dis[i]);
        }

        System.out.println(answer);
    }
}