import java.util.*;

public class Main {
    static int n, k, m;
    static int[][] grid;
    static int[][] startPoints;
    static int[] dx = new int[] { -1, 0, 0, 1 };
    static int[] dy = new int[] { 0, -1, 1, 0 };
    static int answer = 0;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> rockList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        int rock = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) rockList.add(new int[]{i, j});
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt();
            startPoints[i][1] = sc.nextInt();
        }
        // Please write your code here.
        visited = new boolean[n][n];

        // M개의 돌 치우기 조합 탐색
        // (돌 리스트의 시작 인덱스, 현재까지 선택한 돌의 개수)
        backtrack(0, 0);

        System.out.println(answer);
    }

    static void backtrack(int rockIdx, int selectCount) {
        if (selectCount >= m) {
            counting();
            return;
        }

        if (rockIdx >= rockList.size()) {
            return;
        }

        // 현재 돌을 치운다 (0으로 만듦)
        int[] currRock = rockList.get(rockIdx);
        grid[currRock[0]][currRock[1]] = 0;
        backtrack(rockIdx + 1, selectCount + 1);
        grid[currRock[0]][currRock[1]] = 1; // 원상 복구

        // 현재 돌을 치우지 않고 다음 돌로 넘어간다
        backtrack(rockIdx + 1, selectCount);
    }

    static void counting() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        q.clear();

        for (int s = 0; s < k; s++) {
            int r = startPoints[s][0] - 1;
            int c = startPoints[s][1] - 1;

            if (!visited[r][c]) {
                visited[r][c] = true;
                q.offer(new int[] {r, c});
                cnt++;
            }

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                
                for (int i = 0; i < 4; i++) {
                    int nx = curr[0] + dx[i];
                    int ny = curr[1] + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] == 1) continue;

                    cnt++;
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }

        answer = Math.max(answer, cnt);
    }
}