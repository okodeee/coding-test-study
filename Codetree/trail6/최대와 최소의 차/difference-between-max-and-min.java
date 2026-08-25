import java.util.*;
import java.io.*;

class Edge {
    int u, v, t;

    public Edge(int u, int v, int t) {
        this.u = u;
        this.v = v;
        this.t = t;
    }
}

public class Main {
    static int[] uf;

    static int find(int x) {
        if (uf[x] == x) return x;
        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, t));
        }

        // 최소 비용 선택
        uf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }
        int cnt = 0;
        Collections.sort(edges, (o1, o2) -> o2.t - o1.t);
        for (Edge curr : edges) {
            if (find(curr.u) == find(curr.v)) continue;

            if (curr.t == 0) cnt++;

            union(curr.u, curr.v);
        }
        int minCost = cnt * cnt;

        // 최대 비용 선택
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }
        cnt = 0;
        Collections.sort(edges, (o1, o2) -> o1.t - o2.t);
        for (Edge curr : edges) {
            if (find(curr.u) == find(curr.v)) continue;

            if (curr.t == 0) cnt++;

            union(curr.u, curr.v);
        }
        int maxCost = cnt * cnt;

        System.out.println(maxCost - minCost);
    }
}