import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] nums = new int[3];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        select(0, 0);
        
        System.out.println(answer);
    }

    static void select(int cnt, int idx) {
        if (cnt >= 3) {
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];

            if ((a & b) == 0 && (b & c) == 0 && (c & a) == 0) {
                int sum = a + b + c;
                answer = Math.max(answer, sum);
            }

            return;
        }

        if (idx >= n) {
            return;
        }

        select(cnt, idx + 1);
        nums[cnt] = arr[idx];
        select(cnt + 1, idx + 1);
    }
}