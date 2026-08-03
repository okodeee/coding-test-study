import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long left = 1;
        long right = (long) arr[0] * N;
        long answer = Long.MAX_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(long t) {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            cnt += t / arr[i];

            if (cnt >= N) return true; 
        }

        return cnt >= N;
    }
}