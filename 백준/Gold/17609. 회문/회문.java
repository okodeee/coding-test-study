import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String input = br.readLine();
            sb.append(checkPalindrome(input)).append('\n');
        }

        System.out.println(sb);
    }

    static int checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 왼쪽 제거 or 오른쪽 제거
                if (isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1)) {
                    return 1;
                }
                return 2;
            }
            left++;
            right--;
        }

        return 0;
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}