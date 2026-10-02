import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();

        }
        // Please write your code here.

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            int l1 = Math.abs(x[i-2] - x[i-1]) + Math.abs(y[i-2] - y[i-1]);
            int l2 = Math.abs(x[i-1] - x[i]) + Math.abs(y[i-1] - y[i]);
            int l3 = Math.abs(x[i-2] - x[i]) + Math.abs(y[i-2] - y[i]);

            sum += l1;

            max = Math.max(max, l1 + l2 - l3);
        }

        sum += Math.abs(x[n-1] - x[n-2]) + Math.abs(y[n-1] - y[n-2]);
        
        System.out.println(sum - max);
    }
}