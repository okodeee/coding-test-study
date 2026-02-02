import java.io.*;
import java.util.*;


public class Main {
    static int king = 0;    // 낚시왕의 열 위치
    static Shark[][] field;
    static int R, C;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        field = new Shark[R + 1][C + 1];

        // 상어 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            field[r][c] = new Shark(r, c, s, d, z);
        }

        int answer = 0;
        while(king++ < C) {
            for (int i = 1; i <= R; i++) {
                // 상어 잡기
                if (field[i][king] != null) {
                    answer += field[i][king].z;
                    field[i][king] = null;

                    break;
                }
            }
            // 상어 이동
            moveShark();
//            System.out.println(king);
//            printField();
        }

        System.out.println(answer);
    }

    static void moveShark() {
        List<Shark>[][] newField = new List[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                newField[i][j] = new ArrayList<Shark>();
            }
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (field[i][j] == null) continue;

                Shark curr = field[i][j];

                // 경계를 넘는 경우 방향 반대로
                int nx = i;
                int ny = j;
                for (int k = 0; k < curr.s; k++) {
                    if (curr.d == 1 && nx - 1 <= 0) {
                        curr.d = 2;
                    } else if (curr.d == 2 && nx + 1 > R) {
                        curr.d = 1;
                    }

                    if (curr.d == 3 && ny + 1 > C) {
                        curr.d = 4;
                    } else if (curr.d == 4 && ny - 1 <= 0) {
                        curr.d = 3;
                    }

                    nx += dx[curr.d - 1];
                    ny += dy[curr.d - 1];
                }
                newField[nx][ny].add(new Shark(nx, ny, curr.s, curr.d, curr.z));
            }
        }

        field = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                // 잡아먹기
                if (newField[i][j].size() >= 2) {
                    Shark maxShark = newField[i][j].get(0);
                    for (int k = 1; k < newField[i][j].size(); k++) {
                        Shark s = newField[i][j].get(k);
                        if (s.z > maxShark.z) {
                            maxShark = s;
                        }
                    }

                    field[i][j] = maxShark;
                } else if (!newField[i][j].isEmpty()) {
                    field[i][j] = newField[i][j].get(0);
                }
            }
        }
    }

    static void printField() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (field[i][j] != null) {
                    sb.append(field[i][j].z);
                } else {
                    sb.append('0');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
