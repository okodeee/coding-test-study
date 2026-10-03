import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int answer = 0;
        for (int n = x; n <= y; n++) {
            if (isInteresting(n)) answer++;
        }

        System.out.println(answer);
    }

    static boolean isInteresting(int n) {
        int[] counting = new int[10];
        while (n > 0) {
            counting[n % 10]++;
            n /= 10;
        }

        Arrays.sort(counting);
        if (counting[8] == 1 && counting[7] == 0) return true;

        return false;
    }
}