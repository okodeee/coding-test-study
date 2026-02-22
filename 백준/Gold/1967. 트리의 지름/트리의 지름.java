import java.io.*;
import java.util.*;

public class Main {

    static int[] distance;
    static int N;
    static List<Node>[] children;

    static class Node {

        int n;
        int d;

        Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        children = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            children[u].add(new Node(v, d));
            children[v].add(new Node(u, d));
        }

        // 루트로부터 가장 먼 노드 구하기
        bfs(1);
        int n1 = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[n1] < distance[i]) {
                n1 = i;
            }
        }

        // 그 노드로부터 가장 먼 노드 구하기
        bfs(n1);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, distance[i]);
        }

        System.out.println(max);
    }

    static void bfs(int s) {
        distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node next : children[curr.n]) {
                if (!visited[next.n]) {
                    visited[next.n] = true;
                    distance[next.n] = curr.d + next.d;
                    q.offer(new Node(next.n, distance[next.n]));
                }
            }
        }
    }
}
