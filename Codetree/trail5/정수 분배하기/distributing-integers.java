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

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int K = arr[0];

        int left = 1;
        int right = Integer.MAX_VALUE - 1;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                left = mid + 1;
                ans = mid;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    // n이 M개가 나오는지 판단
    static boolean isPossible(int n) {
        // 현재까지 개수
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += arr[i] / n;
        }

        return cnt >= M;
    }
}