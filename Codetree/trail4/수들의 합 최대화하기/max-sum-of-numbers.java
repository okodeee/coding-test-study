import java.util.*;
public class Main {
    static int n;
    static int[][] grid;
    static boolean[] selected;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        selected = new boolean[n];

        backtracking(0, 0);

        System.out.println(answer);
    }

    static void backtracking(int row, int sum) {
        if (row >= n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;

            selected[i] = true;
            backtracking(row + 1, sum + grid[row][i]);
            selected[i] = false;
        }
    }
}