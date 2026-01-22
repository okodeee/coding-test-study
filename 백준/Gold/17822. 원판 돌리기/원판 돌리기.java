import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] disk;
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 원판 정보 입력
        disk = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                disk[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        printDisk();

        // 원판 회전 방법
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = x; j <= N; j += x) {
                rotate(j - 1, d, k);
            }

//            printDisk();

            if (!delete()) {    // 인접하면서 같은 수 삭제
                setNum();   // 없는 경우 숫자 재조정
            }

//            printDisk();
        }

        System.out.println(calculateSum());
    }

    // 원판 회전시키는 함수
    static void rotate(int x, int d, int k) {
        if (d == 0) {   // 시계 방향
            int[] temp = disk[x].clone();
            for (int i = 0; i < M; i++) {
                disk[x][(i + k) % M] = temp[i];
            }
        } else if (d == 1) {    // 반시계 방향
            int[] temp = disk[x].clone();
            for (int i = 0; i < M; i++) {
                disk[x][(i - k + M) % M] = temp[i];
            }
        }
    }

    static boolean delete() {
        boolean deletion = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (disk[i][j] != 0) {
                    if (dfs(i, j, disk[i][j])) {
                        disk[i][j] = 0; // 원판 숫자 삭제
                        deletion = true;
                    }
                }
            }
        }

        return deletion;
    }

    static boolean dfs(int n, int m, int num) {
        boolean deletion = false;

        for (int i = 0; i < 4; i++) {
            int nn = n + dx[i];
            int nm = (m + dy[i] + M) % M;

            if (nn >= 0 && nn < N && disk[nn][nm] == num) {
                disk[nn][nm] = 0;   // 원판 숫자 삭제
                deletion = true;
                dfs(nn, nm, num);
            }
        }

        return deletion;
    }

    static void setNum() {
        // 평균 구하기
        double avg = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (disk[i][j] != 0) {
                    avg += disk[i][j];
                    cnt++;
                }
            }
        }
        avg /= cnt;

        // 숫자 조정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (disk[i][j] != 0) {
                    if (disk[i][j] > avg) {
                        disk[i][j] -= 1;
                    } else if (disk[i][j] < avg) {
                        disk[i][j] += 1;
                    }
                }
            }
        }
    }

    static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += disk[i][j];
            }
        }

        return sum;
    }

    static void printDisk() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(disk[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
