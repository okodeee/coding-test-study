import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        // 두 수의 합을 Set에 저장
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumSet.add(nums[i] + nums[j]);
            }
        }

        // 큰 수부터 확인 (최댓값을 찾아야 하므로)
        for (int k = N - 1; k >= 0; k--) {
            for (int c = 0; c < N; c++) {
                // nums[k] = (a + b) + nums[c]
                // → (a + b) = nums[k] - nums[c] 인지 확인
                int target = nums[k] - nums[c];

                if (sumSet.contains(target)) {
                    System.out.println(nums[k]);
                    return;
                }
            }
        }
    }
}