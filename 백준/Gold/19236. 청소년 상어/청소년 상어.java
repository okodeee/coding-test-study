import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int result;

    static class Fish {
        int num;    // 상어는 num가 0
        int d;
        int x;
        int y;

        Fish(int n, int d, int x, int y) {
            this.num = n;
            this.d = d;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 물고기 위치 입력
        Fish[][] board = new Fish[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                board[i][j] = new Fish(a, b - 1, i, j);
            }
        }

        eatFish(-1, -1, 0, 0, 0, board);

        System.out.println(result);
    }

    static void eatFish(int sx, int sy, int nx, int ny, int sum, Fish[][] board) {
        // 상어가 (nx, ny) 위치의 물고기 먹음
        sum += board[nx][ny].num;
//        System.out.println(board[nx][ny].num + " " + nx + " " + ny + " " + sum);
        result = Math.max(result, sum);

        if (sx >= 0 && sy >= 0) {
            board[sx][sy] = null;
        }
        sx = nx;
        sy = ny;
        board[sx][sy].num = 0;

        // 번호가 작은 물고기부터 이동
        PriorityQueue<Fish> pq = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == null || board[i][j].num == 0) continue;

                pq.offer(board[i][j]);
            }
        }

        while (!pq.isEmpty()) {
            Fish curr = pq.poll();

            for (int i = 0; i < 8; i++) {
                int nd = (curr.d + i) % 8;
                nx = curr.x + dx[nd];
                ny = curr.y + dy[nd];

                // 경계를 넘어간다
                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
                    continue;

                // 상어가 있다
                if (board[nx][ny] != null && board[nx][ny].num == 0)
                    continue;

                // 빈 칸
                if (board[nx][ny] == null) {
                    board[curr.x][curr.y] = null;
                    curr.x = nx;
                    curr.y = ny;
                    board[nx][ny] = curr;

                    curr.d = nd;
                    break;

                } else {
                    Fish other = board[nx][ny];
                    other.x = curr.x;
                    other.y = curr.y;
                    board[other.x][other.y] = other;

                    curr.x = nx;
                    curr.y = ny;
                    board[nx][ny] = curr;

                    curr.d = nd;
                    break;
                }
            }
        }

        // 상어 이동
        for (int i = 1; i < 4; i++) {
            Fish shark = board[sx][sy];
            nx = sx + i * dx[shark.d];
            ny = sy + i * dy[shark.d];

            // 공간을 벗어난다
            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;

            // 물고기가 없다
            if (board[nx][ny] == null) continue;

            // 물고기 잡아먹기
            Fish[][] newBoard = new Fish[4][4];
            for (int k = 0; k < 4; k++) {
                for (int l = 0; l < 4; l++) {
                    if (board[k][l] != null) {
                        Fish f = board[k][l];
                        newBoard[k][l] = new Fish(f.num, f.d, f.x, f.y);
                    }
                }
            }

            eatFish(sx, sy, nx, ny, sum, newBoard);
        }
    }
}
