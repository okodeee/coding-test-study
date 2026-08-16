import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] score;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= N; i++) {
            p = Integer.parseInt(st.nextToken());
            graph[p].add(i);
        }

        score = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            score[t] += w;
        }

        propagate(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void propagate(int curr) {
        for (int next : graph[curr]) {
            score[next] += score[curr];
            propagate(next);
        }
    }
}
