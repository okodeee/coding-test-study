import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] deg;

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

        deg = new int[N+1];
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1);

        System.out.println(cnt % 2 == 1 ? 1 : 0);
    }

    static void dfs(int n) {
        int child = 0;

        for (int next : graph[n]) {
            if (visited[next]) continue;

            child++;
            deg[next] = deg[n] + 1;

            visited[next] = true;
            dfs(next);
        }

        if (child == 0) {
            cnt += deg[n];
        }
    }
}