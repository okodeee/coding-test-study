import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            // Please write your code here.
            int left = 0;
            int right = n-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (x < arr[mid]) {
                    right = mid - 1;
                } else if (x > arr[mid]) {
                    left = mid + 1;
                } else {
                    System.out.println(mid + 1);
                    break;
                }
            }

            if (left > right) {
                System.out.println(-1);
            }
        }
    }
}