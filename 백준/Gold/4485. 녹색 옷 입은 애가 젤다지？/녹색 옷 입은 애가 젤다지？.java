import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };

    static class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int problemNum = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(cave, N);
            sb.append("Problem ").append(problemNum++).append(": ").append(result).append('\n');
        }

        System.out.print(sb);
    }

    static int dijkstra(int[][] cave, int N) {
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        dist[0][0] = cave[0][0];
        pq.offer(new Node(0, 0, cave[0][0]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 이미 처리된 노드
            if (curr.cost > dist[curr.x][curr.y]) {
                continue;
            }

            // 목적지
            if (curr.x == N - 1 && curr.y == N - 1) {
                return curr.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCost = curr.cost + cave[nx][ny];

                    // 더 적은 비용으로 갈 수 있으면 갱신
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}