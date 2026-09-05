import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int u, v;
    double weight;

    public Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}

public class Main {
    static int[] uf;

    static int find(int x) {
        if (uf[x] == x) return x;
        return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if (X != Y) {
            uf[X] = Y;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        uf = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            edges.add(new Edge(u, v, weight));
        }

        Collections.sort(edges);

        int totalWeight = 0;
        int selectedEdges = 0;

        for (Edge edge : edges) {
            if (selectedEdges == N - 2) {
                break;
            }

            if (union(edge.u, edge.v)) {
                totalWeight += edge.weight;
                selectedEdges++;
            }
        }

        System.out.println(totalWeight);
    }
}
