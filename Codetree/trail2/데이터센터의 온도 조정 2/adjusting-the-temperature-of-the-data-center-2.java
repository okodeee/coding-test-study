import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        // Please write your code here.

        int answer = 0;
        for (int t = -1; t <= 1001; t++) {
            int sum = 0;
            for (int e = 0; e < n; e++) {
                if (t < ta[e]) sum += c;
                else if (ta[e] <= t && t <= tb[e]) sum += g;
                else sum += h;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}