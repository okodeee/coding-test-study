import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] dis;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dis = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        choose(0, new int[K]);

        System.out.println(answer);
    }

    static void choose(int curr, int[] pieces) {
        if (curr >= N) {
            calculate(pieces);
            return;
        }

        for (int i = 0; i < K; i++) {
            int distance = dis[curr];

            pieces[i] += distance;
            choose(curr + 1, pieces);
            pieces[i] -= distance;
        }
    }

    static void calculate(int[] pieces) {
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (pieces[i] >= M - 1) {
                count++;
            }
        }

        answer = Math.max(answer, count);
    }
}