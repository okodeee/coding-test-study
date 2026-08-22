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
    static int[] sort;

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
        sort = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            uf[i] = i;

            if (st.nextToken().charAt(0) == 'a') {
                sort[i] = 1;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(u, v, d));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.x;
            int v = curr.y;

            if (sort[u] == sort[v]) continue;
            if (find(u) == find(v)) continue;

            answer += curr.d;
            
            union(u, v);
        }

        Set<Integer> dis = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            dis.add(find(uf[i]));
        }

        if (dis.size() > 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }
}