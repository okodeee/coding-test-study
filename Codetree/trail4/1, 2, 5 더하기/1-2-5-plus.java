import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N+1];
        DP[0] = 1;

        int[] seq = new int[] { 1, 2, 5 };
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                int num = seq[j];

                if (i - num >= 0 && DP[i - num] != 0) {
                    DP[i] += DP[i - num];
                    DP[i] = DP[i] % 10007;
                }
            }
        }

        System.out.println(DP[N]);
    }
}