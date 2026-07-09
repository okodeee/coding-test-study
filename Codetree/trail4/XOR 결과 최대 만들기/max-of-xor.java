import java.util.Scanner;

public class Main {
    static int answer = 0;
    static int n, m;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        choose(0, 0, new int[m]);

        System.out.println(answer);
    }

    static void choose(int index, int start, int[] combi) {
        if (index >= m) {
            calculate(combi);
            return;
        }

        for (int i = start; i < n; i++) {
            combi[index] = A[i];
            choose(index + 1, i + 1, combi);
        }
    }

    static void calculate(int[] combi) {
        int num = combi[0];

        for (int i = 1; i < m; i++) {
            num ^= combi[i];
        }

        answer = Math.max(answer, num);
    }
}