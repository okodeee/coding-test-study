import java.io.*;
import java.util.*;


public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        int leafCount = countLeaf(N);

        System.out.println((double)W / leafCount);
    }

    static int countLeaf(int N) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        int leafCount = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int childCount = 0;

            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                    childCount++;
                }
            }

            // 루트가 아니고 자식이 없으면 리프 노드
            if (node != 1 && childCount == 0) {
                leafCount++;
            }
        }
        
        if (leafCount == 0) {
            leafCount = 1;
        }

        return leafCount;
    }
}