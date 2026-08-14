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
    static List<Edge>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, d));
            graph[v].add(new Edge(u, d));
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);

        int a = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[a] < distance[i]) a = i;
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        visited[a] = true;
        dfs(a);

        int b = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[b] < distance[i]) b = i;
        }

        System.out.println(distance[b]);
    }

    static void dfs(int n) {
        for (Edge next : graph[n]) {
            if (visited[next.node]) continue;

            distance[next.node] = distance[n] + next.weight;
            visited[next.node] = true;
            dfs(next.node);
        }
    }
}