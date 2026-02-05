import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];   // 누적합
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m + 1];   // 누적합
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];
        }

        Map<Integer, Integer> partialA = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int sum = A[i] - A[j];
                partialA.put(sum, partialA.getOrDefault(sum, 0) + 1);
            }
        }

        Map<Integer, Integer> partialB = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                int sum = B[i] - B[j];
                partialB.put(sum, partialB.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0L;
        for (int key : partialA.keySet()) {
            if (partialB.containsKey(T - key)) {
                answer += (long) partialA.get(key) * partialB.get(T - key);
            }
        }

        System.out.println(answer);
    }
}
