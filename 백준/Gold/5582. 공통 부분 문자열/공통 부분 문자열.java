import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] st1 = br.readLine().toCharArray();
        char[] st2 = br.readLine().toCharArray();

        int size1 = st1.length;
        int size2 = st2.length;

        int[][] dp = new int[size1][size2];

        for (int i = 0; i < size1; i++) {
            if (st1[i] == st2[0]) {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < size2; i++) {
            if (st1[0] == st2[i]) {
                dp[0][i] = 1;
            }
        }

        int result = 0;
        for (int i = 1; i < size1; i++) {
            for (int j = 1; j < size2; j++) {
                if (st1[i] == st2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        System.out.println(result);
    }
}
