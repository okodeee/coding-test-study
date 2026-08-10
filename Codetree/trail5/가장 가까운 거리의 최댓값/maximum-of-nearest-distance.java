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

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());        
        int C = Integer.parseInt(st.nextToken());        

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

        int[] distA = new int[N+1]; // 시작점이 A
        int[] distB = new int[N+1];
        int[] distC = new int[N+1];
        Arrays.fill(distA, Integer.MAX_VALUE);
        Arrays.fill(distB, Integer.MAX_VALUE);
        Arrays.fill(distC, Integer.MAX_VALUE);
        distA[A] = 0;
        distB[B] = 0;
        distC[C] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.offer(new Edge(A, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > distA[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (distA[next.node] > distA[curr.node] + next.weight) {
                    distA[next.node] = distA[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, distA[next.node]));
                }
            }
        }

        pq.offer(new Edge(B, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > distB[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (distB[next.node] > distB[curr.node] + next.weight) {
                    distB[next.node] = distB[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, distB[next.node]));
                }
            }
        }

        pq.offer(new Edge(C, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > distC[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (distC[next.node] > distC[curr.node] + next.weight) {
                    distC[next.node] = distC[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, distC[next.node]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i == A || i == B || i == C) continue;

            int min = Math.min(distA[i], Math.min(distB[i], distC[i]));

            if (max < min) {
                max = min;
            }
        }

        System.out.println(max);
    }
}