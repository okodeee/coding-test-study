import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        answer = new int[N+1];
        visited = new boolean[N+1];
        visited[R] = true;
        dfs(R);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(answer[q]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int root) {
        int cnt = 0;

        for (int next : graph[root]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }

            cnt += answer[next];
        }

        answer[root] = cnt + 1;
    }
}