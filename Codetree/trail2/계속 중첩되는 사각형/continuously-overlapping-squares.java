import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] grid = new int[201][201];   // 1: red, 2: blue
        for (int i = 0; i < n; i++) {
            int color = 2;
            if (i % 2 == 0) color = 1;

            for (int x = x1[i] + 101; x <= x2[i] + 100; x++) {
                for (int y = y1[i] + 101; y <= y2[i] + 100; y++) {
                    grid[x][y] = color;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < 201; i++) {
            for (int j = 1; j < 201; j++) {
                if (grid[i][j] == 2) answer++;
            }
        }

        System.out.println(answer);
    }
}
