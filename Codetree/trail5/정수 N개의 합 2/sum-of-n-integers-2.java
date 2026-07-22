import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i + K <= N; i++) {
            answer = Math.max(answer, prefixSum[i + K] - prefixSum[i]);
        }

        System.out.println(answer);
    }
}