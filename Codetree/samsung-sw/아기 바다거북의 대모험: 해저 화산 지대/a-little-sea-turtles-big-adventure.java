import java.util.*;
import java.io.*;

public class Main {
    // 이동 우선순위
    static int[] dr = new int[] { 0, 1, 0, -1 };
    static int[] dc = new int[] { 1, 0, -1, 0 };

    static class Turtle {
        int id, r, c, escapeTurn;
        boolean fossiled, escaped;

        public Turtle(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.escapeTurn = -1;
            this.fossiled = false;
            this.escaped = false;
        }
    }

    static class Volcano {
        int r, c, p, currentPressure;
        boolean eruptedThisTurn;

        public Volcano(int r, int c, int p) {
            this.r = r;
            this.c = c;
            this.p = p;
            this.currentPressure = 0;
            this.eruptedThisTurn = false;
        }
    }

    static int N, M, K;
    static int[][] grid;
    static List<Turtle> turtles = new ArrayList<>();
    static List<Volcano> volcanoes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            turtles.add(new Turtle(i + 1, r, c));
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            volcanoes.add(new Volcano(r, c, p));
        }

        simulate();

        StringBuilder sb = new StringBuilder();
        for (Turtle t : turtles) {
            sb.append(t.escapeTurn).append("\n");
        }
        System.out.println(sb);
    }

    static void simulate() {
        for (int turn = 1; turn <= 100; turn++) {
            
            // 1단계: 바다거북 이동
            for (Turtle t : turtles) {
                if (t.fossiled || t.escaped) continue;

                // 최단 경로 탐색
                int[] next = getNext(t.r, t.c);

                // 최단 경로 존재하지 않아 제자리에 머뭄
                if (next[0] == -1) continue;

                t.r = next[0];
                t.c = next[1];

                if (t.r == N - 1 && t.c == N - 1) {
                    t.escaped = true;
                    t.escapeTurn = turn;
                }
            }

            // 2단계: 화산 압력 증가
            for (Volcano v : volcanoes) {
                v.currentPressure += 10;
            }

            // 3단계: 화산 분출 및 연쇄 반응
            int[][] totalHeat = new int[N][N];
            boolean newEruption = true;

            while (newEruption) {
                newEruption = false;

                for (Volcano v : volcanoes) {
                    if (v.eruptedThisTurn) continue;

                    if (v.currentPressure + totalHeat[v.r][v.c] >= v.p) {
                        v.eruptedThisTurn = true;
                        newEruption = true;

                        // 3-1. 열기 전파
                        int vr = v.r;
                        int vc = v.c;
                        totalHeat[vr][vc] += v.p;

                        for (int d = 0; d < 4; d++) {
                            int power = v.p / 2;
                            int nr = vr + dr[d];
                            int nc = vc + dc[d];

                            while (inRange(nr, nc) && grid[nr][nc] != 1 && power > 0) {
                                totalHeat[nr][nc] += power;
                                power /= 2;
                                nr += dr[d];
                                nc += dc[d];
                            }
                        }
                    }
                }
            }

            // 3-3. 바다거북의 위기
            for (Turtle t : turtles) {
                if (t.fossiled || t.escaped) continue;

                if (totalHeat[t.r][t.c] >= 20) {
                    t.fossiled = true;
                }
            }

            // 4단계: 환경 초기화
            for (Volcano v : volcanoes) {
                if (v.eruptedThisTurn) {
                    v.currentPressure = 0;
                    v.eruptedThisTurn = false;
                }
            }
        }
    }

    static int[] getNext(int sr, int sc) {
        int tr = N - 1;
        int tc = N - 1;

        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        dist[tr][tc] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { tr, tc });

        boolean[][] hasTurtle = new boolean[N][N];
        for (Turtle t : turtles) {
            if (!t.escaped) hasTurtle[t.r][t.c] = true;
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!inRange(nr, nc) || grid[nr][nc] > 0 || hasTurtle[nr][nc] || dist[nr][nc] > 0) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[] { nr, nc });
            }
        }

        int minDist = Integer.MAX_VALUE;
        int[] nextPos = new int[] { sr, sc };
        for (int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if (!inRange(nr, nc) || dist[nr][nc] == -1) continue;

            if (minDist > dist[nr][nc]) {
                minDist = dist[nr][nc];
                nextPos[0] = nr;
                nextPos[1] = nc;
            }
        }

        return nextPos;
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}