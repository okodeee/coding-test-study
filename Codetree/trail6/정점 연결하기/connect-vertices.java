import java.util.*;
import java.io.*;

public class Main {
    static int[] uf;
    static int[] cnt;

    static int find(int x) {
        if (uf[x] == x) {
            return x;
        }

        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        int X = find(x);
        int Y = find(y);

        if (X == Y) return; 

        uf[Y] = X;
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        uf = new int[N+1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < N-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int a = 1;
        int b = 0;
        for (int i = 1; i <= N; i++) {
            if (find(i) != find(a)) {
                b = i;
                break;
            }
        }

        System.out.println(a + " " + b);
    }
}