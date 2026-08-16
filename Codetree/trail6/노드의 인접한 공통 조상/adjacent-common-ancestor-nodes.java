import java.util.*;
import java.io.*;

public class Main {
    static int[] depth;
    static int[] parent;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        parent = new int[N+1];
        boolean[] isRoot = new boolean[N+1];
        Arrays.fill(isRoot, true);
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            isRoot[v] = false;
            graph[u].add(v);
            parent[v] = u;
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (isRoot[i]) root = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        depth = new int[N+1];
        dfs(root);

        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        System.out.println(a);
    }

    static void dfs(int n) {
        for (int next : graph[n]) {
            depth[next] = depth[n] + 1;
            dfs(next);
        }
    }
}