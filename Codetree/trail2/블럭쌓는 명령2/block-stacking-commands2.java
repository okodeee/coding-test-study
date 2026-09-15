import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] cnt = new int[N+1];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for (int j = A; j <= B; j++) {
                cnt[j]++;
            }
        }
        // Please write your code here.

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, cnt[i]);
        }

        System.out.println(answer);
    }
}