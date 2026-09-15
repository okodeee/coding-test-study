import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[201];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            cnt[x1 + 100]++;
            cnt[x2 + 100]--;
        }
        // Please write your code here.

        int sum = 0;
        int answer = 0;
        for (int i = 0; i <= 200; i++) {
            sum += cnt[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}