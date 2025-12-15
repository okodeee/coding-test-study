import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("end")) {

            char[][] field = new char[3][3];
            int xCount = 0;
            int oCount = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    field[i][j] = input.charAt(3 * i + j);
                    if (field[i][j] == 'X') {
                        xCount++;
                    } else if (field[i][j] == 'O') {
                        oCount++;
                    }
                }
            }

            // X 개수가 O보다 하나 많거나 같다.
            if (!(xCount == oCount || xCount == oCount + 1)) {
                sb.append("invalid\n");
                continue;
            }

            // 우승은 하나만
            boolean xWin = isXWin(field);
            boolean oWin = isOWin(field);

            if (xWin && oWin) {
                sb.append("invalid\n");
                continue;
            } else if (xWin && (xCount <= oCount)) {
                sb.append("invalid\n");
                continue;
            } else if (oWin && (xCount != oCount)) {
                sb.append("invalid\n");
                continue;
            } else if (!oWin && !xWin && xCount != 5 && oCount != 4) {
                sb.append("invalid\n");
                continue;
            }

            sb.append("valid\n");
        }

        System.out.println(sb);
    }

    static boolean isXWin(char[][] field) {
        if (field[0][0] == 'X') {
            if (field[0][1] == 'X' && field[0][2] == 'X') return true;
            if (field[1][1] == 'X' && field[2][2] == 'X') return true;
            if (field[1][0] == 'X' && field[2][0] == 'X') return true;
        }

        if (field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X') return true;
        if (field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X') return true;
        if (field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X') return true;
        if (field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X') return true;
        if (field[0][2] == 'X' && field[1][1] == 'X' && field[2][0] == 'X') return true;

        return false;
    }

    static boolean isOWin(char[][] field) {
        if (field[0][0] == 'O') {
            if (field[0][1] == 'O' && field[0][2] == 'O') return true;
            if (field[1][1] == 'O' && field[2][2] == 'O') return true;
            if (field[1][0] == 'O' && field[2][0] == 'O') return true;
        }

        if (field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O') return true;
        if (field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O') return true;
        if (field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O') return true;
        if (field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O') return true;
        if (field[0][2] == 'O' && field[1][1] == 'O' && field[2][0] == 'O') return true;

        return false;
    }
}