import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        seq = new int[N];
        
        choose(0);
    }

    static void choose(int curr) {
        if (curr >= N) {
            print(seq);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            seq[curr] = i;
            choose(curr + 1);
            
            visited[i] = false;
        }
    }

    static void print(int[] seq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }
}