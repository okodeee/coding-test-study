import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.

        int[] days = new int[] { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] months = new String[] { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
        int index = 0;
        for (int i = 0; i < 7; i++) {
            if (months[i].equals(A)) {
                index = i;
                break;
            }
        }
        int t1 = d1;
        for (int i = 1; i < m1; i++) t1 += days[i];
        int t2 = d2;
        for (int i = 1; i < m2; i++) t2 += days[i];

        int diff = t2 - t1;

        int answer = diff / 7;
        if (diff % 7 >= index) answer++;

        System.out.println(answer);
    }
}