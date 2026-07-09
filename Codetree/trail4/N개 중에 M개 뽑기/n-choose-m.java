import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        choose(0, 0, new int[M]);
        
    }

    static void choose(int curr, int prev, int[] combi) {
        if (curr >= M) {
            print(combi);
            return;
        }

        for (int i = prev + 1; i <= N; i++) {
            combi[curr] = i;
            choose(curr + 1, i, combi);
        }
    }

    static void print(int[] combi) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(combi[i]).append(' ');
        }

        System.out.println(sb);
    }
}