import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = st.nextToken().charAt(0);
            }
        }

        if (grid[0][0] == grid[R-1][C-1]) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        char start = grid[0][0];
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (grid[i][j] != start) {
                    for (int nx = i+1; nx < R-1; nx++) {
                        for (int ny = j+1; ny < C-1; ny++) {
                            if (grid[nx][ny] == start) answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}