import java.util.*;
import java.io.*;

class Edge {
    int x;
    int y;
    int d;

    public Edge(int x, int y, int d) {
        this.x = x;
        this.y = y;
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

        uf = new int[N*M+1];
        for (int i = 1; i <= N*M; i++) {
            uf[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M-1; j++) {
                int d = Integer.parseInt(st.nextToken());

                pq.offer(new Edge(i*M + j + 1, i*M + j + 2, d));
            }
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int d = Integer.parseInt(st.nextToken());

                pq.offer(new Edge(i*M + j + 1, (i+1)*M + j + 1, d));
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.x;
            int v = curr.y;

            if (find(u) == find(v)) continue;

            answer += curr.d;
            
            union(u, v);
        }

        System.out.println(answer);
    }
}