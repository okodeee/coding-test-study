import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {   // 제외할 점
            int x1 = 40001;
            int x2 = 0;
            int y1 = 40001;
            int y2 = 0;
            for (int j = 0; j < N; j++) {
                if (j == i) continue;

                x1 = Math.min(x1, x[j]);
                x2 = Math.max(x2, x[j]);
                y1 = Math.min(y1, y[j]);
                y2 = Math.max(y2, y[j]);
            }

            int area = (x2 - x1) * (y2 - y1);

            answer = Math.min(answer, area);
        }

        System.out.println(answer);
    }
}