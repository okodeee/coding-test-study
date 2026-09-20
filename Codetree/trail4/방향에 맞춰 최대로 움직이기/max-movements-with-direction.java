import java.util.*;

public class Main {
    static int n;
    static int[][] num, moveDir;
    // dp[x][y]: (x, y) 위치에서 시작해서 갈 수 있는 최대 이동 횟수
    static int[][] dp;

    static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.
        // DP 배열 초기화 (-1: 미방문)
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(move(r - 1, c - 1));
    }

    static int move(int x, int y) {
        // 이미 계산된 값이 있다면 그 값을 바로 반환 (메모이제이션)
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        // 기본적으로 현재 위치에서 더 이상 갈 곳이 없으면 이동 횟수는 0
        dp[x][y] = 0;
        
        int dir = moveDir[x][y] - 1;
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        // 한 줄로 쭉 전진하면서 경계를 벗어나기 전까지 탐색 (하나의 while문 사용)
        while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
            // 현재 칸보다 숫자가 큰 경우에만 이동 가능
            if (num[nx][ny] > num[x][y]) {
                // 다음 칸에서 얻을 수 있는 최대 이동 횟수 + 1 과 현재 최댓값 비교
                dp[x][y] = Math.max(dp[x][y], move(nx, ny) + 1);
            }
            nx += dx[dir];
            ny += dy[dir];
        }
        
        return dp[x][y];
    }
}