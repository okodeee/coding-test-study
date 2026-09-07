import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++; 
        }

        // 처음 indegree 값이 0인 곳이 시작점
        for(int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        
        // 위상정렬 진행
        int cnt = 0;
        while (!q.isEmpty()) {
            int e = q.poll();
            cnt++;

            for (int next : graph[e]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(cnt == N ? "Consistent" : "Inconsistent");
    }
}
