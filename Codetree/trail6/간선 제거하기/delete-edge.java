import java.util.*;
import java.io.*;

class Edge {
    int s;
    int e;
    int d;

    public Edge(int s, int e, int d) {
        this.s = s;
        this.e = e;
        this.d = d;
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

        uf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        int sum = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(u, v, d));
            sum += d;
        }

        int min = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.s;
            int v = curr.e;

            if (find(u) == find(v)) continue;

            min += curr.d;
            
            union(u, v);
        }

        System.out.println(sum - min);
    }
}
