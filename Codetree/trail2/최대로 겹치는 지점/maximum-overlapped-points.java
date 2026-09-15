import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[101];

        for (int i = 0; i < n; i++) {
            int start= sc.nextInt();
            int end = sc.nextInt();
            cnt[start-1]++;
            cnt[end]--;
        }
        // Please write your code here.

        int sum = 0;
        int answer = 0;
        for (int i = 0; i <= 100; i++) {
            sum += cnt[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
