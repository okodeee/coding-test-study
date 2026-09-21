import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        // Please write your code here.

        boolean[][] grid = new boolean[2001][2001];
        for (int i = rect1_x1 + 1000; i < rect1_x2 + 1000; i++) {
            for (int j = rect1_y1 + 1000; j < rect1_y2 + 1000; j++) {
                grid[i][j] = true;
            }
        }

        for (int i = rect2_x1 + 1000; i < rect2_x2 + 1000; i++) {
            for (int j = rect2_y1 + 1000; j < rect2_y2 + 1000; j++) {
                grid[i][j] = false;
            }
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        boolean hasTrue = false;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (grid[i][j]) {
                    hasTrue = true;

                    if (i < minX) minX = i;
                    if (i > maxX) maxX = i;
                    if (j < minY) minY = j;
                    if (j > maxY) maxY = j;
                }
            }
        }

        if (!hasTrue) {
            System.out.println(0);
            return;
        }
        System.out.println((maxX - minX + 1) * (maxY - minY + 1));
    }
}