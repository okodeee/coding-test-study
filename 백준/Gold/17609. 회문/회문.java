import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();

            sb.append(isPalindrome(input, 0, input.length() - 1, false)).append('\n');
        }

        System.out.println(sb);
    }

    static int isPalindrome(String str, int s, int e, boolean skipped) {
        if (s >= e) {
            if (skipped) return 1;
            return 0;
        }

        if (str.charAt(s) == str.charAt(e)) {
            return isPalindrome(str, s + 1, e - 1, skipped);
        } else if (str.charAt(s) != str.charAt(e) && !skipped) {
            if (isPalindrome(str, s + 1, e, true) == 1 || isPalindrome(str, s, e - 1, true) == 1) {
                return 1;
            }
        }

        return 2;
    }
}