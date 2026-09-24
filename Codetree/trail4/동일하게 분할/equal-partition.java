import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // Please write your code here.
        if (sum % 2 != 0) {
            System.out.println("No");
            return;
        }

        int target = sum / 2;

        boolean[] memo = new boolean[target + 1];
        memo[0] = true; // 아무것도 선택하지 않으면 만들 수 있음

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            // 0-1 Knapsack problem
            for (int j = target; j >= num; j--) {
                if (memo[j - num]) memo[j] = true;
            }
        }

        System.out.println(memo[target] ? "Yes" : "No");

    }
}