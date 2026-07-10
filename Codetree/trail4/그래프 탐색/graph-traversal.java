import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 그래프 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[N + 1];
        DFS(1);

        print();
    }

    static void DFS(int num) {
        visited[num] = true;

        for (int i = 0; i < graph[num].size(); i++) {
            int next = graph[num].get(i);
            
            if (visited[next]) continue;

            DFS(next);
        }
    }

    static void print() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) count++;
        }

        System.out.println(count - 1);
    }
}