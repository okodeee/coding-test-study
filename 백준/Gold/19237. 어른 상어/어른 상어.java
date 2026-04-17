import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int n;  // 상어 번호
        int x;  // 상어의 x좌표
        int y;  // 상어의 y좌표
        int d;  // 현재 바라보고 있는 방향
        int[][] p = new int[4][4]; // 방향 우선순위

        Shark(int n, int x, int y) {
            this.n = n;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Shark[] sharks = new Shark[M + 1];
        int[][][] smell = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n > 0) {
                    sharks[n] = new Shark(n, i, j);
                    smell[i][j][0] = n;
                    smell[i][j][1] = k;
                }
            }
        }

        // 각 상어의 방향 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks[i].d = Integer.parseInt(st.nextToken()) - 1;
        }

        // 각 상어의 방향 우선순위 입력
        for (int s = 1; s <= M; s++) {
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    sharks[s].p[i][j] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int time = 0;
        int aliveCount = M;

        while (aliveCount > 1) {
            if (time >= 1000) {
                System.out.println(-1);
                return;
            }
            time++;

            // 1단계: 현재 smell 스냅샷 (이동 판단 기준)
            int[][][] curSmell = new int[N][N][2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    curSmell[i][j][0] = smell[i][j][0];
                    curSmell[i][j][1] = smell[i][j][1];
                }
            }

            // 2단계: 모든 상어 이동
            int[][] next = new int[N][N];
            for (int s = 1; s <= M; s++) {
                if (sharks[s] == null) continue;
                Shark shark = sharks[s];
                boolean moved = false;

                // 냄새 없는 칸 우선
                for (int p = 0; p < 4; p++) {
                    int dir = shark.p[shark.d][p];
                    int nx = shark.x + dx[dir];
                    int ny = shark.y + dy[dir];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (curSmell[nx][ny][1] == 0) {
                        shark.x = nx;
                        shark.y = ny;
                        shark.d = dir;
                        moved = true;
                        break;
                    }
                }

                // 없으면 자기 냄새 칸으로
                if (!moved) {
                    for (int p = 0; p < 4; p++) {
                        int dir = shark.p[shark.d][p];
                        int nx = shark.x + dx[dir];
                        int ny = shark.y + dy[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (curSmell[nx][ny][0] == shark.n) {
                            shark.x = nx;
                            shark.y = ny;
                            shark.d = dir;
                            break;
                        }
                    }
                }

                // 충돌 처리 (작은 번호 우선)
                int cx = shark.x;
                int cy = shark.y;
                if (next[cx][cy] == 0 || next[cx][cy] > shark.n) {
                    if (next[cx][cy] != 0) {
                        sharks[next[cx][cy]] = null;
                        aliveCount--;
                    }
                    next[cx][cy] = shark.n;

                } else {
                    sharks[s] = null;
                    aliveCount--;
                }
            }

            // 3단계: 냄새 감소
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (smell[i][j][1] > 0) {
                        smell[i][j][1]--;

                        if (smell[i][j][1] == 0) smell[i][j][0] = 0;
                    }
                }
            }

            // 4단계: 이동한 칸 냄새 갱신
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (next[i][j] > 0) {
                        smell[i][j][0] = next[i][j];
                        smell[i][j][1] = k;
                    }
                }
            }
        }

        System.out.println(time);
    }
}
