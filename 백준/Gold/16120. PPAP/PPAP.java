import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= 4) {
                char fourth = stack.pop();
                char third = stack.pop();
                char second = stack.pop();
                char first = stack.pop();

                if (first == 'P' && second == 'P' && third == 'A' && fourth == 'P') {
                    stack.push('P');
                } else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                    stack.push(fourth);
                }
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
            return;
        }

        System.out.println("NP");
        return;

    }
}