import java.util.*;
import java.io.*;

class Edge {
    int n, w;

    Edge(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class Main {
    static int N;
    static int[][] graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
        graph = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], 1001);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w);
        }

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;
        prim(1);
    }

    static void prim(int s) {

        long answer = 0;

        for (int i = 1; i <= N; i++) {

            int minIndex = -1;

            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            answer += dist[minIndex];

            for (int j = 1; j <= N; j++) {
                if(graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], graph[minIndex][j]);
            }
        }

        System.out.println(answer);
    }
}