import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
        }
        // Please write your code here.
        int answer = 0;
        for (int x = 0; x <= 100; x++) {
            int candy = 0;
            // 커버 범위는 x - K부터 x + K까지
            for (int i = 0; i < n; i++) {
                if (positions[i] >= x - k && positions[i] <= x + k) candy += candies[i];
            }
            answer = Math.max(answer, candy);
        }

        System.out.println(answer);
    }
}