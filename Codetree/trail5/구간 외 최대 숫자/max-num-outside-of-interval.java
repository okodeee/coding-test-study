import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] LM = new int[n];  // 0부터 i까지 중 최댓값
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) max = arr[i];

            LM[i] = max;
        }

        int[] RM = new int[n];  // n-1부터 i까지 중 최댓값
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (max < arr[i]) max = arr[i];

            RM[i] = max;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            max = 0;
            if (a-1 >= 0) max = Math.max(max, LM[a-1]);
            if (b+1 < n) max = Math.max(max, RM[b+1]);
            sb.append(max).append("\n");
        }
        
        System.out.println(sb);
    }
}