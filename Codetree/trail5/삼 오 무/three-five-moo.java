import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long left = 1;
        long right = Integer.MAX_VALUE;
        long ans = Integer.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (getNum(mid) >= N) {
                right = mid - 1;
                ans = mid;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static long getNum(long n) {
        long mooCnt = n / 3 + n / 5 - n / 15;
        return n - mooCnt;
    }
}