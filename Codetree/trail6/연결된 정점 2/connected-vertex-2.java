import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, Integer> uf;
    static Map<Integer, Integer> cnt;

    static int find(int x) {
        if (uf.get(x) == x) return x;
        uf.put(x, find(uf.get(x)));
        return uf.get(x);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X != Y) {
            cnt.put(Y, cnt.getOrDefault(X, 0) + cnt.getOrDefault(Y, 0));
        }

        uf.put(X, Y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        uf = new HashMap<>();
        cnt = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!uf.containsKey(u)) {
                uf.put(u, u);
                cnt.put(u, 1);
            }
            if (!uf.containsKey(v)) {
                uf.put(v, v);
                cnt.put(v, 1);
            }

            union(u, v);

            sb.append(cnt.get(find(u))).append("\n");
        }

        System.out.println(sb);
    }
}