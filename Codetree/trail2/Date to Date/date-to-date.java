import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int t1 = d1;
        for (int i = 1; i < m1; i++) t1 += days[i];

        int t2 = d2;
        for (int i = 1; i < m2; i++) t2 += days[i];

        System.out.println(t2 - t1 + 1);
    }
}