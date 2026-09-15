import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cnt = new int[2001];

        int position = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.

            if (dir == 'R') { // 오른쪽
                cnt[position + 1000]++;
                cnt[position + x + 1000]--;

                position = position + x;
            } else if (dir == 'L') { // 왼쪽
                cnt[position + 1000]--;
                cnt[position - x + 1000]++;

                position = position - x;
            }
        }

        int sum = 0;
        int answer = 0;
        for (int i = 1; i <= 2000; i++) {
            sum += cnt[i];

            if (sum > 1) answer++;
        }

        System.out.println(answer);
    }
}
