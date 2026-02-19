import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] el = new int[N];
        for (int i = 0; i < N; i++) {
            el[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(el);

        // x + y 조합 미리 넣어놓기
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                set.add(el[i] + el[j]);
            }
        }

        // k 최댓값 찾기
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(el[i] - el[j])) {
                    System.out.println(el[i]);
                    return;
                }
            }
        }
    }
}