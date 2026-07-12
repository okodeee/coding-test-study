import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println(1);
            return;
        }

        int[] fib = new int[N + 1];
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= N; i++) {
            fib[i] = fib[i-2] + fib[i-1];
        }

        System.out.println(fib[N]);
    }
}