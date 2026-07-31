import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long left = 1;
        long right = 2000000000L;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= S) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}