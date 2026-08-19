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

        uf[X] = Y;
        cnt[Y] += cnt[X];
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        uf = new int[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            uf[i] = i;
            cnt[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);

            if (op == 'x') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                union(a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(cnt[find(a)]).append("\n");
            }
        }

        System.out.println(sb);
    }
}