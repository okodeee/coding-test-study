import java.util.*;
import java.io.*;

public class Main {
    static int K, N;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        choose(0, new int[N]);
        
    }

    static void choose(int curr, int[] seq) {
        if (curr >= N) {
            print(seq);
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (curr >= 2 && i == seq[curr - 1] && i == seq[curr - 2]) continue;

            seq[curr] = i;
            choose(curr + 1, seq);
        }
    }

    static void print(int[] seq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seq.length; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }
}