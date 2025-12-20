import java.io.*;
import java.util.*;


public class Main {
    static int N, L;
    static int[][] map;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            isValid(1, i, 0, map[i][0], 0, 0); // 가로
            isValid(2, 0, i, map[0][i], 0, 0); // 세로
        }

        System.out.println(result);
    }

    static void isValid(int direction, int x, int y, int height, int seq, int rampSort) {
        // 지나갈 수 있는 길임
        if (x >= N || y >= N) {
            if (rampSort == 0) {  // 경사로가 완성된 경우만
                result++;
//                System.out.println(direction + " " + x + " " + y);
            }
            return;
        }

        if (direction == 1) {   // 가로
                if (height == map[x][y] && rampSort == 0) {    // 같은 높이
                    isValid(direction, x, y + 1, height, seq + 1, 0);
                } else if (height == map[x][y] + 1) {  // 높이 1 줄어듬
                    if ((rampSort == 2 && seq + 1 >= L) || (rampSort == 0 && L == 1)) {    // 길이가 L이 되어서 경사로 설치
                        isValid(direction, x, y + 1, height - 1, 0, 0);
                    } else if (rampSort == 2) {
                        isValid(direction, x, y + 1, height, seq + 1, 2);
                    } else {
                        isValid(direction, x, y + 1, height, 1, 2);
                    }
                } else if (height == map[x][y] - 1) {  // 높이 1 높아짐
                    if (rampSort == 0 && seq >= L) {    // 길이가 L이 되어서 경사로 설치
                        isValid(direction, x, y + 1, height + 1, 1, 0);
                    }
                }
        } else if (direction == 2) {   // 세로
                if (height == map[x][y] && rampSort == 0) {    // 같은 높이
                    isValid(direction, x + 1, y, height, seq + 1, 0);
                } else if (height == map[x][y] + 1) {  // 높이 1 줄어듬
                    if ((rampSort == 2 && seq + 1 >= L) || (rampSort == 0 && L == 1)) {    // 길이가 L이 되어서 경사로 설치
                        isValid(direction, x + 1, y, height - 1, 0, 0);
                    } else if (rampSort == 2) {
                        isValid(direction, x + 1, y, height, seq + 1, 2);
                    } else {
                        isValid(direction, x + 1, y, height, 1, 2);
                    }
                } else if (height == map[x][y] - 1) {  // 높이 1 높아짐
                    if (rampSort == 0 && seq >= L) {    // 길이가 L이 되어서 경사로 설치
                        isValid(direction, x + 1, y, height + 1, 1, 0);
                    }
                }
        }
    }
}