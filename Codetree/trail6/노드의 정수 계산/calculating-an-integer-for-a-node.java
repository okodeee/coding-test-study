import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] node;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        node = new int[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            node[i] = (t==1) ? a : -a;
            graph[p].add(i);
        }

        dfs(1);

        System.out.println(node[1]);
    }

    static void dfs(int n) {

        for (int next : graph[n]) {
            dfs(next);

            if (node[next] > 0) {
                node[n] += node[next];
            }
        }
    }
}