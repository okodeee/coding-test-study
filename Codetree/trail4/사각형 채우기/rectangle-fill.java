import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N+1];
        memo[1] = 1;
        memo[2] = 2;

        if (N < 3) {
            System.out.println(memo[N]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            memo[i] = (memo[i-2] + memo[i-1]) % 10007;
        }

        System.out.println(memo[N]);
    }
}