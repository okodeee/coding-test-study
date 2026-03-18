import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int E = 0;
    static boolean[][] board;
    static int[] dx = new int[] { 0, -1, 0 };
    static int[] dy = new int[] { -1, 0, 1 };
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new boolean[N + 1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) != 0;
                if (board[i][j]) E++;
            }
        }

        // 궁수 3명 배치
        archer(0, 0, new boolean[M]);

        System.out.println(result);
    }

    static void archer(int depth, int start, boolean[] position) {
        if (depth >= 3) {
            // 제거할 수 있는 적 수 구하기
            result = Math.max(result, playing(position));

            return;
        }

        for (int i = start; i < position.length; i++) {
            position[i] = true;
            archer(depth + 1, i + 1, position);
            position[i] = false;
        }
    }

    static int playing(boolean[] position) {
        boolean[][] curr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            curr[i] = board[i].clone();
        }

        int remain = E;
        int dead = 0;
        List<int[]> attacked;

        while (remain > 0) {
            attacked = new ArrayList<>();

            for (int k = 0; k < position.length; k++) {
                if (position[k] == true) {

                    boolean[][] visited = new boolean[N][M];
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { N - 1, k });

                    while (!q.isEmpty()) {
                        int[] currNode = q.poll();

                        if (curr[currNode[0]][currNode[1]]) {
                            // 몬스터가 있다면 공격
                            attacked.add(new int[]{ currNode[0], currNode[1] });
                            break;
                        }

                        for (int i = 0; i < 3; i++) {
                            int nx = currNode[0] + dx[i];
                            int ny = currNode[1] + dy[i];

                            int distance = Math.abs(nx - N) + Math.abs(ny - k);
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M || distance > D || visited[nx][ny])
                                continue;

                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }

                }
            }

            for (int[] enemy : attacked) {
                if (curr[enemy[0]][enemy[1]]) {
                    remain--;
                    dead++;
                    curr[enemy[0]][enemy[1]] = false;
                }
            }

            if (remain <= 0) break;

            // 적 이동
            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (curr[i][j]) {
                        // 맨 끝이면 게임에서 제외
                        if (i == N - 1) {
                            curr[i][j] = false;
                            remain--;
                            continue;
                        }

                        curr[i + 1][j] = true;
                        curr[i][j] = false;
                    }
                }
            }

        }

        return dead;
    }
}
