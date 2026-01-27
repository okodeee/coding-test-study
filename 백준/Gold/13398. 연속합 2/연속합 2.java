import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][0]: i번째 원소를 반드시 포함, 제거 안 함
        // dp[i][1]: i번째 원소를 반드시 포함, 1개 제거함
        int[][] dp = new int[n][2];

        // 초기화: 첫 번째 원소
        dp[0][0] = nums[0];
        dp[0][1] = 0; // 첫 번째를 제거하면 아무것도 선택 안 함 (불가능)

        int answer = nums[0]; // 최댓값 추적

        for (int i = 1; i < n; i++) {
            // 제거 안 한 경우: 이전 연속합 + 현재 vs 현재부터 새로 시작
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);

            // 1개 제거한 경우:
            // 1) 이미 제거했던 연속합 + 현재
            // 2) 이전까지 제거 안 했는데 i-1을 제거 (i만 포함)
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);

            // 매 단계마다 최댓값 갱신
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
    }
}
