import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static List<int[]>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 정보 받기
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree[u].add(new int[] { v, d });
            tree[v].add(new int[] { u, d });
        }

        // 두 노드 사이 정보
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(distance(u, v)).append('\n');
        }

        System.out.println(sb);
    }

    static int distance(int start, int end) {
        boolean[] visited = new boolean[N + 1];

        Queue<int[]> q = new LinkedList<>();
        for (int[] node : tree[start]) {
            visited[node[0]] = true;
            q.offer(node);
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            // 목적지 도착
            if (curr[0] == end) {
                return curr[1];
            }

            for (int[] node : tree[curr[0]]) {
                if (!visited[node[0]]) {
                    visited[node[0]] = true;
                    q.offer(new int[]{ node[0], curr[1] + node[1] });
                }
            }
        }

        return 0;
    }
}