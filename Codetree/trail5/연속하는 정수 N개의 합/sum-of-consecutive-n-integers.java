import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while (true) {
            if (sum >= m) {
                if (sum == m) {
                    answer++;
                }
                sum -= arr[left];
                left++;
            } else if (right == n) {
                // sum < m 인데 right가 이미 끝에 도달함
                break;
            } else {
                sum += arr[right];
                right++;
            }
        }

        System.out.println(answer);
    }
}