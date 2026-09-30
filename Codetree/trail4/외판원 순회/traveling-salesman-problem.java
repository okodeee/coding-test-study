import java.util.*;

public class Main {
    static int n;
    static int[][] cost;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        visited = new boolean[n];
        visited[0] = true;

        backtracking(1, 0, 0);

        System.out.println(answer);
    }

    static void backtracking(int cnt, int prev, int sum) {
        if (cnt >= n) {
            if (cost[prev][0] > 0) {
                answer = Math.min(answer, sum + cost[prev][0]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || cost[prev][i] == 0) continue;

            visited[i] = true;
            backtracking(cnt + 1, i, sum + cost[prev][i]);
            visited[i] = false;
        }
    }
}