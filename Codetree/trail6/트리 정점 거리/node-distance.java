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
    static boolean[] visited;
    static int[] dis;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, d));
            graph[v].add(new Edge(u, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dis = new int[N+1];
            visited = new boolean[N+1];
            visited[x] = true;
            dfs(x);

            sb.append(dis[y]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int n) {
        for (Edge next : graph[n]) {
            if (visited[next.node]) continue;

            dis[next.node] = dis[n] + next.weight;
            visited[next.node] = true;
            dfs(next.node);
        }
        
    }
}