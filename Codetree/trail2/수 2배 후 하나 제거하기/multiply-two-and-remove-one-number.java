import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {   // 2배 만들기
            arr[i] *= 2;

            for (int j = 0; j < n; j++) {   // 제거하기
                int[] remainingArr = new int[n-1];
                int cnt = 0;

                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    remainingArr[cnt++] = arr[k];
                }

                int sum = 0;
                for (int k = 0; k < n-2; k++) {
                    sum += Math.abs(remainingArr[k] - remainingArr[k+1]);
                }

                answer = Math.min(sum, answer);
            }

            arr[i] /= 2;
        }

        System.out.println(answer);
    }
}