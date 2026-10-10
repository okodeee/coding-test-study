import java.io.*;
import java.util.*;

public class Main {
    // 반시계 방향: 상 좌 하 우
    static int[] dr = new int[] { -1, 0, 1, 0 };
    static int[] dc = new int[] { 0, -1, 0, 1 };

    static int N;
    static int[][] grid;
    static boolean[][] visited;

    // (r, c)가 격자 범위 내인지 확인
    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    // (sr, sc)에서 출발하는 bfs
    // 모든 바다 칸까지의 최단 거리 반환
    static int[][] bfs(int sr, int sc) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        dist[sr][sc] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!inRange(nr, nc) || grid[nr][nc] == 1 || dist[nr][nc] > -1) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[] { nr, nc });
            }
        }

        return dist;
    }

    static int[] getNext(int r, int c, int d) {
        int[] deltas = new int[] { 0, 1, -1, 2 };
        for (int delta : deltas) {
            int nd = (d + delta + 4) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if (!inRange(nr, nc) || grid[nr][nc] == 1 || visited[nr][nc]) continue;

            return new int[] { nr, nc, nd };
        }

        return new int[] { -1, -1, -1 };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken()) - 1;

        // 입력 방향을 내부 표현으로 변환
        // 입력: 상 하 좌 우
        int[] dirMap = { 0, 2, 1, 3 };
        d = dirMap[d];
        
        grid = new int[N][N];
        int total = 0;    // 바다 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) total++;
            }
        }
        
        visited = new boolean[N][N];
        visited[r][c] = true;
        System.out.println((r + 1) + " " + (c + 1));
        int cnt = 1;    // 방문한 바다

        while (cnt < total) {
            // 1단계: 인접 탐험
            while (true) {
                int[] next = getNext(r, c, d);

                if (next[0] == -1) break;

                r = next[0]; c = next[1]; d = next[2];
                visited[r][c] = true;
                cnt++;
                System.out.println((r + 1) + " " + (c + 1));
            }
            if (cnt >= total) break;

            // 2단계: 가장 가까운 바다로 이동
            int[][] distFrom = bfs(r, c);

            // 미방문 바다 칸 중 최소 거리인 칸 선택
            int tr = -1, tc = -1, minDist = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1 || visited[i][j] || distFrom[i][j] == -1) continue;
                    if (minDist > distFrom[i][j]) {
                        minDist = distFrom[i][j];
                        tr = i;
                        tc = j;
                    }
                }
            }

            if (tr == -1) break;

            // 목표 칸에서 BFS를 수행하여 경로 추적에 필요한 거리맵 구하기
            int[][] distTo = bfs(tr, tc);

            int[] priority = {1, 2, 3, 0};
            while (r != tr || c != tc) {
                for (int dir : priority) {
                    int nr = r + dr[dir], nc = c + dc[dir];
                    if (inRange(nr, nc) && grid[nr][nc] == 0 && distTo[nr][nc] == distTo[r][c] - 1) {
                        r = nr; c = nc; d = dir;
                        break;
                    }
                }
            }

            visited[r][c] = true;
            cnt++;
            System.out.println((r + 1) + " " + (c + 1));
        }
    }
}