import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (long i = A; i <= B; i++) {
            long left = 1;
            long right = M;
            long cnt = 0;

            while (left <= right) {
                cnt++;
                long mid = (left + right) / 2;
                
                if (mid < i) {
                    left = mid + 1;
                } else if (mid > i) {
                    right = mid - 1;
                } else if (mid == i) {
                    break;
                }
            }

            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }

        System.out.println(min + " " + max);
    }
}