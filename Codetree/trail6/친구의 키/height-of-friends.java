import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static Stack<Integer> reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        visited = new boolean[N+1];
        reverse = new Stack<Integer>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!reverse.isEmpty()) {
            sb.append(reverse.pop()).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int n) {
        visited[n] = true;

        for (int next : graph[n]) {
            if (!visited[next]) dfs(next);
        }

        reverse.push(n);
    }
}