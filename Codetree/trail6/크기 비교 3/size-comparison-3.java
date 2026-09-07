import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static PriorityQueue<Integer> pq = new PriorityQueue();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int e = pq.poll();
            sb.append(e).append(' ');

            for (int next : graph[e]) {
                indegree[next]--;
                if (indegree[next] == 0) pq.offer(next);
            }
        }

        System.out.println(sb);
    }
}