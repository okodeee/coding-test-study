import java.util.*;
import java.io.*;

class Edge {
    int u, v;
    double weight;

    public Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class Main {
    static int[] uf;
    static int[][] points;

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

        uf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        points = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                edges.add(new Edge(i, j, Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2))));
            }
        }

        Collections.sort(edges, (o1, o2) -> Double.compare(o1.weight, o2.weight));

        double answer = 0;
        for (Edge curr : edges) {
            if (find(curr.u) == find(curr.v)) continue;

            answer += curr.weight;
            union(curr.u, curr.v);
        }

        System.out.printf("%.2f", answer);

    }
}