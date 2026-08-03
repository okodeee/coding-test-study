import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = Integer.MAX_VALUE;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, arr)) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static boolean isPossible(int len, int[] arr) {
        int cnt = 1;
        int diff = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - diff >= len) {
                cnt++;
                diff = arr[i];
            }
        }

        return cnt >= M;
    }
}