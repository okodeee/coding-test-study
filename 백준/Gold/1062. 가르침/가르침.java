import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] words;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 각 비트가 알파벳 존재 여부 의미
            for (int j = 0; j < word.length(); j++) {
                words[i] |= (1 << (word.charAt(j) - 'a'));
            }
        }

        if (K < 5) {
            // 'anta' 'tica' 불가능
            System.out.println(0);
            return;
        }

        // 배운 글자도 비트로 관리
        int learned = 0;
        learned |= (1 << ('a' - 'a'));
        learned |= (1 << ('n' - 'a'));
        learned |= (1 << ('t' - 'a'));
        learned |= (1 << ('i' - 'a'));
        learned |= (1 << ('c' - 'a'));

        backtrack(0, 5, learned);

        System.out.println(result);
    }

    static void backtrack(int start, int depth, int learned) {
        if (depth == K) {
            // 가능한 단어 개수 세서 결과값 갱신
            int count = 0;
            for (int i = 0; i < N; i++) {
                // 비트 AND 연산 O(1)
                if ((words[i] & learned) == words[i]) {
                    count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        // 개선: start부터 탐색 (조합)
        for (int i = start; i < 26; i++) {
            if ((learned & (1 << i)) == 0) {
                backtrack(i + 1, depth + 1, learned | (1 << i));
            }
        }
    }
}