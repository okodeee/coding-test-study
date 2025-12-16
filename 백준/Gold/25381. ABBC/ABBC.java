import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<Character> temp = new LinkedList<>();

        int result = 0;

        int aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                aCount++;
            }
        }

        // 뒤에서부터 B와 A 조합 찾기
        int bCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char curr = str.charAt(i);
            if (curr == 'B' && bCount < aCount) {
                bCount++;
            } else if (curr == 'B') {
                temp.add(curr);
            } else if (curr == 'A' && bCount > 0) {
                result++;
                aCount--;
                bCount--;
            } else if (curr == 'A') {
                aCount--;
            } else {
                temp.add(curr);
            }
        }

        // 뒤에서부터 C와 B 조합 찾기
        int cCount = 0;
        for (int i = 0; i < temp.size(); i++) {  // 역순으로 저장해둠
            char curr = temp.get(i);
            if (curr == 'C') {
                cCount++;
            } else if (curr == 'B' && cCount > 0) {
                result++;
                cCount--;
            }
        }

        System.out.println(result);
    }
}