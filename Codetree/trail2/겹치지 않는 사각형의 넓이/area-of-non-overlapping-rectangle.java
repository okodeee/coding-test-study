import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        // Please write your code here.

        boolean[][] area = new boolean[2001][2001];
        for (int x = ax1; x < ax2; x++) {
            for (int y = ay1; y < ay2; y++) {
                area[x+1000][y+1000] = true;
            }
        }
        for (int x = bx1; x < bx2; x++) {
            for (int y = by1; y < by2; y++) {
                area[x+1000][y+1000] = true;
            }
        }

        for (int x = mx1; x < mx2; x++) {
            for (int y = my1; y < my2; y++) {
                area[x+1000][y+1000] = false;
            }
        }

        int answer = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (area[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }
}