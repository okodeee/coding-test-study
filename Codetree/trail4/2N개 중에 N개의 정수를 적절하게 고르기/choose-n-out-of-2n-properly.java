import java.util.*;
public class Main {
    static int n, sum;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        select(0, 0, 0);
        
        System.out.println(answer);
    }

    static void select(int cnt, int idx, int curr) {
        if (cnt >= n) {
            answer = Math.min(answer, Math.abs(sum - curr - curr));
            return;
        }

        if (idx >= 2 * n) {
            return;
        }

        select(cnt, idx + 1, curr);
        select(cnt + 1, idx + 1, curr + arr[idx]);
    }
}