import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N];
        Arrays.fill(DP, 1);
        for (int i = 1; i < N; i++) {
            // 앞에서 숫자가 작으면서,  DP 값이 제일 큰 것 + 1
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = N-1; i >= 0; i--) {
            answer = Math.max(answer, DP[i]);
        }

        System.out.println(answer);
    }
}