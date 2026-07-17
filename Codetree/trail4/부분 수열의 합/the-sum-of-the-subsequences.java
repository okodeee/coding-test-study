import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[M+1];
        Arrays.fill(DP, 100001);
        DP[0] = 0;

        for (int i = 0; i < N; i++) {
            int num = seq[i];

            for (int j = M; j >= num; j--) {
                if (DP[j - num] != 100001) {
                    DP[j] = Math.min(DP[j], DP[j - num] + 1);
                }
            }
        }

        System.out.println(DP[M] == 100001 ? "No" : "Yes");

    }
}