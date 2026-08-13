import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int leaf = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());

            if (p == -1) {
                root = i;
                continue;
            }

            graph[p].add(i);
        }

        visited = new boolean[N];
        int target = Integer.parseInt(br.readLine());
        if (target == root) {
            System.out.println(0);
            return;
        }
        visited[target] = true;

        dfs(root);

        System.out.println(leaf);
    }

    static void dfs(int node) {
        int child = 0;

        for (int next : graph[node]) {
            if (visited[next]) continue;

            visited[next] = true;
            child++;
            dfs(next);
        }

        if (child == 0) leaf++;
    }
}