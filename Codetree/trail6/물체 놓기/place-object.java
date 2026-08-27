import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dist;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        int min = 1;
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.parseInt(br.readLine());
            if (dist[min] > dist[i]) min = i;
        }

        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prim(min);

    }

    static void prim(int n) {
        int answer = dist[n];

        boolean[] visited = new boolean[N+1];
        visited[n] = true;

        for (int k = 1; k < N; k++) {
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (graph[n][i] < dist[i]) dist[i] = graph[n][i];
            }

            int next = 0;
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                if (next == 0 || dist[next] > dist[i]) next = i;
            }
            visited[next] = true;
            answer += dist[next];

            n = next;
        }

        System.out.println(answer);
    }
}