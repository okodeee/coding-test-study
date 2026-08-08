import java.io.*;
import java.util.*;

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
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        int[] dis = new int[N+1];
        int[] path = new int[N+1];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[A] = 0;
        pq.offer(new Edge(A, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (curr.weight > dis[curr.node]) continue;

            for (Edge next : graph[curr.node]) {
                if (dis[curr.node] + next.weight < dis[next.node]) {
                    path[next.node] = curr.node;
                    dis[next.node] = dis[curr.node] + next.weight;
                    pq.offer(new Edge(next.node, dis[next.node]));
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        int s = B;
        while (s != A) {
            answer.add(path[s]);
            s = path[s];
        }

        StringBuilder sb = new StringBuilder(0);
        sb.append(dis[B]).append("\n");
        for (int i = answer.size() -1; i >= 0; i--) {
            sb.append(answer.get(i)).append(" ");
        }
        sb.append(B);

        System.out.println(sb);
    }
}