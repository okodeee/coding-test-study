import java.util.*;
import java.io.*;

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

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (find(u) == find(v)) cnt++;  // 끊는 연산 실행
            else union(u, v);
        }

        Set<Integer> dis = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            dis.add(find(uf[i]));
        }

        cnt += dis.size() - 1;

        System.out.println(cnt);
    }
}