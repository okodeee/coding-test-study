import java.io.*;
import java.util.*;


public class Main {
    static List<Node>[] graph;
    static boolean[] visited;
    static int maxDistance;  // 최대 거리
    static int farthestNode; // 가장 먼 노드

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 각 노드별 인접한 노드
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {   // 루트 노드 제외
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[parent].add(new Node(child, weight));
            graph[child].add(new Node(parent, weight));
        }

        // 1단계: 1번 노드에서 가장 먼 노드 찾기
        visited = new boolean[N + 1];
        maxDistance = 0;
        farthestNode = 1;
        dfs(1, 0);

        // 2단계: 찾은 노드에서 다시 가장 먼 노드까지의 거리 구하기
        // 이 거리가 트리의 지름
        visited = new boolean[N + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    // DFS로 현재 노드에서 가장 먼 노드와 거리 찾기
    static void dfs(int node, int distance) {
        visited[node] = true;

        // 현재까지의 거리가 최대 거리보다 크면 갱신
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        // 연결된 모든 노드 탐색
        for (Node next : graph[node]) {
            if (!visited[next.to]) {
                // 다음 노드로 이동 (현재 거리 + 간선 가중치)
                dfs(next.to, distance + next.weight);
            }
        }
    }
}