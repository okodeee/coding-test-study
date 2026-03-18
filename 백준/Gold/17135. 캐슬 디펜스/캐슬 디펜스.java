import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] board;
    static int[] dx = new int[] { 0, -1, 0 };
    static int[] dy = new int[] { -1, 0, 1 };
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 3명 배치 (M개 중 3개 선택)
        archer(0, 0, new int[3]);

        System.out.println(result);
    }

    static void archer(int depth, int start, int[] archers) {
        if (depth == 3) {
            result = Math.max(result, playing(archers));
            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = i;
            archer(depth + 1, i + 1, archers);
        }
    }

    static int playing(int[] archers) {
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = board[i].clone();
        }

        int killCount = 0;

        for (int turn = 0; turn < N; turn++) {
            List<int[]> targets = new ArrayList<>();

            // 각 궁수가 공격할 적 찾기
            for (int archerCol : archers) {
                int[] target = findTarget(map, archerCol);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (int[] enemy : targets) {
                if (map[enemy[0]][enemy[1]] == 1) {
                    killCount++;
                    map[enemy[0]][enemy[1]] = 0;
                }
            }

            // 적 이동 (아래로 한 칸)
            moveEnemies(map);
        }

        return killCount;
    }

    // 궁수 위치에서 공격할 적 찾기 (거리 우선, 같으면 왼쪽 우선)
    static int[] findTarget(int[][] map, int archerCol) {
        for (int dist = 1; dist <= D; dist++) {
            for (int col = 0; col < M; col++) {  // 왼쪽부터 탐색
                for (int row = N - 1; row >= 0; row--) {
                    if (map[row][col] == 1) {
                        int distance = Math.abs(N - row) + Math.abs(archerCol - col);
                        if (distance == dist) {
                            return new int[]{row, col};
                        }
                    }
                }
            }
        }

        return null;
    }

    static void moveEnemies(int[][] map) {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (i == N - 1) {
                    map[i][j] = 0;  // 마지막 행은 제거
                } else if (map[i][j] == 1) {
                    map[i + 1][j] = 1;
                    map[i][j] = 0;
                }
            }
        }
    }
}
