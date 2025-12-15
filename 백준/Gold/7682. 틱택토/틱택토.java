import java.io.*;
import java.util.*;

public class Main {
    static char[][] field = new char[3][3];
    static int xCount, oCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("end")) {

            xCount = 0;
            oCount = 0;
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

            if (isValid()) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isValid() {
        // X 개수가 O보다 하나 많거나 같다.
        if (!(xCount == oCount || xCount == oCount + 1)) {
            return false;
        }

        boolean xWin = won('X');
        boolean oWin = won('O');

        // 우승은 하나만
        if (xWin && oWin) {
            return false;
        }

        // X가 이겼다면 X 개수가 O 보다 하나 많다.
        if (xWin && (xCount <= oCount)) {
            return false;
        }

        // O가 이겼다면 X 개수와 같다.
        if (oWin && (xCount != oCount)) {
            return false;
        }

        // 아무도 안 이겼다면 게임판이 꽉 차야한다.
        if (!oWin && !xWin && xCount + oCount != 9) {
            return false;
        }

        return true;
    }

    static boolean won(char player) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == player &&
                field[i][1] == player &&
                field[i][2] == player) {
                return true;
            }
        }

        // 세로
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == player &&
                field[1][j] == player &&
                field[2][j] == player) {
                return true;
            }
        }

        // 대각선 ↘
        if (field[0][0] == player &&
            field[1][1] == player &&
            field[2][2] == player) {
            return true;
        }

        // 대각선 ↙
        if (field[0][2] == player &&
            field[1][1] == player &&
            field[2][0] == player) {
            return true;
        }

        return false;
    }
}