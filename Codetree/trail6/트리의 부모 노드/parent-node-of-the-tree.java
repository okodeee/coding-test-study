import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        visited = new boolean[N+1];

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited[1] = true;
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
    
        System.out.println(sb);
    }

    static void dfs(int node) {
        for (int child : graph[node]) {
            if (visited[child]) continue;
            parents[child] = node;
            visited[child] = true;
            dfs(child);
        }
    }

}