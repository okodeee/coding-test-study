import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        Arrays.fill(arr, 100001);
        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (i - 2 >= 0) {
                arr[i] = Math.min(arr[i], arr[i-2] + 1);
            }

            if (i - 5 >= 0) {
                arr[i] = Math.min(arr[i], arr[i-5] + 1);
            }
        }

        System.out.println(arr[N] == 100001 ? -1 : arr[N]);
    }
}