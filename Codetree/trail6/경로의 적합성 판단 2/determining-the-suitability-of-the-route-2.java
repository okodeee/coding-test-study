import java.util.*;
import java.io.*;

public class Main {
    static int[] uf;

    static int find(int x) {
        if (uf[x] == x) {
            return x;
        }

        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        uf[X] = Y;
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        uf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x >= y) union(x, y);
            else union(y, x);
        }

        st = new StringTokenizer(br.readLine());
        int g = uf[Integer.parseInt(st.nextToken())];
        for (int i = 1; i < k; i++) {
            int t = uf[Integer.parseInt(st.nextToken())];
            if (find(t) != find(g)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}