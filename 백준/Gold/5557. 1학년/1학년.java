import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        memo = new long[N][21];    // [index][sum] = cases
        memo[0][nums[0]] = 1;

        System.out.println(dp(N - 2, nums[N - 1]));

    }

    static long dp(int index, int sum) {
        if (sum < 0 || sum > 20) return 0;

        if (index == 0) {
            return memo[index][sum];
        }

        if (memo[index][sum] > 0) return memo[index][sum];

        memo[index][sum] = dp(index - 1, sum - nums[index]) + dp(index - 1, sum + nums[index]);

        return memo[index][sum];
    }
}
