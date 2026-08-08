import java.util.*;
import java.io.*;

class Edge {
    int node;
    int weight;

    public Edge(int n , int w) {
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

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[B] = 0;
        pq.offer(new Edge(B, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > dis[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (dis[next.node] > dis[curr.node] + next.weight) {
                    dis[next.node] = dis[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, dis[next.node]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dis[A]).append("\n").append(A).append(" ");

        int x = A;
        while (x != B) {
            int nextNode = N+1;

            for (Edge next : graph[x]) {
                if (dis[x] == dis[next.node] + next.weight) {
                    if (next.node < nextNode) {
                        nextNode = next.node;
                    }
                }
            }
            x = nextNode;
            sb.append(x + " ");
        }

        System.out.println(sb);
    }
}