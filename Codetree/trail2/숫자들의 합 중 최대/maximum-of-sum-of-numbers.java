import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.
        int answer = 0;

        for (int n = x; n <= y; n++) {
            int sum = getSum(n);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }

        return sum;
    }
}