import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] isLeaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        double W = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        // 리프 구하기
        isLeaf = new boolean[N + 1];
        Arrays.fill(isLeaf, true);
        getLeaf(1);

        // 정점에 쌓인 물의 양 평균 구하기
        int leaf = 0;
        for (int i = 2; i <= N; i++) {
            if (!isLeaf[i]) continue;
            leaf++;
        }

        System.out.println(W / leaf);
    }

    static void getLeaf(int s) {
        Queue<Integer> q = new PriorityQueue<>();
        boolean[] visited = new boolean[isLeaf.length];

        visited[s] = true;
        q.offer(s);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for (int next : tree[curr]) {
                if (!visited[next]) {
                    isLeaf[curr] = false;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
