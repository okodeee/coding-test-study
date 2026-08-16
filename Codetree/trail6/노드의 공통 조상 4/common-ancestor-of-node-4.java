import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;
    static int[] parent;

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
            graph[u].add(v);
            graph[v].add(u);
        }

        depth = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            getParent(i);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (depth[a] != depth[b]) {
                if (depth[a] > depth[b]) a = parent[a];
                else b = parent[b];
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
            }

            sb.append(a).append("\n");
        }

        System.out.println(sb);
        
    }

    static void dfs(int n) {
        for (int next : graph[n]) {
            if (visited[next]) continue;

            depth[next] = depth[n] + 1;
            visited[next] = true;
            dfs(next);
        }
    }
    
    static void getParent(int n) {
        for (int next : graph[n]) {
            if (depth[next] == depth[n] - 1) {
                parent[n] = next;
                break;
            }
        }
    }
}