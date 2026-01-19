import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dijkstraTable; // 최단 경로 값 저장

    static class Node {
        int n;
        int weight;

        Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        dijkstra(1);

        System.out.println(dijkstraTable[N]);
    }

    static void dijkstra(int start) {
        visited = new boolean[N + 1];
        dijkstraTable = new int[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });

        Arrays.fill(dijkstraTable, Integer.MAX_VALUE);
        dijkstraTable[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 이미 방문한 노드는 스킵
            if (visited[curr.n]) continue;
            visited[curr.n] = true;

            for (Node next : graph[curr.n]) {
                if (dijkstraTable[curr.n] + next.weight < dijkstraTable[next.n]) {
                    dijkstraTable[next.n] = dijkstraTable[curr.n] + next.weight;
                    pq.add(new Node(next.n, dijkstraTable[next.n]));
                }
            }
        }
    }
}