import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점수 얻기
        while (findLargest()) {
            // 격자 중력 작용
            applyGravity();

            // 90도 반시계 방향 회전
            rotate();

            // 격자 중력 작용
            applyGravity();
        }

        System.out.println(score);
    }

    /**
     * 점수를 얻는 함수
     * 크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면
     * 포함된 무지개 블록의 수가 가장 많은 블록 그룹,
     * 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것, 그 다음으로 열이 가장 큰 것을 찾는다.
     * 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B2점을 획득한다.
     * 블럭이 제거된 곳은 M+1로 표시
     */
    static boolean findLargest() {
        int total = 0, rainbow = 0;
        int bx = 0, by = 0;

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] > 0 && board[i][j] <= M) {
                    int[] curr = bfs(i, j, board[i][j]);

                    if (curr[0] < 2) continue;  // 크기 2 미만 제외

                    if (curr[0] > total || (curr[0] == total && curr[1] >= rainbow)) {
                        total = curr[0];
                        rainbow = curr[1];
                        bx = i;
                        by = j;
                    }
                }
            }
        }

        if (total < 2) return false;

        // 점수 얻기
        score += (int) Math.pow(total, 2);
        getRidOfBlock(bx, by);
        return true;
    }

    /**
     * (x, y)를 기준 블록으로 하는 블록 그룹의 크기와 포함된 무지개 블록을 리턴하는 함수
     */
    static int[] bfs(int x, int y, int color) {
        int total = 1, rainbow = 0;
        List<int[]> rainbowList = new ArrayList<>();  // 무지개 블록 위치 저장

        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] { x, y });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

                if (board[nx][ny] != color && board[nx][ny] != 0) continue;

                if (board[nx][ny] == 0) {
                    rainbow++;
                    rainbowList.add(new int[]{nx, ny}); // 무지개 위치 기록
                }

                total++;
                visited[nx][ny] = true;
                q.offer(new int[] { nx, ny });
            }
        }

        // 무지개 블록 visited 해제 (다른 그룹에서도 사용 가능하게)
        for (int[] pos : rainbowList) {
            visited[pos[0]][pos[1]] = false;
        }

        return new int[] { total, rainbow };
    }

    /**
     * (x, y)를 기준 블록으로 하는 블록 그룹 삭제하고 점수 얻기
     */
    static void getRidOfBlock(int x, int y) {
        int color = board[x][y];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] isDeleted = new boolean[N][N];

        board[x][y] = M + 1;
        isDeleted[x][y] = true;
        q.offer(new int[] { x, y });

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || isDeleted[nx][ny]) continue;

                if (board[nx][ny] != color && board[nx][ny] != 0) continue;

                board[nx][ny] = M + 1;
                isDeleted[nx][ny] = true;
                q.offer(new int[] { nx, ny });

            }
        }
    }

    /**
     * 격자에 중력을 작용시키는 함수
     * 격자에 중력이 작용하면 검은색 블록을 제외한 모든 블록이 행의 번호가 큰 칸으로 이동한다.
     * 이동은 다른 블록이나 격자의 경계를 만나기 전까지 계속 된다.
     */
    static void applyGravity() {
        for (int col = 0; col < N; col++) {
            for (int row = N - 2; row >= 0; row--) {
                if (board[row][col] == -1 || board[row][col] == M + 1) continue;

                int cur = row;
                while (cur + 1 < N && board[cur + 1][col] == M + 1) {
                    board[cur + 1][col] = board[cur][col];
                    board[cur][col] = M + 1;
                    cur++;
                }
            }
        }
    }

    /**
     * 격자가 90도 반시계 방향으로 회전한다.
     */
    static void rotate() {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[N - j - 1][i] = board[i][j];
            }
        }

        board = newBoard;
    }
}
