import java.util.Scanner;
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
        boolean[][] area = new boolean[201][201];
        for (int i = 0; i < n; i++) {
            for (int r = x[i]; r < x[i] + 8; r++) {
                for (int c = y[i]; c < y[i] + 8; c++) {
                    area[r+100][c+100] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (area[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }
}