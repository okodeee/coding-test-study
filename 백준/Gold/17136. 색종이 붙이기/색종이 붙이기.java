import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] paperCount = new int[6]; // 1x1 ~ 5x5 색종이 개수
    static int minPapers = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.fill(paperCount, 5);
        backtrack(0, 0, 0);
        
        System.out.println(minPapers == Integer.MAX_VALUE ? -1 : minPapers);
    }

    static void backtrack(int row, int col, int usedPapers) {
        if (row == 10) {
            minPapers = Math.min(minPapers, usedPapers);
            return;
        }
        
        if (usedPapers >= minPapers) return;
        
        int nextRow = col == 9 ? row + 1 : row;
        int nextCol = col == 9 ? 0 : col + 1;
        
        if (board[row][col] == 0) {
            backtrack(nextRow, nextCol, usedPapers);
            return;
        }
        
        for (int size = 5; size >= 1; size--) {
            if (paperCount[size] > 0 && canAttach(row, col, size)) {
                attach(row, col, size, 0);
                paperCount[size]--;
                
                backtrack(nextRow, nextCol, usedPapers + 1);
                
                attach(row, col, size, 1);
                paperCount[size]++;
            }
        }
    }

    static boolean canAttach(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) return false;
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }

    static void attach(int row, int col, int size, int value) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                board[i][j] = value;
            }
        }
    }
}