import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int curr = 0;
            for (int j = 0; j < m; j++) {
                int person = sc.nextInt();
                curr |= (1 << person);
            }
            arr[i] = curr;
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] & arr[j]) == 0) answer++;
            }
        }

        System.out.println(answer);
    }
}