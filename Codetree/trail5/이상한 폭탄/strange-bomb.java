import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] R = new int[N];

        HashMap<Integer, Integer> latestIndex = new HashMap<>();
        for (int i = N-1; i >= 0; i--) {
            if (!latestIndex.containsKey(arr[i])) {
                R[i] = -1;
            } else {
                R[i] = latestIndex.get(arr[i]);
            }

            latestIndex.put(arr[i], i);
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {
            if (R[i] != -1 && R[i] - i <= K) {
                answer = Math.max(answer, arr[i]);
            }
        }

        System.out.println(answer);
    }
}