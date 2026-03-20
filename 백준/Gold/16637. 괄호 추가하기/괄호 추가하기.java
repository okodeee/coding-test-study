import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String expression;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        expression = br.readLine();

        calculate(0, 0, '+');

        System.out.println(result);
    }

    static void calculate(int index, int value, char preOp) {
        if (index == N) {
            result = Math.max(result, value);
            return;
        }

        char curr = expression.charAt(index);
        if (curr == '+' || curr == '-' || curr == '*') {
            calculate(index + 1, value, curr);
            return;
        }

        // 괄호 사용
        if (index < N - 2) {
            int next = parentheses(index);
            if (preOp == '+') {
                calculate(index + 3, value + next, preOp);
            } else if (preOp == '-') {
                calculate(index + 3, value - next, preOp);
            } else {
                calculate(index + 3, value * next, preOp);
            }
        }

        // 괄호 미사용
        int num = expression.charAt(index) - '0';
        if (preOp == '+') {
            calculate(index + 1, value + num, preOp);
        } else if (preOp == '-') {
            calculate(index + 1, value - num, preOp);
        } else {
            calculate(index + 1, value * num, preOp);
        }
    }

    static int parentheses(int i) {
        int num1 = expression.charAt(i) - '0';
        int num2 = expression.charAt(i + 2) - '0';
        char op = expression.charAt(i + 1);

        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
